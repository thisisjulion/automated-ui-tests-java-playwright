package com.funda.steps;

import com.funda.pages.propertypage.PropertyPage;
import com.microsoft.playwright.Page;
import org.junit.jupiter.api.Assertions;

import java.util.regex.Pattern;

public class PropertyDetailsSteps extends BaseSteps {
    private final PropertyPage propertyPage;

    public PropertyDetailsSteps(Page page) {
        super(page);
        this.propertyPage = new PropertyPage(page);
    }

    public void verifyThatAboutSectionIsDisplayed() {
        verification.verifyThatElementIsVisible(propertyPage.getAboutSection());
        verification.verifyThatElementIsVisible(propertyPage.getAddress());
        verification.verifyThatElementIsVisible(propertyPage.getDescription());
        verification.verifyThatElementIsVisible(propertyPage.getFeaturesSection());
        verification.verifyThatElementIsVisible(propertyPage.getMapIcon());
        verification.verifyThatElementIsEnabled(propertyPage.getMapIcon());
    }

    public void verifyPriceLabel() {
        String price = propertyPage.getPrice().innerText();
        Assertions.assertTrue(Pattern.matches("€.*?k\\.k\\.", price),
                "Price label should be displayed matching pattern - € [price value] k.k.");
    }

    public void verifyThatContactAgentSectionIsDisplayed() {
        verification.verifyThatElementIsVisible(propertyPage.getAgentTitle());
        verification.verifyThatElementIsVisible(propertyPage.getShowPhoneNumber());
        verifyThatPhoneIsVisible();
        verification.verifyThatElementIsVisible(propertyPage.getContactAgentButton());
        verification.verifyThatElementIsEnabled(propertyPage.getContactAgentButton());
        verification.verifyThatElementIsVisible(propertyPage.getRequestViewingButton());
        verification.verifyThatElementIsEnabled(propertyPage.getRequestViewingButton());
    }

    public void verifyThatPhoneIsVisible() {
        propertyPage.getShowPhoneNumber().click();
        verification.verifyThatElementIsVisible(propertyPage.getPhoneNumber());
    }

    public void verifyThatMediaSectionIsDisplayed() {
        verification.verifyThatElementIsVisible(propertyPage.getMediaContainer().getMediaSection());
        verification.verifyThatElementIsVisible(propertyPage.getMediaContainer().getFirstImage());
    }
}
