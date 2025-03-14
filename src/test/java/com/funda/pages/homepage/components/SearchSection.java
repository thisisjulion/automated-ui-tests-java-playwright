package com.funda.pages.homepage.components;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import lombok.Getter;

import static com.funda.utilities.PlaywrightUtility.name;

@Getter
public class SearchSection {
    private final Page page;
    private final Locator searchBar;
    private final Locator submitSearchButton;
    private final Locator searchOnMapLink;
    private final Locator buyButton;
    private final Locator rentButton;
    private final Locator newlyBuiltButton;
    private final Locator recreationButton;
    private final Locator europeButton;
    private final Locator locationSuggestion;

    public SearchSection(Page page) {
        this.page = page;
        searchBar = page.getByTestId("search-box");
        submitSearchButton = page.locator("xpath=//*[@aria-label='SearchBox submit button']/parent::button");
        searchOnMapLink = page.locator("css=a[href*='zoeken/kaart']");
        buyButton = page.getByRole(AriaRole.BUTTON, name("Koop"));
        rentButton = page.getByRole(AriaRole.BUTTON, name("Huur"));
        newlyBuiltButton = page.getByRole(AriaRole.BUTTON, name("Nieuwbouw"));
        recreationButton = page.getByRole(AriaRole.BUTTON, name("Recreatie"));
        europeButton = page.getByRole(AriaRole.BUTTON, name("Europa"));
        locationSuggestion = page.getByTestId("SearchBox-location-suggestion");
    }

    public void selectFirstLocationSuggestion() {
        locationSuggestion.first().click();
    }
}
