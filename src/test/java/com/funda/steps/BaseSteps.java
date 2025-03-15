package com.funda.steps;

import com.funda.components.CookiesPopUp;
import com.microsoft.playwright.Mouse;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.LoadState;

import static com.funda.Constants.HOME_PAGE;

public class BaseSteps {
    private double startX = 500;
    private double startY = 300;
    private double deltaX = 100;
    private double deltaY = 0;
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

    public void dragPage() {
        page.mouse().move(startX, startY);
        page.mouse().down();
    }

    public void movePage() {
        page.mouse().move(startX + deltaX, startY + deltaY, new Mouse.MoveOptions().setSteps(10));
        page.mouse().up();
    }
}
