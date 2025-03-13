package com.funda;

import java.util.Optional;

public class Configuration {
    public static final String CONFIG_BROWSER_OPTION = "PLAYWRIGHT_BROWSER";
    public static final String CONFIG_TARGET_ENVIRONMENT = "TARGET_ENVIRONMENT";
    public static final String CONFIG_USER_BYPASS_CHECK_TOKEN = "USER_BYPASS_CHECK_TOKEN";
    public static final String CONFIG_HEADLESS = "PLR_HEADLESS";

    public enum BrowserOption {
        CHROMIUM,
        FIREFOX,
        WEBKIT
    }

    public static BrowserOption getConfigBrowserOption() {
        return Optional.ofNullable(System.getenv(CONFIG_BROWSER_OPTION))
                .map(String::toUpperCase)
                .map(BrowserOption::valueOf)
                .orElse(BrowserOption.CHROMIUM);
    }

    public static Boolean isHeadless() {
        return Optional.ofNullable(System.getenv(CONFIG_HEADLESS))
                .map(Boolean::parseBoolean)
                .orElse(false);
    }

    public static String getEnvironment() {
        return System.getenv(CONFIG_TARGET_ENVIRONMENT);
    }

    public static String getUserAgentToken() {
        return System.getenv(CONFIG_USER_BYPASS_CHECK_TOKEN);
    }
}
