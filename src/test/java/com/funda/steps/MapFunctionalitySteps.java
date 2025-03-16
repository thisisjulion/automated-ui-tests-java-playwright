package com.funda.steps;

import static com.funda.utils.PlaywrightUtility.getResponse;

import com.funda.pages.MapComponent;
import com.funda.pages.homepage.HomePage;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Response;
import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;

public class MapFunctionalitySteps extends BaseSteps {
  private final HomePage homePage;
  private final MapComponent mapComponent;

  public MapFunctionalitySteps(Page page) {
    super(page);
    this.homePage = new HomePage(page);
    this.mapComponent = new MapComponent(page);
  }

  @Step("Click 'Search' on map")
  public void clickSearchOnMap() {
    homePage.getSearchSection().getSearchOnMapLink().click();
    waitForLoadState();
  }

  @Step("Verify that map is visible")
  public void verifyThatMapIsVisible() {
    verification.verifyThatElementIsVisible(mapComponent.getMap());
  }

  @Step("Zoom in and track google api response")
  public Response zoomInOutAndGetApiResponse(String url) {
    return getResponse(
        url,
        page,
        () -> {
          zoomIn();
          zoomOut();
        });
  }

  @Step("Drag map and reactive search api response")
  public Response dragMapAndGetApiResponse(String url) {
    return getResponse(
        url,
        page,
        () -> {
          dragPage();
          movePage();
        });
  }

  @Step("Verify that api is triggered")
  public void verifyThatApiIsTriggered(
      Response apiResponse, String expectedUrl, String actionName) {
    Assertions.assertTrue(
        apiResponse.url().contains(expectedUrl),
        "The API URL does not contain the expected fragment while " + actionName);
    Assertions.assertEquals(
        200, apiResponse.status(), "Expected 200 OK status, but got: " + apiResponse.status());
  }
}
