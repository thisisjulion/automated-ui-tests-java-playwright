package com.funda.steps;

import com.funda.components.CookiesPopUp;
import com.funda.pages.homepage.HomePage;
import com.microsoft.playwright.Page;


import static com.funda.Constants.HOME_PAGE;

public class HomePageSteps {
    private final Page page;
    private final HomePage homePage;

    private final VerificationSteps verification = new VerificationSteps();

    public HomePageSteps(Page page) {
        this.page = page;
        homePage = new HomePage(page);
    }

    public void navigateAndAcceptCookies() {
        navigateToHomePage();
        acceptCookies();
    }

    public void navigateToHomePage() {
        page.navigate(HOME_PAGE.getUrl());
    }

    public void acceptCookies() {
        CookiesPopUp cookiesPopUp = new CookiesPopUp(page);
        cookiesPopUp.acceptCookies();
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
        verification.verifyThatElementIsVisible(homePage.getFindCommercialPropertyButton());
    }
}
