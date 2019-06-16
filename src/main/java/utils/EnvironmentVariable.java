
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 *
 * @author Admin
 */
public class EnvironmentVariable {
    public static String CONFIG_PATH = "C:\\work\\ThymeleafDemo\\src\\main\\resources\\application.properties";

    public static Properties getEnvironmentVariable() {
        Properties prop = new Properties();
        try (InputStream inputStream = new FileInputStream(CONFIG_PATH)) {
            prop.load(inputStream);
        } catch (IOException e) {
            System.err.println(e);
        }
        return prop;
    }

    public static String getDBHost() {
        Properties prop = getEnvironmentVariable();
        return prop.getProperty("DBHost");
    }

    public static String getDBUser() {
        Properties prop = getEnvironmentVariable();
        return prop.getProperty("DBUser");
    }

    public static String getDBPass() {
        Properties prop = getEnvironmentVariable();
        return prop.getProperty("DBPass");
    }

    public static String getDBDatabase() {
        Properties prop = getEnvironmentVariable();
        return prop.getProperty("DBDatabase");
    }

   
}
