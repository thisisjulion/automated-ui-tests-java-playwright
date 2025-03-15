package com.funda.tests.ui;

import com.funda.BaseTest;
import com.funda.steps.PropertyDetailsSteps;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.funda.utilities.DataGenerator.getRandomDutchCity;

public class SearchFunctionalityTests extends BaseTest {
    private PropertyDetailsSteps steps;

    @Tag("smoke")
    @Test
    public void searchFunctionalityWorks() {
        //Step 1 - Open home page and perform a property search (e.g., “Amsterdam”).
        steps = new PropertyDetailsSteps(page);
        steps.navigateToHomePageAndAcceptCookies();

        //Step 2 - Search by city
        String randomCity = getRandomDutchCity();
        steps.searchBy(randomCity);

        //Step 3 - Verify 'Search Results' page
        steps.verifySearchPageHeader(randomCity);
        steps.verifyThatFilterPanelIsDisplayed();
        steps.verifyThatTopListingsAreDisplayed();
        steps.verifyThatListingsAreDisplayed();
    }
}
