package com.isanuric.utils;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;


public class Configuration {


    public static String getProperty(String key) {

        Properties properties;
        InputStream inputStream = null;

        try {

            properties = getProperties();

//            properties.load(inputStream);

            return properties.getProperty(key);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {

            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            return null;

        }

    }

    private static Properties getProperties() {

        try {

            InputStream propertiesInputStream = null;
            Properties properties = new Properties();
            System.out.println("->>>" + Configuration.class.getClassLoader().toString());
            propertiesInputStream = Configuration.class.getClassLoader().getResourceAsStream("/config.properties");
            properties.load(propertiesInputStream);

            return properties;

//            String value = properties.getProperty("config.properties");
////            return new FileInputStream("resources/config.properties");

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // this line should not be reach
        return null;
    }
}
