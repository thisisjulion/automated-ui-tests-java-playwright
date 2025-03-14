package com.funda.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import lombok.Getter;

@Getter
public class SearchResultsPage {
    private final Page page;
    private final Locator topPositionListing;
    private final Locator firstListing;
    private final Locator filterPanel;

    public SearchResultsPage(Page page) {
        this.page = page;
        topPositionListing = page.getByTestId("top-position-listing");
        firstListing = page.locator("css=div[class*='flex-col gap-3 mt-4'] a[href*='/detail/koop']").first();
        filterPanel = page.locator("#FilterPanel");
    }
}
