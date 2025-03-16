package com.funda.pages.homepage.components;

import static com.funda.utils.PlaywrightUtility.name;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import lombok.Getter;

@Getter
public class SearchSection {
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
    this.searchBar = page.getByTestId("search-box");
    this.submitSearchButton =
        page.locator("xpath=//*[@aria-label='SearchBox submit button']/parent::button");
    this.searchOnMapLink = page.locator("css=a[href*='zoeken/kaart']");
    this.buyButton = page.getByRole(AriaRole.BUTTON, name("Koop"));
    this.rentButton = page.getByRole(AriaRole.BUTTON, name("Huur"));
    this.newlyBuiltButton = page.getByRole(AriaRole.BUTTON, name("Nieuwbouw"));
    this.recreationButton = page.getByRole(AriaRole.BUTTON, name("Recreatie"));
    this.europeButton = page.getByRole(AriaRole.BUTTON, name("Europa"));
    this.locationSuggestion = page.getByTestId("SearchBox-location-suggestion");
  }

  public void selectFirstLocationSuggestion() {
    locationSuggestion.first().click();
  }
}
