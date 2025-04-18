package com.funda.steps;

import static com.funda.utils.PlaywrightUtility.elementIsVisible;

import com.funda.pages.ContactAgentPage;
import com.funda.pages.propertypage.PropertyPage;
import com.funda.utils.DataGenerator;
import com.microsoft.playwright.Page;
import io.qameta.allure.Step;

public class ContactFormSteps extends BaseSteps {

  private final PropertyPage propertyPage;
  private final ContactAgentPage contactAgentPage;
  private final DataGenerator dataGenerator;

  public ContactFormSteps(Page page, DataGenerator dataGenerator) {
    super(page);
    this.propertyPage = new PropertyPage(page);
    this.contactAgentPage = new ContactAgentPage(page);
    this.dataGenerator = dataGenerator;
  }

  @Step("Open contact form")
  public void openContactForm() {
    propertyPage.getContactAgentButton().click();
    waitForLoadState();
  }

  @Step("Fill in and submit contact form")
  public void fillAndSubmitContactForm() {
    contactAgentPage.getQuestionInput().fill(dataGenerator.getRandomText());
    selectRequestViewing();
    contactAgentPage.getEmailInput().fill(dataGenerator.getEmail());
    contactAgentPage.getFirstNameInput().fill(dataGenerator.getFirstName());
    contactAgentPage.getLastNameInput().fill(dataGenerator.getLastName());
    contactAgentPage.getPhoneNumberInput().fill(dataGenerator.getPhoneNumber());
    // contactAgentPage.getSubmitButton().click(); - commented in order not to affect agents
  }

  @Step("Select 'Request viewing' checkbox")
  public void selectRequestViewing() {
    contactAgentPage.getViewingRequestCheckbox().hover();
    contactAgentPage.getViewingRequestCheckbox().click();
    contactAgentPage.getMondayOption().waitFor(elementIsVisible());
    contactAgentPage.getMondayOption().click();
    contactAgentPage.getMorningOption().click();
  }

  public void verifySuccessfulMessage() {
    // code to verify actual successful message after submitting form
  }
}
