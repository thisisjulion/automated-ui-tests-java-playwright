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
        submitButton = page.getByRole(AriaRole.BUTTON, name("Verstuur bericht"));
    }
}
