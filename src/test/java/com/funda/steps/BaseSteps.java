package com.funda.steps;

import com.funda.components.CookiesPopUp;
import com.microsoft.playwright.Page;

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
    }

    public void navigateToHomePage() {
        page.navigate(HOME_PAGE.getUrl());
    }

    public void acceptCookies() {
        CookiesPopUp cookiesPopUp = new CookiesPopUp(page);
        cookiesPopUp.acceptCookies();
    }
}
