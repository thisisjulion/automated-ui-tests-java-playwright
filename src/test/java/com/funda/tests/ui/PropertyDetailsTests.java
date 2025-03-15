package com.funda.tests.ui;

import com.funda.BaseTest;
import com.funda.steps.PropertyDetailsSteps;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.funda.utilities.DataGenerator.getRandomDutchCity;

public class PropertyDetailsTests extends BaseTest {
    private PropertyDetailsSteps steps;

    @Tag("smoke")
    @Test
    void propertyDetailsPageOpens() {
        //Step 1 - Open home page and perform a property search
        steps = new PropertyDetailsSteps(page);
        steps.navigateToHomePageAndAcceptCookies();

        //Step 2 - Search and select the first listing
        steps.searchBy(getRandomDutchCity());
        steps.selectFirstListing();

        //Step 3 - Ensure that key property details are displayed (title, price, images, description).
        steps.verifyThatAboutSectionIsDisplayed();
        steps.verifyPriceLabel();
        steps.verifyThatMediaSectionIsDisplayed();
        steps.verifyThatContactAgentSectionIsDisplayed();
    }
}
