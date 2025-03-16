package com.funda.pages.propertypage.components;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import lombok.Getter;

@Getter
public class MediaContainer {
    private final Locator mediaSection;
    private final Locator firstImage;

    public MediaContainer(Page page) {
        this.mediaSection = page.locator("#media");
        this.firstImage = mediaSection.locator("img").first();
    }
}
