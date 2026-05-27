package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

    private static Properties basesetupprop = new Properties();
    private static Properties locatorprop = new Properties();

    private static final String baseSetupFilePath =
            System.getProperty("user.dir") + "\\config\\config.properties";

    private static final String locatorFilePath =
            System.getProperty("user.dir") + "\\config\\locator.properties";

    static {

        try {

            FileInputStream fis1 = new FileInputStream(baseSetupFilePath);
            FileInputStream fis2 = new FileInputStream(locatorFilePath);

            basesetupprop.load(fis1);
            locatorprop.load(fis2);

        } catch (IOException e) {

            e.printStackTrace();
        }
    }

    // Read from config.properties
    public static String getConfigValue(String key) {
        String value = basesetupprop.getProperty(key);
        System.out.println(key + " : " + value);
        return value;
    }

    // Read from locator.properties
    public static String getLocatorValue(String key) {
        String value = locatorprop.getProperty(key);
        System.out.println(key + " : " + value);
        return value;
    }
}