package com.funda.steps;

import com.funda.pages.SearchResultsPage;
import com.funda.pages.homepage.HomePage;
import com.microsoft.playwright.Page;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class SearchFunctionalitySteps extends BaseSteps {
    private final HomePage homePage;
    private final SearchResultsPage searchResultsPage;

    public SearchFunctionalitySteps(Page page) {
        super(page);
        this.homePage = new HomePage(page);
        this.searchResultsPage = new SearchResultsPage(page);
    }

    public void navigateToFirstListing() {
        homePage.getSearchSection().getSubmitSearchButton().click();
        searchResultsPage.getListing().first().click();
    }

    public void searchBy(String value) {
        homePage.searchFor(value);
        homePage.selectFirstSearchSuggestion();
        waitForLoadState();
    }

    public void verifySearchPageHeader(String expectedCity) {
        verification.verifyThatElementIsVisible(searchResultsPage.getPageHeader());
        assertThat(searchResultsPage.getPageHeader()).containsText(expectedCity);
    }

    public void verifyThatFilterPanelIsDisplayed() {
        verification.verifyThatElementIsVisible(searchResultsPage.getFilterPanel());
    }

    public void verifyThatListingsAreDisplayed() {
        searchResultsPage.getListing().all().forEach(verification::verifyThatElementIsVisible);
    }

    public void verifyThatTopListingsAreDisplayed() {
        searchResultsPage.getTopPositionListing().all().forEach(verification::verifyThatElementIsVisible);
    }

    public void selectFirstListing() {
        searchResultsPage.getListing().first().click();
    }
}
