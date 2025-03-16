package com.funda.tests.ui;

import com.funda.steps.ContactFormSteps;
import com.funda.steps.SearchFunctionalitySteps;
import com.funda.utils.DataGenerator;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

public class ContactFormTests extends BaseTest {
  private ContactFormSteps contactFormSteps;
  private SearchFunctionalitySteps searchFunctionalitySteps;

  @Tag("smoke")
  @Test
  void contactFormSubmissionWorks() {
    // Step 1 - open home page
    contactFormSteps = new ContactFormSteps(page, new DataGenerator());
    searchFunctionalitySteps = new SearchFunctionalitySteps(page);
    contactFormSteps.navigateToHomePageAndAcceptCookies();

    // Step 2 - open first listing
    searchFunctionalitySteps.navigateToFirstListing();

    // Step 3 - open contact form
    contactFormSteps.openContactForm();

    // Step 4 - fill in form and verify success message;
    contactFormSteps.fillAndSubmitContactForm();
    contactFormSteps.verifySuccessfulMessage();
  }
}
