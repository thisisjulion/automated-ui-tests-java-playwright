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
        //Step 1 - open home page
        steps = new ContactFormSteps(page);
        steps.navigateToHomePageAndAcceptCookies();

        //Step 2 - open first listing
        steps.navigateToFirstListing();

        //Step 3 - open contact form
        steps.openContactForm();

        //Step 4 - fill in form and verify success message;
        steps.fillAndSubmitContactForm();
        steps.verifySuccessfulMessage();
    }
}
