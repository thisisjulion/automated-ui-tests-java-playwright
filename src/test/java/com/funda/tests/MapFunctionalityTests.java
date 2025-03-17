package com.funda.tests;

import com.funda.steps.MapFunctionalitySteps;
import com.microsoft.playwright.Response;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

public class MapFunctionalityTests extends BaseTest {
  MapFunctionalitySteps mapFunctionalitySteps;

  @Tag("smoke")
  @DisplayName("Map functionality works")
  @Test
  void mapFunctionalityWorks() {
    // Step 1 - Open and accept cookies
    mapFunctionalitySteps = new MapFunctionalitySteps(page);
    mapFunctionalitySteps.navigateToHomePageAndAcceptCookies();

    // Step 2 - click 'Search on Map' button and ensure that map component is visible on the page
    mapFunctionalitySteps.clickSearchOnMap();
    mapFunctionalitySteps.verifyThatMapIsVisible();

    // Step 3 - verify interacts with the map - Zoom in and out and drag map
    String googleMapApi =
        "https://maps.googleapis.com/$rpc/google.internal.maps.mapsjs.v1.MapsJsInternalService/GetViewportInfo";
    Response response = mapFunctionalitySteps.zoomInOutAndGetApiResponse(googleMapApi);
    mapFunctionalitySteps.verifyThatApiIsTriggered(
        response, googleMapApi, "zooming in/out the map");

    String reactiveSearchApi =
        "https://listing-search-wonen-arc.funda.io/listings-wonen-searcher-alias-";
    response = mapFunctionalitySteps.dragMapAndGetApiResponse(reactiveSearchApi);
    mapFunctionalitySteps.verifyThatApiIsTriggered(response, reactiveSearchApi, "dragging the map");

    // Step 4 -  Click on a property marker to open details.
    // Verify that property details appear correctly when selecting a listing from the map.
  }
}
