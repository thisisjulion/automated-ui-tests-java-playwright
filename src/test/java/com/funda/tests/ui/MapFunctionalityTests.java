package com.funda.tests.ui;

import com.funda.BaseTest;
import com.funda.steps.MapFunctionalitySteps;
import com.microsoft.playwright.Response;
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

        //Step 3 - verify interacts with the map - Zoom in and out and drag map
        String googleMapApi =
                "https://maps.googleapis.com/$rpc/google.internal.maps.mapsjs.v1.MapsJsInternalService/GetViewportInfo";
        Response response = steps.zoomInOutAndGetApiResponse(googleMapApi);
        steps.verifyThatApiIsTriggered(response, googleMapApi, "zooming in/out the map");

        String reactiveSearchApi = "https://listing-search-wonen-arc.funda.io/listings-wonen-searcher-alias-";
        response = steps.dragMapAndGetApiResponse(reactiveSearchApi);
        steps.verifyThatApiIsTriggered(response, reactiveSearchApi, "dragging the map");

        //Step 4 -  Click on a property marker to open details.
        //Verify that property details appear correctly when selecting a listing from the map.
    }
}
