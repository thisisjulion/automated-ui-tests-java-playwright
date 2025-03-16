package com.funda.config;

import java.util.Optional;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

public class Configuration {
  public static final String CONFIG_BROWSER_OPTION = "PLAYWRIGHT_BROWSER";
  public static final String CONFIG_TARGET_ENVIRONMENT = "TARGET_ENVIRONMENT";
  public static final String CONFIG_USER_BYPASS_CHECK_TOKEN = "USER_BYPASS_CHECK_TOKEN";
  public static final String CONFIG_HEADLESS = "PLR_HEADLESS";

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

  public static Environment getEnvironment() {
    return Optional.ofNullable(System.getenv(CONFIG_TARGET_ENVIRONMENT))
        .map(String::toUpperCase)
        .map(Environment::valueOf)
        .orElse(Environment.PROD);
  }

  public static String getUserAgentToken() {
    return System.getenv(CONFIG_USER_BYPASS_CHECK_TOKEN);
  }

  public enum BrowserOption {
    CHROMIUM,
    FIREFOX,
    WEBKIT
  }

  @Getter
  @RequiredArgsConstructor
  public enum Environment {
    PROD("https://www.funda.nl/"),
    STAGE("tbd"),
    DEV("tbd");

    private final String url;
  }
}
