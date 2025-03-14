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
    private HomePageSteps steps;

    @Tag("smoke")
    @Test
    void homePageLoadsSuccessfully() {
        //Step 1 - verify that funda.nl returns 200 OK
        verifyThatHomePageUrlReturns200oK();

        //Step 2 - - open home page
        steps = new HomePageSteps(page);
        steps.navigateToHomePageAndAcceptCookies();

        //Step 3 - verify main elements on Home Page
        steps.verifyThatHeaderElementsAreDisplayed();
        steps.verifyThatSearchSectionIsDisplayed();
        steps.verifyThatCenterSectionButtonsAreDisplayed();
    }

    private void verifyThatHomePageUrlReturns200oK() {
        APIRequestContext request = playwright.request().newContext();
        APIResponse response = request.get(HOME_PAGE.getUrl());
        assertThat(response).isOK();
    }
}
