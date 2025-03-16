package com.funda.tests.ui;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

import com.funda.config.Configuration;
import com.funda.steps.HomePageSteps;
import com.microsoft.playwright.APIRequestContext;
import com.microsoft.playwright.APIResponse;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

public class HomePageTests extends BaseTest {
  private HomePageSteps homePageSteps;

  @Tag("smoke")
  @DisplayName("Home Page loads successfully")
  @Test
  void homePageLoadsSuccessfully() {
    // Step 1 - verify that funda.nl returns 200 OK
    verifyThatHomePageUrlReturns200oK();

    // Step 2 - - open home page
    homePageSteps = new HomePageSteps(page);
    homePageSteps.navigateToHomePageAndAcceptCookies();

    // Step 3 - verify main elements on Home Page
    homePageSteps.verifyThatHeaderElementsAreDisplayed();
    homePageSteps.verifyThatSearchSectionIsDisplayed();
    homePageSteps.verifyThatCenterSectionButtonsAreDisplayed();
  }

  private void verifyThatHomePageUrlReturns200oK() {
    APIRequestContext request = playwright.request().newContext();
    APIResponse response = request.get(Configuration.getEnvironment().getUrl());
    assertThat(response).isOK();
  }
}
