package Config;

import java.io.InputStream;
import java.util.Properties;

public final class ReadProperties {

    public static final Properties properties = new Properties();

    static {
        try (InputStream input =
                     ReadProperties.class
                             .getClassLoader()
                             .getResourceAsStream("config.properties")) {

            if (input == null) {
                throw new RuntimeException("config.properties not found in resources");
            }
            properties.load(input);

        } catch (Exception e) {
            throw new RuntimeException("Failed to load config.properties", e);
        }
    }

    private ReadProperties() {}

    public static String getBrowser() {
        return properties.getProperty("browser", "chrome");
    }

    public static boolean isHeadless() {
        return Boolean.parseBoolean(
                properties.getProperty("headless", "false")
        );
    }
}
