package com.funda.steps;

import com.funda.pages.propertypage.PropertyPage;
import com.microsoft.playwright.Page;
import io.qameta.allure.Step;
import java.util.regex.Pattern;
import org.junit.jupiter.api.Assertions;

public class PropertyDetailsSteps extends BaseSteps {
  private final PropertyPage propertyPage;

  public PropertyDetailsSteps(Page page) {
    super(page);
    this.propertyPage = new PropertyPage(page);
  }

  @Step("Verify that 'About' section is displayed")
  public void verifyThatAboutSectionIsDisplayed() {
    verification.verifyThatElementIsVisible(propertyPage.getAboutSection());
    verification.verifyThatElementIsVisible(propertyPage.getAddress());
    verification.verifyThatElementIsVisible(propertyPage.getDescription());
    verification.verifyThatElementIsVisible(propertyPage.getFeaturesSection());
    verification.verifyThatElementIsVisible(propertyPage.getMapIcon());
    verification.verifyThatElementIsEnabled(propertyPage.getMapIcon());
  }

  @Step("Verify that price label is displayed")
  public void verifyPriceLabel() {
    String price = propertyPage.getPrice().innerText();
    Assertions.assertTrue(
        Pattern.matches("€.*?k\\.k\\.", price),
        "Price label should be displayed matching pattern - € [price value] k.k.");
  }

  @Step("Verify that 'Contact Agent' section is displayed")
  public void verifyThatContactAgentSectionIsDisplayed() {
    verification.verifyThatElementIsVisible(propertyPage.getAgentTitle());
    verification.verifyThatElementIsVisible(propertyPage.getShowPhoneNumber());
    verifyThatPhoneIsVisible();
    verification.verifyThatElementIsVisible(propertyPage.getContactAgentButton());
    verification.verifyThatElementIsEnabled(propertyPage.getContactAgentButton());
    verification.verifyThatElementIsVisible(propertyPage.getRequestViewingButton());
    verification.verifyThatElementIsEnabled(propertyPage.getRequestViewingButton());
  }

  @Step("Verify that Agent's phone number is displayed")
  public void verifyThatPhoneIsVisible() {
    propertyPage.getShowPhoneNumber().click();
    verification.verifyThatElementIsVisible(propertyPage.getPhoneNumber());
  }

  @Step("Verify that media is displayed")
  public void verifyThatMediaSectionIsDisplayed() {
    verification.verifyThatElementIsVisible(propertyPage.getMediaContainer().getMediaSection());
    verification.verifyThatElementIsVisible(propertyPage.getMediaContainer().getFirstImage());
  }
}
