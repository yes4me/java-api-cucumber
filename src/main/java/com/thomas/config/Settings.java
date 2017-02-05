package com.thomas.config;

import com.thomas.utilities.PropertiesUtil;

import java.util.Map;

/**
 * Created by Thomas on 12/19/2016.
 */
public class Settings {
    final static String CONFIG_FILENAME = "src/main/java/com/thomas/config/config.properties";

    public static String api_url_weather;
    public static String api_key_weather;
    public static String db_host;
    public static String db_database;
    public static String db_username;
    public static String db_password;

    public static void populateSettings(String filename) {
        Map<String, String> data = PropertiesUtil.getAllProperties(filename);

        Settings.api_url_weather= data.get("API_URL_WEATHER");
        Settings.api_key_weather= data.get("API_KEY_WEATHER");
        Settings.db_host        = data.get("DB_HOST");
        Settings.db_database    = data.get("DB_DATABASE");
        Settings.db_username    = data.get("DB_USERNAME");
        Settings.db_password    = data.get("DB_PASSWORD");
    }
    public static void populateSettings() {
        populateSettings(CONFIG_FILENAME);
    }

    /* -----------------------------------------------------
    For testing purpose
    ----------------------------------------------------- */

    public static void main(String[] args) {
        populateSettings();
        System.out.println("api_url_weather = " + Settings.api_url_weather);
        System.out.println("api_key_weather = " + Settings.api_key_weather);
        System.out.println("db_host = "     + Settings.db_host);
        System.out.println("db_database = " + Settings.db_database);
        System.out.println("db_username = " + Settings.db_username);
        System.out.println("db_password = " + Settings.db_password);
    }
}
