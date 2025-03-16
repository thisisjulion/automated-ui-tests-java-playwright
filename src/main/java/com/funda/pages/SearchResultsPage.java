package com.funda.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import lombok.Getter;

@Getter
public class SearchResultsPage {
    private final Locator topPositionListing;
    private final Locator listing;
    private final Locator filterPanel;
    private final Locator pageHeader;

    public SearchResultsPage(Page page) {
        this.topPositionListing = page.getByTestId("top-position-listing");
        this.listing = page.getByTestId("listingDetailsAddress");
        this.filterPanel = page.locator("css=div[id='FilterPanel']");
        this.pageHeader = page.getByTestId("pageHeader");
    }
}
