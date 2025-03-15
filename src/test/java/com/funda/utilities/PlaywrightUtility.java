package com.funda.utilities;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Response;

import static com.microsoft.playwright.options.WaitForSelectorState.VISIBLE;

public class PlaywrightUtility {
    public static Page.GetByRoleOptions name(String name) {
        return new Page.GetByRoleOptions().setName(name);
    }

    public static Locator.WaitForOptions getVisibleOption() {
        return new Locator.WaitForOptions().setState(VISIBLE);
    }

    public static Response getResponse(String url, Page page, Runnable runnable) {
        return page.waitForResponse(response -> response.url().contains(url)
                && response.status() == 200, runnable);
    }
}
