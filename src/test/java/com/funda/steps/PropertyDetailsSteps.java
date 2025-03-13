package com.funda.steps;

import com.funda.pages.PropertyPage;
import com.funda.pages.SearchResultsPage;
import com.funda.pages.homepage.HomePage;
import com.microsoft.playwright.Page;
import org.junit.jupiter.api.Assertions;

import java.util.regex.Pattern;

public class PropertyDetailsSteps extends BaseSteps {
    private HomePage homePage;
    private SearchResultsPage searchResultsPage;
    private PropertyPage propertyPage;

    public PropertyDetailsSteps(Page page) {
        super(page);
        homePage = new HomePage(page);
        searchResultsPage = new SearchResultsPage(page);
        propertyPage = new PropertyPage(page);
    }

    public void searchAndSelectFirstSuggestion(String value) {
        homePage.searchFor(value);
        homePage.selectFirstSearchSuggestion();
    }

    public void selectFirstTopPositionListing() {
        searchResultsPage.getTopPositionListing().first().click();
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
        verification.verifyThatElementIsVisible(propertyPage.getContactAgentButton());
    }

    public void verifyThatMediaSectionIsDisplayed() {
        verification.verifyThatElementIsVisible(propertyPage.getMediaContainer().getMediaSection());
        verification.verifyThatElementIsVisible(propertyPage.getMediaContainer().getFirstImage());
    }

}
