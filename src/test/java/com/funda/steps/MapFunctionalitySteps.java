package com.funda.steps;

import com.funda.pages.MapComponent;
import com.funda.pages.homepage.HomePage;
import com.microsoft.playwright.Page;
import org.junit.jupiter.api.Assertions;

public class MapFunctionalitySteps extends BaseSteps {
    private HomePage homePage;
    private MapComponent mapComponent;
    private boolean apiRequestTriggered = false;

    public MapFunctionalitySteps(Page page) {
        super(page);
        homePage = new HomePage(page);
        mapComponent = new MapComponent(page);
    }

    public void clickSearchOnMap() {
        homePage.getSearchSection().getSearchOnMapLink().click();
    }

    public void verifyThatMapIsVisible() {
        verification.verifyThatElementIsVisible(mapComponent.getMap());
    }

    public void listenToGoogleMapApi() {
        page.onRequest(request -> {
            if (request.url().contains(
                    "maps.googleapis.com/$rpc/google.internal.maps.mapsjs.v1.MapsJsInternalService/GetViewportInfo")) {
                apiRequestTriggered = true;
            }
        });
    }

    public void zoomInAndOutAndThatGoogleApiWasTriggered() {
        zoomIn();
        verifyThatGoogleMapApiWasTriggered();
        zoomOut();
        verifyThatGoogleMapApiWasTriggered();
    }

    public void verifyThatGoogleMapApiWasTriggered() {
        Assertions.assertTrue(apiRequestTriggered,
                "Google Map API should be triggered after every map interaction");
    }

}
