package com.funda.steps;

import com.funda.pages.propertypage.PropertyPage;
import com.funda.pages.SearchResultsPage;
import com.funda.pages.homepage.HomePage;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.LoadState;
import org.junit.jupiter.api.Assertions;

import java.util.regex.Pattern;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class PropertyDetailsSteps extends BaseSteps {
    private final HomePage homePage;
    private final SearchResultsPage searchResultsPage;
    private final PropertyPage propertyPage;

    public PropertyDetailsSteps(Page page) {
        super(page);
        homePage = new HomePage(page);
        searchResultsPage = new SearchResultsPage(page);
        propertyPage = new PropertyPage(page);
    }

    public void searchBy(String value) {
        homePage.searchFor(value);
        homePage.selectFirstSearchSuggestion();
        searchResultsPage.getPage().waitForLoadState(LoadState.LOAD);
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

    public void verifyThatAboutSectionIsDisplayed() {
        verification.verifyThatElementIsVisible(propertyPage.getAboutSection());
        verification.verifyThatElementIsVisible(propertyPage.getAddress());
        verification.verifyThatElementIsVisible(propertyPage.getDescription());
        verification.verifyThatElementIsVisible(propertyPage.getFeaturesSection());
        verification.verifyThatElementIsVisible(propertyPage.getMapIcon());
        verification.verifyThatElementIsEnabled(propertyPage.getMapIcon());
    }

    public void verifyPriceLabel() {
        String price = propertyPage.getPrice().innerText();
        Assertions.assertTrue(Pattern.matches("€.*?k\\.k\\.", price),
                "Price label should be displayed matching pattern - € [price value] k.k.");
    }

    public void verifyThatContactAgentSectionIsDisplayed() {
        verification.verifyThatElementIsVisible(propertyPage.getAgentTitle());
        verification.verifyThatElementIsVisible(propertyPage.getShowPhoneNumber());
        verifyThatPhoneIsVisible();
        verification.verifyThatElementIsVisible(propertyPage.getContactAgentButton());
        verification.verifyThatElementIsEnabled(propertyPage.getContactAgentButton());
        verification.verifyThatElementIsVisible(propertyPage.getRequestViewingButton());
        verification.verifyThatElementIsEnabled(propertyPage.getRequestViewingButton());
    }

    public void verifyThatPhoneIsVisible() {
        propertyPage.getShowPhoneNumber().click();
        verification.verifyThatElementIsVisible(propertyPage.getPhoneNumber());
    }

    public void verifyThatMediaSectionIsDisplayed() {
        verification.verifyThatElementIsVisible(propertyPage.getMediaContainer().getMediaSection());
        verification.verifyThatElementIsVisible(propertyPage.getMediaContainer().getFirstImage());
    }
}
