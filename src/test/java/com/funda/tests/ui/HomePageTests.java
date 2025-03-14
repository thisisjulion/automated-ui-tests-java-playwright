package com.funda.tests.ui;

import com.funda.BaseTest;
import com.funda.steps.HomePageSteps;
import com.microsoft.playwright.APIRequestContext;
import com.microsoft.playwright.APIResponse;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.funda.Constants.HOME_PAGE;
import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class HomePageTests extends BaseTest {
    private HomePageSteps homePageSteps;

    @Tag("smoke")
    @Test
    void homePageLoadsSuccessfully() {
        //Step 1
        verifyThatHomePageUrlReturns200oK();

        //Step 2
        homePageSteps = new HomePageSteps(page);
        homePageSteps.navigateToHomePageAndAcceptCookies();

        //Step 3
        homePageSteps.verifyThatHeaderElementsAreDisplayed();
        homePageSteps.verifyThatSearchSectionIsDisplayed();
        homePageSteps.verifyThatCenterSectionButtonsAreDisplayed();
    }

    private void verifyThatHomePageUrlReturns200oK() {
        APIRequestContext request = playwright.request().newContext();
        APIResponse response = request.get(HOME_PAGE.getUrl());
        assertThat(response).isOK();
    }
}
