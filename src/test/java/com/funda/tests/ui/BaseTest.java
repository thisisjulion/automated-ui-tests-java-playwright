package com.funda.tests.ui;

import com.funda.config.Configuration;
import com.funda.utils.DataGenerator;
import com.microsoft.playwright.*;
import java.util.List;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

public class BaseTest {
  protected static Playwright playwright;
  protected static Browser browser;
  protected static BrowserContext context;
  protected static Browser.NewContextOptions newContextOptions;
  protected static Page page;

  protected DataGenerator dataGenerator;

  @BeforeAll
  public static void setup() {
    playwright = Playwright.create();
    browser = initBrowser(playwright);
    newContextOptions =
        new Browser.NewContextOptions()
            .setUserAgent(Configuration.getUserAgentToken())
            .setViewportSize(null);
    context = browser.newContext(newContextOptions);
  }

  protected static Browser initBrowser(Playwright playwright) {
    final Configuration.BrowserOption browserOption = Configuration.getConfigBrowserOption();
    final boolean headless = Configuration.isHeadless();

    BrowserType.LaunchOptions launchOptions =
        new BrowserType.LaunchOptions().setHeadless(headless).setArgs(List.of("--start-maximized"));

    return switch (browserOption) {
      case CHROMIUM -> playwright.chromium().launch(launchOptions);
      case FIREFOX -> playwright.firefox().launch(launchOptions);
      case WEBKIT -> playwright.webkit().launch(launchOptions);
    };
  }

  @AfterAll
  public static void tearDown() {
    if (playwright != null) {
      playwright.close();
    }
  }

  @BeforeEach
  void setupPage() {
    page = context.newPage();
    dataGenerator = initDataGenerator();
  }

  protected DataGenerator initDataGenerator() {
    return new DataGenerator();
  }

  @AfterEach
  void cleanupPage() {
    page.close();
  }
}
