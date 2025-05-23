package com.funda.steps;

import com.funda.pages.components.CookiesPopUp;
import com.funda.config.Configuration;
import com.microsoft.playwright.Mouse;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.LoadState;
import io.qameta.allure.Step;

public class BaseSteps {
  private static final double START_POINT_X = 500;
  private static final double START_POINT_Y = 300;
  private static final double DELTA_X = 100;
  private static final double DELTA_Y = 0;
  protected final Page page;
  protected final VerificationSteps verification = new VerificationSteps();

  public BaseSteps(Page page) {
    this.page = page;
  }

  @Step("Navigate to home page and accept cookies")
  public void navigateToHomePageAndAcceptCookies() {
    navigateToHomePage();
    acceptCookies();
    page.waitForLoadState(LoadState.LOAD);
  }

  public void navigateToHomePage() {
    page.navigate(Configuration.getEnvironment().getUrl());
  }

  public void acceptCookies() {
    CookiesPopUp cookiesPopUp = new CookiesPopUp(page);
    cookiesPopUp.acceptCookies();
  }

  @Step("Zoom in")
  public void zoomIn() {
    page.mouse().wheel(0, -500);
  }

  @Step("Zoom out")
  public void zoomOut() {
    page.mouse().wheel(0, 500);
  }

  @Step("Drag page")
  public void dragPage() {
    page.mouse().move(START_POINT_X, START_POINT_Y);
    page.mouse().down();
  }

  @Step("Move page")
  public void movePage() {
    page.mouse()
        .move(
            START_POINT_X + DELTA_X, START_POINT_Y + DELTA_Y, new Mouse.MoveOptions().setSteps(10));
    page.mouse().up();
  }

  public void waitForLoadState() {
    page.waitForLoadState(LoadState.LOAD);
  }
}
