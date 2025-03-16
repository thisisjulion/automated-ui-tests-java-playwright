package com.funda.steps;

import com.funda.pages.homepage.HomePage;
import com.microsoft.playwright.Page;

public class HomePageSteps extends BaseSteps {
    private final HomePage homePage;

    public HomePageSteps(Page page) {
        super(page);
        this.homePage = new HomePage(page);
    }

    public void verifyThatHeaderElementsAreDisplayed() {
        verification.verifyThatElementIsVisible(homePage.getHeader().getFundaLabel());
        verification.verifyThatElementIsVisible(homePage.getHeader().getBuyButton());
        verification.verifyThatElementIsVisible(homePage.getHeader().getRentButton());
        verification.verifyThatElementIsVisible(homePage.getHeader().getSellButton());
        verification.verifyThatElementIsVisible(homePage.getHeader().getMyHomeIcon());
        verification.verifyThatElementIsVisible(homePage.getHeader().getFavouritesButton());
        verification.verifyThatElementIsVisible(homePage.getHeader().getLoginButton());
    }

    public void verifyThatSearchSectionIsDisplayed() {
        verification.verifyThatElementIsVisible(homePage.getSearchSection().getSearchBar());
        verification.verifyThatElementIsVisible(homePage.getSearchSection().getSubmitSearchButton());
        verification.verifyThatElementIsVisible(homePage.getSearchSection().getSearchOnMapLink());

        verification.verifyThatElementIsVisible(homePage.getSearchSection().getBuyButton());
        verification.verifyThatElementIsVisible(homePage.getSearchSection().getRentButton());
        verification.verifyThatElementIsVisible(homePage.getSearchSection().getNewlyBuiltButton());
        verification.verifyThatElementIsVisible(homePage.getSearchSection().getRecreationButton());
        verification.verifyThatElementIsVisible(homePage.getSearchSection().getEuropeButton());
    }

    public void verifyThatCenterSectionButtonsAreDisplayed() {
        verification.verifyThatElementIsVisible(homePage.getFindAnNvmAgentButton());
        verification.verifyThatElementIsEnabled(homePage.getFindAnNvmAgentButton());
        verification.verifyThatElementIsVisible(homePage.getFindCommercialPropertyButton());
        verification.verifyThatElementIsEnabled(homePage.getFindCommercialPropertyButton());
    }
}
