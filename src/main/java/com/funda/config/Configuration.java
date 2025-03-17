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
        .map(BrowserOption::valueOfOrNull)
        .orElse(BrowserOption.CHROMIUM);
  }

  public static Boolean isHeadless() {
    return Optional.ofNullable(System.getenv(CONFIG_HEADLESS))
        .map(Boolean::parseBoolean)
        .orElse(true);
  }

  public static Environment getEnvironment() {
    return Optional.ofNullable(System.getenv(CONFIG_TARGET_ENVIRONMENT))
        .map(String::toUpperCase)
        .map(Environment::valueOfOrNull)
        .orElse(Environment.PROD);
  }

  public static String getUserAgentToken() {
    return System.getenv(CONFIG_USER_BYPASS_CHECK_TOKEN);
  }

  public enum BrowserOption {
    CHROMIUM,
    FIREFOX,
    WEBKIT;

    public static BrowserOption valueOfOrNull(String name) {
      BrowserOption option = null;

      try {
        option = BrowserOption.valueOf(name);
      } catch (IllegalArgumentException e) {
        System.out.printf("Invalid option supplied: %s%n", name); // TODO: add logging
      }

      return option;
    }
  }

  @Getter
  @RequiredArgsConstructor
  public enum Environment {
    PROD("https://www.funda.nl/"),
    STAGE("tbd"),
    DEV("tbd");

    private final String url;

    public static Environment valueOfOrNull(String name) {
      Environment environment = null;

      try {
        environment = Environment.valueOf(name);
      } catch (IllegalArgumentException e) {
        System.out.printf("Invalid environment supplied: %s%n", name); // TODO: add logging
      }

      return environment;
    }
  }
}
