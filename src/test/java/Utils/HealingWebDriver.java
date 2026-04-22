package Utils;

import org.openqa.selenium.*;
import org.testng.Reporter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HealingWebDriver implements WebDriver, JavascriptExecutor, TakesScreenshot {

    private static final ConcurrentMap<String, By> HEALED_CACHE = new ConcurrentHashMap<>();
    private static final Pattern QUOTED_TEXT = Pattern.compile("'([^']+)'|\"([^\"]+)\"");
    private static final String INTERACTIVE_SELECTOR =
            "button,input,textarea,select,a,[role='button'],[role='textbox'],[role='option'],[aria-label],[placeholder],[data-testid],[data-qa],[name],[id]";

    private final WebDriver delegate;

    public HealingWebDriver(WebDriver delegate) {
        this.delegate = delegate;
    }

    public static WebDriver wrap(WebDriver delegate) {
        if (delegate instanceof HealingWebDriver) {
            return delegate;
        }
        return new HealingWebDriver(delegate);
    }

    @Override
    public void get(String url) {
        delegate.get(url);
    }

    @Override
    public String getCurrentUrl() {
        return delegate.getCurrentUrl();
    }

    @Override
    public String getTitle() {
        return delegate.getTitle();
    }

    @Override
    public List<WebElement> findElements(By by) {
        try {
            return delegate.findElements(by);
        } catch (RuntimeException e) {
            WebElement healed = healElement(by, e);
            return healed == null ? new ArrayList<>() : List.of(healed);
        }
    }

    @Override
    public WebElement findElement(By by) {
        try {
            return delegate.findElement(by);
        } catch (NoSuchElementException | StaleElementReferenceException e) {
            WebElement healed = healElement(by, e);
            if (healed != null) {
                return healed;
            }
            throw e;
        }
    }

    @Override
    public String getPageSource() {
        return delegate.getPageSource();
    }

    @Override
    public void close() {
        delegate.close();
    }

    @Override
    public void quit() {
        delegate.quit();
    }

    @Override
    public Set<String> getWindowHandles() {
        return delegate.getWindowHandles();
    }

    @Override
    public String getWindowHandle() {
        return delegate.getWindowHandle();
    }

    @Override
    public TargetLocator switchTo() {
        return delegate.switchTo();
    }

    @Override
    public Navigation navigate() {
        return delegate.navigate();
    }

    @Override
    public Options manage() {
        return delegate.manage();
    }

    @Override
    public Object executeScript(String script, Object... args) {
        return ((JavascriptExecutor) delegate).executeScript(script, args);
    }

    @Override
    public Object executeAsyncScript(String script, Object... args) {
        return ((JavascriptExecutor) delegate).executeAsyncScript(script, args);
    }

    @Override
    public <X> X getScreenshotAs(OutputType<X> target) throws WebDriverException {
        return ((TakesScreenshot) delegate).getScreenshotAs(target);
    }

    private WebElement healElement(By originalBy, RuntimeException originalError) {
        String cacheKey = originalBy.toString();

        By cached = HEALED_CACHE.get(cacheKey);
        if (cached != null) {
            try {
                return delegate.findElement(cached);
            } catch (RuntimeException ignored) {
                HEALED_CACHE.remove(cacheKey);
            }
        }

        List<By> candidates = buildCandidates(originalBy);
        for (By candidate : candidates) {
            try {
                WebElement element = firstVisible(candidate);
                if (element != null) {
                    cacheHealedLocator(cacheKey, candidate);
                    logHealing(cacheKey, candidate);
                    return element;
                }
            } catch (RuntimeException ignored) {
                // try the next candidate
            }
        }

        WebElement bestMatch = scoreInteractiveElements(originalBy);
        if (bestMatch != null) {
            By healed = buildLocatorFromElement(bestMatch);
            if (healed != null) {
                cacheHealedLocator(cacheKey, healed);
                logHealing(cacheKey, healed);
            }
            return bestMatch;
        }

        logHealingFailure(cacheKey, originalError);
        return null;
    }

    private WebElement firstVisible(By by) {
        List<WebElement> matches = delegate.findElements(by);
        for (WebElement element : matches) {
            if (isVisible(element)) {
                return element;
            }
        }
        return matches.isEmpty() ? null : matches.get(0);
    }

    private boolean isVisible(WebElement element) {
        try {
            return element.isDisplayed();
        } catch (RuntimeException e) {
            return false;
        }
    }

    private List<By> buildCandidates(By originalBy) {
        String raw = originalBy.toString();
        String selector = raw.contains(": ") ? raw.substring(raw.indexOf(": ") + 2) : raw;
        List<By> candidates = new ArrayList<>();
        candidates.add(originalBy);

        String id = extractAttribute(selector, "id");
        if (id != null && !id.isBlank()) {
            candidates.add(By.id(id));
        }

        String name = extractAttribute(selector, "name");
        if (name != null && !name.isBlank()) {
            candidates.add(By.name(name));
        }

        String placeholder = extractAttribute(selector, "placeholder");
        if (placeholder != null && !placeholder.isBlank()) {
            candidates.add(By.xpath("//*[@" + "placeholder=" + xpathLiteral(placeholder) + "]"));
            candidates.add(By.xpath("//input[@" + "placeholder=" + xpathLiteral(placeholder) + "] | //textarea[@" + "placeholder=" + xpathLiteral(placeholder) + "]"));
        }

        String ariaLabel = extractAttribute(selector, "aria-label");
        if (ariaLabel != null && !ariaLabel.isBlank()) {
            candidates.add(By.xpath("//*[@" + "aria-label=" + xpathLiteral(ariaLabel) + "]"));
        }

        String text = extractText(selector);
        if (text != null && !text.isBlank()) {
            String tag = inferTag(selector);
            candidates.add(By.xpath("//" + tag + "[normalize-space()=" + xpathLiteral(text) + "]"));
            candidates.add(By.xpath("//" + tag + "[contains(normalize-space(), " + xpathLiteral(text) + ")]"));
            candidates.add(By.xpath("//*[normalize-space()=" + xpathLiteral(text) + "]"));
        }

        return candidates;
    }

    private WebElement scoreInteractiveElements(By originalBy) {
        String raw = originalBy.toString();
        String selector = raw.contains(": ") ? raw.substring(raw.indexOf(": ") + 2) : raw;
        List<String> tokens = extractTokens(selector);
        String inferredTag = inferTag(selector);

        List<WebElement> elements = delegate.findElements(By.cssSelector(INTERACTIVE_SELECTOR));
        WebElement best = null;
        int bestScore = 0;

        for (WebElement element : elements) {
            if (!isVisible(element)) {
                continue;
            }

            int score = scoreElement(element, tokens, inferredTag);
            if (score > bestScore) {
                bestScore = score;
                best = element;
            }
        }

        return bestScore >= 8 ? best : null;
    }

    private int scoreElement(WebElement element, List<String> tokens, String inferredTag) {
        int score = 0;
        String tag = safeLower(element.getTagName());
        if (!inferredTag.isEmpty() && inferredTag.equals(tag)) {
            score += 4;
        }

        String text = safeLower(element.getText());
        String ariaLabel = safeLower(element.getAttribute("aria-label"));
        String placeholder = safeLower(element.getAttribute("placeholder"));
        String title = safeLower(element.getAttribute("title"));
        String name = safeLower(element.getAttribute("name"));
        String id = safeLower(element.getAttribute("id"));
        String dataTestId = safeLower(element.getAttribute("data-testid"));
        String dataQa = safeLower(element.getAttribute("data-qa"));
        String value = safeLower(element.getAttribute("value"));

        for (String token : tokens) {
            if (token.isBlank()) {
                continue;
            }
            if (text.equals(token) || ariaLabel.equals(token) || placeholder.equals(token) || title.equals(token)) {
                score += 10;
            } else if (containsAny(text, token) || containsAny(ariaLabel, token) || containsAny(placeholder, token)
                    || containsAny(title, token) || containsAny(name, token) || containsAny(id, token)
                    || containsAny(dataTestId, token) || containsAny(dataQa, token) || containsAny(value, token)) {
                score += 4;
            }
        }

        if (!text.isBlank()) {
            score += 2;
        }
        if (!ariaLabel.isBlank()) {
            score += 3;
        }
        if (!placeholder.isBlank()) {
            score += 3;
        }
        if (!name.isBlank() || !id.isBlank() || !dataTestId.isBlank() || !dataQa.isBlank()) {
            score += 5;
        }

        return score;
    }

    private boolean containsAny(String source, String token) {
        return !source.isBlank() && source.contains(token);
    }

    private List<String> extractTokens(String selector) {
        List<String> tokens = new ArrayList<>();
        Matcher matcher = QUOTED_TEXT.matcher(selector);
        while (matcher.find()) {
            String token = matcher.group(1) != null ? matcher.group(1) : matcher.group(2);
            addTokens(tokens, token);
        }

        String cleaned = selector
                .replaceAll("By\\.[a-zA-Z]+:\\s*", " ")
                .replaceAll("[\\[\\]@()|=:/]", " ")
                .replaceAll("contains", " ")
                .replaceAll("normalize-space", " ");
        addTokens(tokens, cleaned);
        return tokens;
    }

    private void addTokens(List<String> tokens, String text) {
        if (text == null) {
            return;
        }
        Arrays.stream(text.toLowerCase().split("[^a-z0-9]+"))
                .filter(token -> !token.isBlank())
                .forEach(tokens::add);
    }

    private String extractAttribute(String selector, String attribute) {
        Pattern pattern = Pattern.compile(attribute + "\\s*=\\s*(['\"])(.*?)\\1");
        Matcher matcher = pattern.matcher(selector);
        if (matcher.find()) {
            return matcher.group(2);
        }
        return null;
    }

    private String extractText(String selector) {
        String text = extractAttribute(selector, "text");
        if (text != null) {
            return text;
        }

        Pattern pattern = Pattern.compile("contains\\s*\\(\\s*text\\s*\\(\\s*\\)\\s*,\\s*(['\"])(.*?)\\1\\s*\\)");
        Matcher matcher = pattern.matcher(selector);
        if (matcher.find()) {
            return matcher.group(2);
        }

        pattern = Pattern.compile("normalize-space\\s*\\(\\s*\\)\\s*=\\s*(['\"])(.*?)\\1");
        matcher = pattern.matcher(selector);
        if (matcher.find()) {
            return matcher.group(2);
        }

        return null;
    }

    private String inferTag(String selector) {
        String normalized = selector.toLowerCase();
        if (normalized.contains("//button") || normalized.contains("button[")) {
            return "button";
        }
        if (normalized.contains("//input") || normalized.contains("input[")) {
            return "input";
        }
        if (normalized.contains("//textarea") || normalized.contains("textarea[")) {
            return "textarea";
        }
        if (normalized.contains("//select") || normalized.contains("select[")) {
            return "select";
        }
        if (normalized.contains("//a") || normalized.contains("linktext")) {
            return "a";
        }
        if (normalized.contains("//span")) {
            return "span";
        }
        return "*";
    }

    private By buildLocatorFromElement(WebElement element) {
        String testId = safeAttr(element, "data-testid");
        if (!testId.isBlank()) {
            return By.xpath("//*[@" + "data-testid=" + xpathLiteral(testId) + "]");
        }

        String dataQa = safeAttr(element, "data-qa");
        if (!dataQa.isBlank()) {
            return By.xpath("//*[@" + "data-qa=" + xpathLiteral(dataQa) + "]");
        }

        String ariaLabel = safeAttr(element, "aria-label");
        if (!ariaLabel.isBlank()) {
            return By.xpath("//*[@" + "aria-label=" + xpathLiteral(ariaLabel) + "]");
        }

        String placeholder = safeAttr(element, "placeholder");
        if (!placeholder.isBlank()) {
            return By.xpath("//" + safeTag(element.getTagName()) + "[@" + "placeholder=" + xpathLiteral(placeholder) + "]");
        }

        String name = safeAttr(element, "name");
        if (!name.isBlank()) {
            return By.name(name);
        }

        String title = safeAttr(element, "title");
        if (!title.isBlank()) {
            return By.xpath("//" + safeTag(element.getTagName()) + "[@" + "title=" + xpathLiteral(title) + "]");
        }

        String text = safeText(element);
        if (!text.isBlank()) {
            return By.xpath("//" + safeTag(element.getTagName()) + "[normalize-space()=" + xpathLiteral(text) + "]");
        }

        String id = safeAttr(element, "id");
        if (isStableId(id)) {
            return By.id(id);
        }

        return null;
    }

    private boolean isStableId(String id) {
        if (id == null) {
            return false;
        }

        String value = id.trim();
        if (value.isEmpty()) {
            return false;
        }

        if (value.startsWith(":") && value.endsWith(":")) {
            return false;
        }

        if (value.length() < 4) {
            return false;
        }

        if (value.matches(".*[\\s'\"`].*")) {
            return false;
        }

        return !value.matches("(?i).*(generated|auto|react|mui|css|chakra|radix|chakraui|jss|emotion|sc-).*");
    }

    private String safeAttr(WebElement element, String attribute) {
        try {
            String value = element.getAttribute(attribute);
            return value == null ? "" : value.trim();
        } catch (RuntimeException e) {
            return "";
        }
    }

    private String safeText(WebElement element) {
        try {
            String value = element.getText();
            return value == null ? "" : value.trim();
        } catch (RuntimeException e) {
            return "";
        }
    }

    private String safeTag(String tag) {
        if (tag == null || tag.isBlank()) {
            return "*";
        }
        return tag.toLowerCase();
    }

    private String safeLower(String value) {
        return value == null ? "" : value.trim().toLowerCase();
    }

    private String xpathLiteral(String value) {
        if (value == null) {
            return "''";
        }
        if (!value.contains("'")) {
            return "'" + value + "'";
        }
        if (!value.contains("\"")) {
            return "\"" + value + "\"";
        }

        StringBuilder builder = new StringBuilder("concat(");
        String[] parts = value.split("'");
        for (int i = 0; i < parts.length; i++) {
            if (i > 0) {
                builder.append(", \"'\", ");
            }
            builder.append("'").append(parts[i]).append("'");
        }
        builder.append(")");
        return builder.toString();
    }

    private void cacheHealedLocator(String cacheKey, By healedBy) {
        HEALED_CACHE.put(cacheKey, healedBy);
    }

    private void logHealing(String original, By healedBy) {
        Reporter.log("Self-healed locator: " + original + " -> " + healedBy, true);
    }

    private void logHealingFailure(String original, RuntimeException error) {
        Reporter.log("Self-healing failed for locator: " + original + " :: " + error.getMessage(), true);
    }
}
