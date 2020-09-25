package com.bab.domain.helpers;

import com.typesafe.config.ConfigFactory;

public class AppParametersHelper {

    private static final String APP_PARAMETERS_FILE_NAME = "application.properties";

    protected static String getPathFromAppConfig(String key) {
        return ConfigFactory.load(APP_PARAMETERS_FILE_NAME).getString(key);
    }

    public static String getBaseUrl() {
        String baseUrl = "baseUrl";
        return System.getProperty(baseUrl, getPathFromAppConfig(baseUrl));
    }
}
