package Utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.io.*;

public class ConfigFileReader {

    private Properties properties;
    private final String propertyFilePath = "src/test/java/Config/config.properties";

    public ConfigFileReader() {
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(propertyFilePath));
            properties = new Properties();
            try {
                properties.load(reader);
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException("Configuration.properties not found at " + propertyFilePath);
        }
    }

    public String getOneParkURL() {
        String url = properties.getProperty("URL", "URL");
        if (url != null)
            return url;
        else
            throw new RuntimeException("front url not specified in the Configuration.properties file.");
    }

    public String getLeadURL() {
        String url = properties.getProperty("LeadURL", "LeadURL");
        if (url != null)
            return url;
        else
            throw new RuntimeException(" url not specified in the Configuration.properties file.");
    }

    public String getSystemURL() {
        String url = properties.getProperty("SystemDashboardURL", "SystemDashboardURL");
        if (url != null)
            return url;
        else
            throw new RuntimeException(" url not specified in the Configuration.properties file.");
    }

    public String getOPFSuccessURL() {
        String url = properties.getProperty("OPFSuccessURL", "OPFSuccessURL");
        if (url != null)
            return url;
        else
            throw new RuntimeException(" url not specified in the Configuration.properties file.");
    }


    public String getUsername1() {
        String username = properties.getProperty("Username1");
        if (username != null)
            return username;
        else
            throw new RuntimeException(" Username1 not specified in the Configuration.properties file.");
    }

    public String getPassword() {
        String password = properties.getProperty("Password");
        if (password != null)
            return password;
        else
            throw new RuntimeException(" Password not specified in the Configuration.properties file.");
    }
    public String getPassMain() {
        String password = properties.getProperty("PassMain");
        if (password != null)
            return password;
        else
            throw new RuntimeException(" Password not specified in the Configuration.properties file.");
    }

    public String getUsername2() {
        String username = properties.getProperty("Username2");
        if (username != null)
            return username;
        else
            throw new RuntimeException(" Username2 not specified in the Configuration.properties file.");
    }

    public String getUsername3() {
        String username = properties.getProperty("Username3");
        if (username != null)
            return username;
        else
            throw new RuntimeException(" Username3 not specified in the Configuration.properties file.");
    }

    public String getUsername4() {
        String username = properties.getProperty("Username4");
        if (username != null)
            return username;
        else
            throw new RuntimeException(" Username4 not specified in the Configuration.properties file.");
    }

    public String opportunity1() {
        String opportunity1 = properties.getProperty("Opportunity1");
        if (opportunity1 != null)
            return opportunity1;
        else
            throw new RuntimeException(" opportunity1 not specified in the Configuration.properties file.");
    }

    public String opportunity2() {
        String opportunity2 = properties.getProperty("Opportunity2");
        if (opportunity2 != null)
            return opportunity2;
        else
            throw new RuntimeException(" opportunity2 not specified in the Configuration.properties file.");
    }

    public String opportunity3() {
        String opportunity3 = properties.getProperty("Opportunity3");
        if (opportunity3 != null)
            return opportunity3;
        else
            throw new RuntimeException(" opportunity3 not specified in the Configuration.properties file.");
    }

    public String opportunity4() {
        String opportunity4 = properties.getProperty("Opportunity4");
        if (opportunity4 != null)
            return opportunity4;
        else
            throw new RuntimeException(" opportunity4 not specified in the Configuration.properties file.");
    }

    public String opportunity5() {
        String opportunity5 = properties.getProperty("Opportunity5");
        if (opportunity5 != null)
            return opportunity5;
        else
            throw new RuntimeException(" opportunity5 not specified in the Configuration.properties file.");
    }

    public String getLeadAmount() {
        String username = properties.getProperty("LeadAmount");
        if (username != null)
            return username;
        else
            throw new RuntimeException(" LeadAmount not specified in the Configuration.properties file.");
    }

    public String getRevenueStartingRange() {
        String username = properties.getProperty("RevenueStartingRange");
        if (username != null)
            return username;
        else
            throw new RuntimeException(" LeadAmount not specified in the Configuration.properties file.");
    }

    public String getRevenueEndingRange() {
        String username = properties.getProperty("RevenueEndingRange");
        if (username != null)
            return username;
        else
            throw new RuntimeException(" LeadAmount not specified in the Configuration.properties file.");
    }


}
