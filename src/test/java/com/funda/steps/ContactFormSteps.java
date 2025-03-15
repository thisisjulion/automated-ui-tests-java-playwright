package com.funda.steps;

import com.funda.pages.ContactAgentPage;
import com.funda.pages.propertypage.PropertyPage;
import com.funda.pages.SearchResultsPage;
import com.funda.pages.homepage.HomePage;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.LoadState;
import static com.funda.utilities.DataGenerator.*;
import static com.funda.utilities.PlaywrightUtility.getVisibleOption;
import static com.microsoft.playwright.options.WaitForSelectorState.VISIBLE;

public class ContactFormSteps extends BaseSteps {
    private final HomePage homePage;
    private final SearchResultsPage searchResultsPage;
    private final PropertyPage propertyPage;
    private final ContactAgentPage contactAgentPage;

    public ContactFormSteps(Page page) {
        super(page);
        homePage = new HomePage(page);
        searchResultsPage = new SearchResultsPage(page);
        propertyPage = new PropertyPage(page);
        contactAgentPage = new ContactAgentPage(page);
    }

    public void navigateToFirstListing() {
        homePage.getSearchSection().getSubmitSearchButton().click();
        searchResultsPage.getListing().first().click();
    }

    public void openContactForm() {
        propertyPage.getContactAgentButton().click();
        propertyPage.getPage().waitForLoadState(LoadState.LOAD);
    }

    public void fillAndSubmitContactForm() {
        contactAgentPage.getQuestionInput().fill(getRandomText());
        selectRequestViewing();
        contactAgentPage.getEmailInput().fill(getEmail());
        contactAgentPage.getFirstNameInput().fill(getFirstName());
        contactAgentPage.getLastNameInput().fill(getLastName());
        contactAgentPage.getPhoneNumberInput().fill(getPhoneNumber());
        //contactAgentPage.getSubmitButton().click(); - commented in order not to affect agents
    }

    public void selectRequestViewing() {
        contactAgentPage.getViewingRequestCheckbox().click();
        contactAgentPage.getMondayOption().waitFor(getVisibleOption());
        contactAgentPage.getMondayOption().click();
        contactAgentPage.getMorningOption().click();
    }

    public void verifySuccessfulMessage() {
        //code to verify actual successful message after submitting form
    }
}
