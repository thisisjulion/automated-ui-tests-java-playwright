package com.funda.tests.ui;

import com.funda.steps.PropertyDetailsSteps;
import com.funda.steps.SearchFunctionalitySteps;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

public class PropertyDetailsTests extends BaseTest {
  private PropertyDetailsSteps propertyDetailsSteps;
  private SearchFunctionalitySteps searchFunctionalitySteps;

  @Tag("smoke")
  @Test
  void propertyDetailsPageOpens() {
    // Step 1 - Open home page and perform a property search
    propertyDetailsSteps = new PropertyDetailsSteps(page);
    searchFunctionalitySteps = new SearchFunctionalitySteps(page);
    propertyDetailsSteps.navigateToHomePageAndAcceptCookies();

    // Step 2 - Search and select the first listing
    searchFunctionalitySteps.searchBy(dataGenerator.getRandomDutchCity());
    searchFunctionalitySteps.selectFirstListing();

    // Step 3 - Ensure that key property details are displayed (title, price, images, description).
    propertyDetailsSteps.verifyThatAboutSectionIsDisplayed();
    propertyDetailsSteps.verifyPriceLabel();
    propertyDetailsSteps.verifyThatMediaSectionIsDisplayed();
    propertyDetailsSteps.verifyThatContactAgentSectionIsDisplayed();
  }
}
