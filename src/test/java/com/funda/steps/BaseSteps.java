package com.funda.steps;

import com.funda.components.CookiesPopUp;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.LoadState;

import static com.funda.Constants.HOME_PAGE;

public class BaseSteps {
    protected final Page page;
    protected final VerificationSteps verification = new VerificationSteps();

    public BaseSteps(Page page) {
        this.page = page;
    }

    public void navigateToHomePageAndAcceptCookies() {
        navigateToHomePage();
        acceptCookies();
        page.waitForLoadState(LoadState.LOAD);
    }

    public void navigateToHomePage() {
        page.navigate(HOME_PAGE.getUrl());
    }

    public void acceptCookies() {
        CookiesPopUp cookiesPopUp = new CookiesPopUp(page);
        cookiesPopUp.acceptCookies();
    }

    public void zoomIn() {
        page.mouse().wheel(0, -500);
    }

    public void zoomOut() {
        page.mouse().wheel(0, 500);
    }
}
