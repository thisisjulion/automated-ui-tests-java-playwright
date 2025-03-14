package com.funda.steps;

import com.funda.pages.ContactAgentPage;
import com.funda.pages.PropertyPage;
import com.funda.pages.SearchResultsPage;
import com.funda.pages.homepage.HomePage;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.LoadState;
import com.microsoft.playwright.options.WaitForSelectorState;

import static com.funda.utilities.DataGenerator.*;

public class ContactFormSteps extends BaseSteps {
    private HomePage homePage;
    private SearchResultsPage searchResultsPage;
    private PropertyPage propertyPage;
    private ContactAgentPage contactAgentPage;

    public ContactFormSteps(Page page) {
        super(page);
        homePage = new HomePage(page);
        searchResultsPage = new SearchResultsPage(page);
        propertyPage = new PropertyPage(page);
        contactAgentPage = new ContactAgentPage(page);
    }

    public void navigateToFirstListing() {
        homePage.getSearchSection().getSubmitSearchButton().click();
        searchResultsPage.getFirstListing().click();
    }

    public void verifyContactSection() {

    }

    public void openContactForm() {
        propertyPage.getContactAgentButton().click();
        searchResultsPage.getPage().waitForLoadState(LoadState.LOAD);
    }

    public void fillAndSubmitContactForm() {
        contactAgentPage.getQuestionInput().fill(getRandomText());
        contactAgentPage.getEmailInput().fill(getEmail());
        contactAgentPage.getFirstNameInput().fill(getFirstName());
        contactAgentPage.getLastNameInput().fill(getLastName());
        contactAgentPage.getPhoneNumberInput().fill(getPhoneNumber());
        //contactAgentPage.getSubmitButton().click(); - commented in order not to affect agents
    }

    public void verifySuccessfulMessage() {
        //code to verify actual successful message after submitting form
    }

}
