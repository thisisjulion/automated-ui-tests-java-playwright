package com.funda.tests.ui;

import com.funda.config.Configuration;
import com.funda.utils.DataGenerator;
import com.microsoft.playwright.*;
import io.qameta.allure.Attachment;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import org.junit.jupiter.api.*;

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
            .setViewportSize(null)
            .setRecordVideoDir(Path.of("test-results/videos"));
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
  void cleanupPage(TestInfo testInfo) {
    try {
      if (testInfo.getTags().contains("failed")) {
        attachScreenshot();
        attachVideo();
      }
    } catch (IOException e) {
      System.err.println("Failed to save screenshot or video: " + e.getMessage());
    } finally {
      context.close();
      browser.close();
      playwright.close();
    }
  }

  @Attachment(value = "Screenshot", type = "image/png")
  public byte[] attachScreenshot() throws IOException {
    Path screenshotPath = Path.of("test-results/screenshots/failure.png");
    page.screenshot(new Page.ScreenshotOptions().setPath(screenshotPath));
    return Files.readAllBytes(screenshotPath);
  }

  @Attachment(value = "Video", type = "video/mp4")
  public byte[] attachVideo() throws IOException {
    Path videoPath = page.video().path();
    return Files.exists(videoPath) ? Files.readAllBytes(videoPath) : new byte[0];
  }
}
