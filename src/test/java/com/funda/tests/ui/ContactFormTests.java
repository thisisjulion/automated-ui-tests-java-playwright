package com.funda.tests.ui;


import com.funda.BaseTest;
import com.funda.steps.ContactFormSteps;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

public class ContactFormTests extends BaseTest {
    private ContactFormSteps steps;

    @Tag("smoke")
    @Test
    void contactFormSubmissionWorks() {
        //Step 1
        steps = new ContactFormSteps(page);
        steps.navigateToHomePageAndAcceptCookies();

        //Step 2
        steps.navigateToFirstListing();
        steps.openContactForm();

        //Step 3 - ensure that all elements are displayed
        steps.verifyContactSection();

        //Step 4 - fill in form and verify success message;
        steps.fillAndSubmitContactForm();
        steps.verifySuccessfulMessage();
    }
}
