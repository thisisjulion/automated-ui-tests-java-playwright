package com.funda.pages.propertypage;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import lombok.Getter;

@Getter
public class MediaContainer {
    private final Page page;
    private final Locator mediaSection;
    private final Locator firstImage;

    public MediaContainer(Page page) {
        this.page = page;
        mediaSection = page.locator("#media");
        firstImage = mediaSection.locator("img").first();
    }
}
