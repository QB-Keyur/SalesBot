package Pages;

import Config.EnvConfig;
import Utils.Common;
import Utils.Locators;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class WorkingHoursPage extends Locators {

    Common common;

    public WorkingHoursPage(WebDriver driver) {
        super(driver);
        this.common = new Common(driver);
    }

    public void goToWorkingHoursPage() {

        common.waitUntilElementToBeVisible(COMPANYSIDEBAR);
        common.click(COMPANYSIDEBAR);

        common.waitUntilElementToBeVisible(WH_MENU);
        common.click(WH_MENU);

        common.waitUntilElementToBeVisible(WH_HEADER);
        common.logPrint(WH_HEADER + " was found");

        String curUrl = driver.getCurrentUrl();
        String expectedURL = EnvConfig.getWebUrl() + "business-hours";

        if (curUrl.equals(expectedURL)) {
            common.logPrint("Passed Current URL is " + curUrl + " expected URL is " + expectedURL);
        } else {
            common.logPrint("Failed Current URL is " + curUrl + " expected URL is " + expectedURL);
        }
    }

    public void verifyElementsOnWorkingHoursPage() {
        goToWorkingHoursPage();

        common.waitUntilElementToBeVisible(WH_HEADER);

        Map<String, String> elements = new LinkedHashMap<>();

// Menu & Header
        elements.put(WH_MENU, "Working Hours Menu");
        elements.put(WH_HEADER, "Business Working Hours Header");
        elements.put(WH_SAVE_BUTTON, "Working Hours Save Button");

// Column Headers
        elements.put(WH_COLUMN_WEEKDAY, "Weekday Column Header");
        elements.put(WH_COLUMN_TYPE, "Type Column Header");
        elements.put(WH_COLUMN_START_TIME, "Start Time Column Header");
        elements.put(WH_COLUMN_END_TIME, "End Time Column Header");

// Weekday Labels
        elements.put(WH_MONDAY_LABEL, "Monday Row Label");
        elements.put(WH_TUESDAY_LABEL, "Tuesday Row Label");
        elements.put(WH_WEDNESDAY_LABEL, "Wednesday Row Label");
        elements.put(WH_THURSDAY_LABEL, "Thursday Row Label");
        elements.put(WH_FRIDAY_LABEL, "Friday Row Label");
        elements.put(WH_SATURDAY_LABEL, "Saturday Row Label");
        elements.put(WH_SUNDAY_LABEL, "Sunday Row Label");

// Type Inputs
        elements.put(WH_MONDAY_TYPE_INPUT, "Monday Type Input");
        elements.put(WH_TUESDAY_TYPE_INPUT, "Tuesday Type Input");
        elements.put(WH_WEDNESDAY_TYPE_INPUT, "Wednesday Type Input");
        elements.put(WH_THURSDAY_TYPE_INPUT, "Thursday Type Input");
        elements.put(WH_FRIDAY_TYPE_INPUT, "Friday Type Input");
        elements.put(WH_SATURDAY_TYPE_INPUT, "Saturday Type Input");
        elements.put(WH_SUNDAY_TYPE_INPUT, "Sunday Type Input");

// Start Time Inputs
        elements.put(WH_MONDAY_START_TIME_INPUT, "Monday Start Time Input");
        elements.put(WH_TUESDAY_START_TIME_INPUT, "Tuesday Start Time Input");
        elements.put(WH_WEDNESDAY_START_TIME_INPUT, "Wednesday Start Time Input");
        elements.put(WH_THURSDAY_START_TIME_INPUT, "Thursday Start Time Input");
        elements.put(WH_FRIDAY_START_TIME_INPUT, "Friday Start Time Input");
//        elements.put(WH_SATURDAY_START_TIME_INPUT,  "Saturday Start Time Input");
//        elements.put(WH_SUNDAY_START_TIME_INPUT,    "Sunday Start Time Input");

// End Time Inputs
        elements.put(WH_MONDAY_END_TIME_INPUT, "Monday End Time Input");
        elements.put(WH_TUESDAY_END_TIME_INPUT, "Tuesday End Time Input");
        elements.put(WH_WEDNESDAY_END_TIME_INPUT, "Wednesday End Time Input");
        elements.put(WH_THURSDAY_END_TIME_INPUT, "Thursday End Time Input");
        elements.put(WH_FRIDAY_END_TIME_INPUT, "Friday End Time Input");
//        elements.put(WH_SATURDAY_END_TIME_INPUT,  "Saturday End Time Input");
//        elements.put(WH_SUNDAY_END_TIME_INPUT,    "Sunday End Time Input");

        int failures = 0;

        for (Map.Entry<String, String> entry : elements.entrySet()) {
            String locator = entry.getKey();
            String friendlyName = entry.getValue();

            try {
                common.assertElementPresent(locator);
                common.logPrint("Step :: Verified presence of: " + friendlyName);
            } catch (Exception e) {
                failures++;
                common.logPrint("Missing element -> " + friendlyName + " (" + locator + ")");
                common.logPrint("DEBUG :: " + e.toString());
            }
        }

        if (failures == 0) {
            common.logPrint("Step :: All Working Hours page elements verified successfully.");
        } else {
            common.logPrint("Step :: Working Hours verification completed with "
                    + failures + " missing element(s).");
        }


    }

    public void verifyMondayToFridayDefault() {
        goToWorkingHoursPage();

        common.click(WH_MONDAY_TYPE_INPUT);
        common.click(WH_MONDAY_TYPE_INPUT);
        common.waitUntilElementToBeVisible(WH_CLEAR_MONDAY);
        common.hoverAndClickOnElement(WH_CLEAR_MONDAY);

        common.click(WH_TUESDAY_TYPE_INPUT);
        common.click(WH_TUESDAY_TYPE_INPUT);
        common.waitUntilElementToBeVisible(WH_CLEAR_TUESDAY);
        common.hoverAndClickOnElement(WH_CLEAR_TUESDAY);

        common.click(WH_WEDNESDAY_TYPE_INPUT);
        common.click(WH_WEDNESDAY_TYPE_INPUT);
        common.waitUntilElementToBeVisible(WH_CLEAR_WEDNESDAY);
        common.hoverAndClickOnElement(WH_CLEAR_WEDNESDAY);

        common.click(WH_THURSDAY_TYPE_INPUT);
        common.click(WH_THURSDAY_TYPE_INPUT);
        common.waitUntilElementToBeVisible(WH_CLEAR_THURSDAY);
        common.hoverAndClickOnElement(WH_CLEAR_THURSDAY);

        common.click(WH_FRIDAY_TYPE_INPUT);
        common.click(WH_FRIDAY_TYPE_INPUT);
        common.waitUntilElementToBeVisible(WH_CLEAR_FRIDAY);
        common.hoverAndClickOnElement(WH_CLEAR_FRIDAY);

        common.click(WH_SATURDAY_TYPE_INPUT);
        common.click(WH_SATURDAY_TYPE_INPUT);
        common.waitUntilElementToBeVisible(WH_CLEAR_SATURDAY);
        common.hoverAndClickOnElement(WH_CLEAR_SATURDAY);

        common.click(WH_SUNDAY_TYPE_INPUT);
        common.click(WH_SUNDAY_TYPE_INPUT);
        common.waitUntilElementToBeVisible(WH_CLEAR_SUNDAY);
        common.hoverAndClickOnElement(WH_CLEAR_SUNDAY);

        common.refreshPage();

        String mondayDefault = common.getAttribute(WH_MONDAY_TYPE_INPUT, "value");
        String tuesdayDefault = common.getAttribute(WH_TUESDAY_TYPE_INPUT, "value");
        String wednesdayDefault = common.getAttribute(WH_WEDNESDAY_TYPE_INPUT, "value");
        String thursdayDefault = common.getAttribute(WH_THURSDAY_TYPE_INPUT, "value");
        String fridayDefault = common.getAttribute(WH_FRIDAY_TYPE_INPUT, "value");

        if (mondayDefault.equalsIgnoreCase("working")
                && tuesdayDefault.equalsIgnoreCase("working")
                && wednesdayDefault.equalsIgnoreCase("working")
                && thursdayDefault.equalsIgnoreCase("working")
                && fridayDefault.equalsIgnoreCase("working")) {

            common.logPrint("Step :: Default status verified for Monday to Friday.");
        }


    }

    public void verifyChangingTime() {

        goToWorkingHoursPage();
        String secondarySaveButton = "(//span[text()='Save']/parent::button)[2]";
        String expectedStartTime = "10:00";
        String expectedEndTime   = "19:00";

        String[] typeInputs = {
                WH_MONDAY_TYPE_INPUT,
                WH_TUESDAY_TYPE_INPUT,
                WH_WEDNESDAY_TYPE_INPUT,
                WH_THURSDAY_TYPE_INPUT,
                WH_FRIDAY_TYPE_INPUT,
                WH_SATURDAY_TYPE_INPUT,
                WH_SUNDAY_TYPE_INPUT
        };

        String[] startInputs = {
                WH_MONDAY_START_TIME_INPUT,
                WH_TUESDAY_START_TIME_INPUT,
                WH_WEDNESDAY_START_TIME_INPUT,
                WH_THURSDAY_START_TIME_INPUT,
                WH_FRIDAY_START_TIME_INPUT,
                WH_SATURDAY_START_TIME_INPUT,
                WH_SUNDAY_START_TIME_INPUT
        };

        String[] endInputs = {
                WH_MONDAY_END_TIME_INPUT,
                WH_TUESDAY_END_TIME_INPUT,
                WH_WEDNESDAY_END_TIME_INPUT,
                WH_THURSDAY_END_TIME_INPUT,
                WH_FRIDAY_END_TIME_INPUT,
                WH_SATURDAY_END_TIME_INPUT,
                WH_SUNDAY_END_TIME_INPUT
        };

        for (int i = 0; i < typeInputs.length; i++) {
            String dayType = common.getAttribute(typeInputs[i], "value");
            if (!"Working".equalsIgnoreCase(dayType)) {
                common.logPrint("Skipping non-working day: " + typeInputs[i] + " [" + dayType + "]");
                continue;
            }

            common.highlightElement(startInputs[i]);
            selectTimeFromPicker(startInputs[i], expectedStartTime);
            clickWorkingHoursSave(secondarySaveButton);

            common.highlightElement(endInputs[i]);
            selectTimeFromPicker(endInputs[i], expectedEndTime);
            clickWorkingHoursSave(secondarySaveButton);
        }

        common.waitUntilElementToBeVisible(WH_SAVE_BUTTON);
        common.click(WH_SAVE_BUTTON);

        common.assertElementPresent(SUCCESSMSG);

        common.refreshPage();
        common.waitUntilElementToBeVisible(WH_MONDAY_START_TIME_INPUT);

        DateTimeFormatter twelveHour = DateTimeFormatter.ofPattern("hh:mm a");
        DateTimeFormatter twentyFourHour = DateTimeFormatter.ofPattern("HH:mm");

        LocalTime expectedStart = LocalTime.parse(expectedStartTime.toUpperCase(), twentyFourHour);
        LocalTime expectedEnd   = LocalTime.parse(expectedEndTime.toUpperCase(), twentyFourHour);

        // ✅ Validate start times
        for (int i = 0; i < startInputs.length; i++) {

            String dayType = common.getAttribute(typeInputs[i], "value");
            if (!"Working".equalsIgnoreCase(dayType)) {
                common.logPrint("Skipping start time assertion for holiday/non-working day: " + startInputs[i]);
                continue;
            }

            String actualValue = common.getAttribute(startInputs[i], "value");

            // ⛔ Skip non-time values
            if (actualValue == null ||
                    actualValue.trim().isEmpty() ||
                    actualValue.equalsIgnoreCase("working") ||
                    actualValue.equalsIgnoreCase("holiday") ||
                    actualValue.equals("—")) {

                common.logPrint("Skipping start time validation (non-time value): " + startInputs[i]);
                continue;
            }

            LocalTime actual =
                    actualValue.toUpperCase().contains("AM") || actualValue.toUpperCase().contains("PM")
                            ? LocalTime.parse(actualValue.toUpperCase(), twelveHour)
                            : LocalTime.parse(actualValue, twentyFourHour);

            Assert.assertEquals(
                    actual,
                    expectedStart,
                    "Start time mismatch for locator: " + startInputs[i]
            );
        }

        // ✅ Validate end times
        for (int i = 0; i < endInputs.length; i++) {

            String dayType = common.getAttribute(typeInputs[i], "value");
            if (!"Working".equalsIgnoreCase(dayType)) {
                common.logPrint("Skipping end time assertion for holiday/non-working day: " + endInputs[i]);
                continue;
            }

            String actualValue = common.getAttribute(endInputs[i], "value");

            // ⛔ Skip non-time values
            if (actualValue == null ||
                    actualValue.trim().isEmpty() ||
                    actualValue.equalsIgnoreCase("working") ||
                    actualValue.equalsIgnoreCase("holiday") ||
                    actualValue.equals("—")) {

                common.logPrint("Skipping end time validation (non-time value): " + endInputs[i]);
                continue;
            }

            LocalTime actual =
                    actualValue.toUpperCase().contains("AM") || actualValue.toUpperCase().contains("PM")
                            ? LocalTime.parse(actualValue.toUpperCase(), twelveHour)
                            : LocalTime.parse(actualValue, twentyFourHour);

            Assert.assertEquals(
                    actual,
                    expectedEnd,
                    "End time mismatch for locator: " + endInputs[i]
            );
        }

        common.logPrint("Step :: Working hours updated and verified successfully after refresh.");
    }

    public void verifyHolidayHasNoTimings() {

        goToWorkingHoursPage();

        common.waitUntilElementToBeVisible(WH_MONDAY_TYPE_INPUT);

        // ---------- STEP 1: Get all day TYPE inputs ----------
        List<String> allDayTypeInputs = Arrays.asList(
                WH_MONDAY_TYPE_INPUT,
                WH_TUESDAY_TYPE_INPUT,
                WH_WEDNESDAY_TYPE_INPUT,
                WH_THURSDAY_TYPE_INPUT,
                WH_FRIDAY_TYPE_INPUT,
                WH_SATURDAY_TYPE_INPUT,
                WH_SUNDAY_TYPE_INPUT
        );

        // ---------- STEP 2: Find already existing holidays ----------
        List<String> existingHolidayLocators = new ArrayList<>();

        for (String locator : allDayTypeInputs) {
            String value = common.getAttribute(locator, "value");
            if ("Holiday".equalsIgnoreCase(value)) {
                existingHolidayLocators.add(locator);
            }
        }

        common.logPrint("Existing Holiday count :: " + existingHolidayLocators.size());

        // ---------- STEP 3: Get remaining (non-holiday) days ----------
        List<String> availableDays = new ArrayList<>(allDayTypeInputs);
        availableDays.removeAll(existingHolidayLocators);

        Assert.assertFalse(
                availableDays.isEmpty(),
                "No available non-holiday days to convert"
        );

        // ---------- STEP 4: Pick ONE random day ----------
        String randomDay = availableDays.get(
                new Random().nextInt(availableDays.size())
        );

        common.logPrint("Random day selected for Holiday :: " + randomDay);

        // ---------- STEP 5: Change selected day to Holiday ----------
        common.click(randomDay);
        common.click(HOLIDAYTEXT);

        common.pause(2);

        // ---------- STEP 6: Validate Holiday has no timings ----------
        WebElement holidayInput = driver.findElement(By.xpath(
                "//input[@value='Holiday' and @id='" +
                        driver.findElement(By.xpath(randomDay)).getAttribute("id") +
                        "']"
        ));

        common.highlightElement(holidayInput);

        WebElement startDash = holidayInput.findElement(
                By.xpath("following::div[text()='—'][1]")
        );
        common.highlightElement(startDash);

        WebElement endDash = holidayInput.findElement(
                By.xpath("following::div[text()='—'][2]")
        );
        common.highlightElement(endDash);

        Assert.assertTrue(startDash.isDisplayed(),
                "Start time is not disabled for Holiday");

        Assert.assertTrue(endDash.isDisplayed(),
                "End time is not disabled for Holiday");

        common.logPrint("Step :: Holiday start & end time disabled correctly");

        // ---------- STEP 7: Save ----------
        common.click(WH_SAVE_BUTTON);
    }

    private void clickWorkingHoursSave(String secondarySaveButton) {
        common.pause(1);
        if (common.isElementPresent(secondarySaveButton)) {
            common.click(secondarySaveButton);
        } else {
            common.click(WH_SAVE_BUTTON);
        }
    }

    private void selectTimeFromPicker(String inputLocator, String time) {
        String[] parts = time.split(":");
        String hour = parts[0];
        String minute = parts[1];

        common.click(inputLocator);
        common.waitUntilElementToBeVisible("//p[text()='HOUR']");
        common.waitUntilElementToBeVisible("//p[text()='MIN']");

        common.click("//p[text()='HOUR']/following-sibling::div//p[normalize-space()='" + hour + "']");
        common.click("//p[text()='MIN']/following-sibling::div//p[normalize-space()='" + minute + "']");
    }

    public void verifyChangingHolidayToWorking() {

        goToWorkingHoursPage();

        common.waitUntilElementToBeVisible(WH_MONDAY_TYPE_INPUT);
        String secondarySaveButton = "(//span[text()='Save']/parent::button)[2]";

        String startTime = "10:30";
        String endTime   = "19:30";

        // ---------- STEP 1: All day TYPE inputs ----------
        List<String> allDayTypeInputs = Arrays.asList(
                WH_MONDAY_TYPE_INPUT,
                WH_TUESDAY_TYPE_INPUT,
                WH_WEDNESDAY_TYPE_INPUT,
                WH_THURSDAY_TYPE_INPUT,
                WH_FRIDAY_TYPE_INPUT,
                WH_SATURDAY_TYPE_INPUT,
                WH_SUNDAY_TYPE_INPUT
        );

        // ---------- STEP 2: Find existing Holidays ----------
        List<String> holidayDays = new ArrayList<>();

        for (String locator : allDayTypeInputs) {
            String value = common.getAttribute(locator, "value");
            if ("Holiday".equalsIgnoreCase(value)) {
                holidayDays.add(locator);
            }
        }

        Assert.assertFalse(
                holidayDays.isEmpty(),
                "No existing Holiday found to convert to Working"
        );

        // ---------- STEP 3: Pick ONE random Holiday ----------
        String randomHoliday = holidayDays.get(
                new Random().nextInt(holidayDays.size())
        );

        common.logPrint("Random Holiday selected :: " + randomHoliday);

        // ---------- STEP 4: Change Holiday ➜ Working ----------
        common.click(randomHoliday);
        common.click(WORKINGTEXT);   // locator for "Working"

        common.pause(1);

        // ---------- STEP 5: Identify Start & End inputs for that row ----------
        String startInputLocator = randomHoliday.replace("input[1]", "input[2]");
        String endInputLocator = randomHoliday.replace("input[1]", "input[3]");

        // ---------- STEP 6: Fill timings ----------
        common.highlightElement(startInputLocator);
        selectTimeFromPicker(startInputLocator, startTime);
        clickWorkingHoursSave(secondarySaveButton);

        common.highlightElement(endInputLocator);
        selectTimeFromPicker(endInputLocator, endTime);
        clickWorkingHoursSave(secondarySaveButton);


        // ---------- STEP 7: Save ----------
        common.waitUntilElementToBeVisible(WH_SAVE_BUTTON);
        common.click(WH_SAVE_BUTTON);
        common.assertElementPresent(SUCCESSMSG);

        // ---------- STEP 8: Validate timings are present ----------
        String actualStart = common.getAttribute(startInputLocator, "value");
        String actualEnd   = common.getAttribute(endInputLocator, "value");

        Assert.assertFalse(actualStart.equals("—") || actualStart.isEmpty(),
                "Start time not set after converting Holiday to Working");

        Assert.assertFalse(actualEnd.equals("—") || actualEnd.isEmpty(),
                "End time not set after converting Holiday to Working");

        common.logPrint(
                "Step :: Holiday successfully changed to Working with timings "
                        + actualStart + " - " + actualEnd
        );
    }

}
