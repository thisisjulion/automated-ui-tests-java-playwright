package com.funda.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import lombok.Getter;

import static com.funda.utilities.PlaywrightUtility.name;

@Getter
public class ContactAgentPage {
    private final Page page;
    private final Locator questionInput;
    private final Locator viewingRequestCheckbox;
    private final Locator viewingDetailsForm;
    private final Locator mondayOption;
    private final Locator morningOption;
    private final Locator emailInput;
    private final Locator firstNameInput;
    private final Locator lastNameInput;
    private final Locator phoneNumberInput;
    private final Locator submitButton;

    public ContactAgentPage(Page page) {
        this.page = page;
        questionInput = page.locator("#questionInput");
        viewingRequestCheckbox = page.locator("#checkbox-viewingRequest");
        emailInput = page.locator("#emailAddress");
        firstNameInput = page.locator("#firstName");
        lastNameInput = page.locator("#lastName");
        phoneNumberInput = page.locator("#phoneNumber");
        submitButton = page.getByRole(AriaRole.BUTTON, name("Verstuur bericht")); //better to remove this locale dependency
        viewingDetailsForm = page.locator("css=div[class='mt-4 md:ml-7 lg:mr-44']");
        mondayOption = page.locator("xpath=//input[@id='checkbox-Ma']/parent::div/parent::div"); //better to remove this day/locale dependency
        morningOption = page.locator("xpath=//input[contains(@id,'s morgens')]/parent::div/parent::div"); //better to remove this day/locale dependency
    }
}
