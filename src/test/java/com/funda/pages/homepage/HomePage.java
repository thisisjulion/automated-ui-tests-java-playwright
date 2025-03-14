package com.funda.pages.homepage;

import com.funda.components.Header;
import com.funda.pages.homepage.components.SearchSection;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import lombok.Getter;

@Getter
public class HomePage {
    private final Page page;
    private final Header header;
    private final SearchSection searchSection;
    private final Locator findAnNvmAgentButton;
    private final Locator findCommercialPropertyButton;

    public HomePage(Page page) {
        this.page = page;
        this.header = new Header(page);
        this.searchSection = new SearchSection(page);
        findAnNvmAgentButton = page.locator("css=a[href*='/makelaar-zoeken'] span");
        findCommercialPropertyButton = page.locator("css=a[href='https://www.fundainbusiness.nl']");
    }

    public void searchFor(String value) {
        searchSection.getSearchBar().click();
        searchSection.getSearchBar().fill(value);
    }

    public void selectFirstSearchSuggestion() {
        searchSection.selectFirstLocationSuggestion();
    }
}
