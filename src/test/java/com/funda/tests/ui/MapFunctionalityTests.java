package com.funda.tests.ui;

import com.funda.BaseTest;
import com.funda.steps.MapFunctionalitySteps;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

public class MapFunctionalityTests extends BaseTest {
    MapFunctionalitySteps steps;

    @Tag("smoke")
    @Test
    void mapFunctionalityWorks() {
        //Step 1 - Open and accept cookies
        steps = new MapFunctionalitySteps(page);
        steps.navigateToHomePageAndAcceptCookies();

        //Step 2 - click 'Search on Map' button and ensure that map component is visible on the page
        steps.clickSearchOnMap();
        steps.verifyThatMapIsVisible();

        //Step 3 - verify interacts with the map - Zoom in and out, Pan around different locations
        steps.listenToGoogleMapApi();
        steps.zoomInAndOutAndThatGoogleApiWasTriggered();

        //Step 4 -  Click on a property marker to open details.
        //Verify that property details appear correctly when selecting a listing from the map.
    }
}
