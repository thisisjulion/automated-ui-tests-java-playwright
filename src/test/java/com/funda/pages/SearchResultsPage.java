package com.funda.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import lombok.Getter;

@Getter
public class SearchResultsPage {
    private final Page page;
    private final Locator topPositionListing;
    private final Locator listing;
    private final Locator filterPanel;
    private final Locator pageHeader;

    public SearchResultsPage(Page page) {
        this.page = page;
        topPositionListing = page.getByTestId("top-position-listing");
        listing = page.getByTestId("listingDetailsAddress");
        filterPanel = page.locator("css=div[id='FilterPanel']");
        pageHeader = page.getByTestId("pageHeader");
    }
}
