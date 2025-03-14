package com.funda.steps;

import com.funda.pages.MapComponent;
import com.funda.pages.homepage.HomePage;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.LoadState;
import org.junit.jupiter.api.Assertions;

import static com.funda.utilities.RequestListener.listenToApi;

public class MapFunctionalitySteps extends BaseSteps {
    private final HomePage homePage;
    private final MapComponent mapComponent;
    private boolean isGoogleApiTriggered = false;
    private boolean isReactiveSearchApiTriggered = false;

    public MapFunctionalitySteps(Page page) {
        super(page);
        homePage = new HomePage(page);
        mapComponent = new MapComponent(page);
    }

    public void clickSearchOnMap() {
        homePage.getSearchSection().getSearchOnMapLink().click();
        homePage.getPage().waitForLoadState(LoadState.LOAD);
    }

    public void verifyThatMapIsVisible() {
        verification.verifyThatElementIsVisible(mapComponent.getMap());
    }

    public void listenToGoogleMapApi() {
        page.onRequest(request -> {
            if (request.url().contains(
                    "https://maps.googleapis.com/$rpc/google.internal.maps.mapsjs.v1.MapsJsInternalService/GetViewportInfo")) {
                isGoogleApiTriggered = true;
            }
        });
    }

    public void listenToReactiveSearchApi() {
        listenToApi(page, (request -> {
            if (request.url().contains("https://listing-search-wonen-arc.funda.io/listings-wonen-searcher-alias-")) {
                isReactiveSearchApiTriggered = true;
            }
        }));
    }

    public void zoomInAndOutAndVerifyThatGoogleApiWasTriggered() {
        zoomIn();
        verifyThatReactiveSearchApiWasTriggered();
        zoomOut();
        verifyThatReactiveSearchApiWasTriggered();
    }

    public void dragMapAndVerifyThatReactiveSearchApiWasTriggered() {
        mapComponent.dragMap();
        verifyThatReactiveSearchApiWasTriggered();
    }

    public void verifyThatGoogleMapApiWasTriggered() {
        Assertions.assertTrue(isGoogleApiTriggered,
                "Google Map API should be triggered after every zoom in/zoom out");
    }

    public void verifyThatReactiveSearchApiWasTriggered() {
        Assertions.assertTrue(isReactiveSearchApiTriggered,
                "Reactive Search API should be triggered after every dragging map");
    }

}
