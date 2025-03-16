package com.funda.steps;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

import com.microsoft.playwright.Locator;
import io.qameta.allure.Step;

public class VerificationSteps {

  @Step("Verify that element is visible")
  public void verifyThatElementIsVisible(Locator locator) {
    assertThat(locator).isVisible();
  }

  @Step("Verify that element is enabled")
  public void verifyThatElementIsEnabled(Locator locator) {
    assertThat(locator).isEnabled();
  }
}
