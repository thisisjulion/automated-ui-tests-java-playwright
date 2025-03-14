package com.funda.tests.ui;

import com.funda.BaseTest;
import com.funda.steps.PropertyDetailsSteps;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

public class PropertyDetailsTests extends BaseTest {
    private PropertyDetailsSteps steps;

    @Tag("smoke")
    @Test
    void propertyDetailsPageOpens() {
        //Step 1 - Open home page and perform a property search (e.g., “Amsterdam”).
        steps = new PropertyDetailsSteps(page);
        steps.navigateToHomePageAndAcceptCookies();

        //Step 2 - Click on the first property in the results.
        steps.searchAndSelectFirstSuggestion("Amsterdam");
        steps.selectFirstTopPositionListing();

        //Step 3 - Ensure that key property details are displayed (title, price, images, description).
        steps.verifyThatAboutSectionIsDisplayed();
        steps.verifyPriceLabel();
        steps.verifyThatMediaSectionIsDisplayed();

        //Step 4 - Verify that the "Contact Agent" button is visible and functional.
        steps.verifyThatContactAgentSectionIsDisplayed();
    }
}
