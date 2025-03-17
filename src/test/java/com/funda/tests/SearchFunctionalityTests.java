package com.funda.tests;

import com.funda.steps.SearchFunctionalitySteps;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

public class SearchFunctionalityTests extends BaseTest {
  private SearchFunctionalitySteps searchFunctionalitySteps;

  @Tag("smoke")
  @DisplayName("Search functionality works")
  @Test
  public void searchFunctionalityWorks() {
    // Step 1 - Open home page and perform a property search (e.g., “Amsterdam”).
    searchFunctionalitySteps = new SearchFunctionalitySteps(page);
    searchFunctionalitySteps.navigateToHomePageAndAcceptCookies();

    // Step 2 - Search by city
    String randomCity = dataGenerator.getRandomDutchCity();
    searchFunctionalitySteps.searchBy(randomCity);

    // Step 3 - Verify 'Search Results' page
    searchFunctionalitySteps.verifySearchPageHeader(randomCity);
    searchFunctionalitySteps.verifyThatFilterPanelIsDisplayed();
    searchFunctionalitySteps.verifyThatTopListingsAreDisplayed();
    searchFunctionalitySteps.verifyThatListingsAreDisplayed();
  }
}
