package com.funda;

import com.microsoft.playwright.*;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import java.util.List;

public class BaseTest {
    protected static Playwright playwright;
    protected static Browser browser;
    protected static BrowserContext context;
    protected static Browser.NewContextOptions newContextOptions;
    protected static Page page;

    @BeforeAll
    public static void setup() {
        playwright = Playwright.create();
        browser = initBrowser(playwright);
        newContextOptions = new Browser.NewContextOptions().setUserAgent(Configuration.getUserAgentToken())
                .setViewportSize(null);
        context = browser.newContext(newContextOptions);
    }

    @BeforeEach
    void setupPage() {
        page = context.newPage();
    }

    static Browser initBrowser(Playwright playwright) {
        final Configuration.BrowserOption browserOption = Configuration.getConfigBrowserOption();
        final boolean headless = Configuration.isHeadless();

        BrowserType.LaunchOptions launchOptions = new BrowserType.LaunchOptions().setHeadless(headless)
                .setArgs(List.of("--start-maximized"));

        return switch (browserOption) {
            case CHROMIUM -> playwright.chromium().launch(launchOptions);
            case FIREFOX -> playwright.firefox().launch(launchOptions);
            case WEBKIT -> playwright.webkit().launch(launchOptions);
        };
    }

    @AfterEach
    void cleanupPage() {
        page.close();
    }

    @AfterAll
    public static void tearDown() {
        if (playwright != null) {
            playwright.close();
        }
    }
}
