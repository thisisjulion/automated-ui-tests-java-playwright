package com.funda.steps;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

import com.funda.pages.SearchResultsPage;
import com.funda.pages.homepage.HomePage;
import com.microsoft.playwright.Page;
import io.qameta.allure.Step;

public class SearchFunctionalitySteps extends BaseSteps {
  private final HomePage homePage;
  private final SearchResultsPage searchResultsPage;

  public SearchFunctionalitySteps(Page page) {
    super(page);
    this.homePage = new HomePage(page);
    this.searchResultsPage = new SearchResultsPage(page);
  }

  @Step("Navigate to first listing from home page")
  public void navigateToFirstListing() {
    homePage.getSearchSection().getSubmitSearchButton().click();
    searchResultsPage.getListing().first().click();
  }

  @Step("Search and select first suggestion")
  public void searchBy(String value) {
    homePage.searchFor(value);
    homePage.selectFirstSearchSuggestion();
    waitForLoadState();
  }

  @Step("Verify that search results sum label is displayed and it contains search query")
  public void verifySearchPageHeader(String expectedCity) {
    verification.verifyThatElementIsVisible(searchResultsPage.getPageHeader());
    assertThat(searchResultsPage.getPageHeader()).containsText(expectedCity);
  }

  @Step("Verify that 'Filter' panel is displayed")
  public void verifyThatFilterPanelIsDisplayed() {
    verification.verifyThatElementIsVisible(searchResultsPage.getFilterPanel());
  }

  @Step("Verify that listings are displayed")
  public void verifyThatListingsAreDisplayed() {
    searchResultsPage.getListing().all().forEach(verification::verifyThatElementIsVisible);
  }

  @Step("Verify that top listings are displayed")
  public void verifyThatTopListingsAreDisplayed() {
    searchResultsPage
        .getTopPositionListing()
        .all()
        .forEach(verification::verifyThatElementIsVisible);
  }

  @Step("Select first listing")
  public void selectFirstListing() {
    searchResultsPage.getListing().first().click();
  }
}
