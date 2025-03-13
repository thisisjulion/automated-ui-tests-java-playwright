package com.funda.steps;

import com.microsoft.playwright.Locator;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class VerificationSteps {

    public void verifyThatElementIsVisible(Locator locator) {
        assertThat(locator).isVisible();
    }

    public void verifyThatElementIsEnabled(Locator locator) {
        assertThat(locator).isEnabled();
    }
}
