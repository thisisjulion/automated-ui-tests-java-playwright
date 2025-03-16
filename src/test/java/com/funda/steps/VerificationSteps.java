package com.funda.steps;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

import com.microsoft.playwright.Locator;

public class VerificationSteps {

  public void verifyThatElementIsVisible(Locator locator) {
    assertThat(locator).isVisible();
  }

  public void verifyThatElementIsEnabled(Locator locator) {
    assertThat(locator).isEnabled();
  }
}
