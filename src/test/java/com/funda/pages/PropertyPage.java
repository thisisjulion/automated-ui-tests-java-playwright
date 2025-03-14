package com.funda.pages;

import com.funda.pages.homepage.MediaContainer;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import lombok.Getter;

import static com.funda.utilities.PlaywrightUtility.name;

@Getter
public class PropertyPage {
    private final Page page;
    private final MediaContainer mediaContainer;
    private final Locator address;
    private final Locator aboutSection;
    private final Locator price;
    private final Locator description;
    private final Locator contactAgentButton;
    private final Locator requestViewingButton;
    private final Locator showPhoneNumber;
    private final Locator phoneNumber;
    private final Locator featuresSection;
    private final Locator mapIcon;

    public PropertyPage(Page page) {
        this.page = page;
        mediaContainer = new MediaContainer(page);
        aboutSection = page.locator("#about");
        address = page.locator("h1[data-global-id]");
        price = aboutSection.locator("css=div[class='flex gap-2 font-bold']"); //will be good to replace in future
        description = page.locator("css=div[class*='listing-description']");
        contactAgentButton = page.getByRole(AriaRole.LINK, name("Neem contact op")).first(); //remove locale dependency from locator
        requestViewingButton = page.getByRole(AriaRole.LINK, name("Vraag bezichtiging aan")).first();
        showPhoneNumber = page.getByRole(AriaRole.BUTTON, name("Toon telefoonnummer")).first();
        phoneNumber = page.locator("css=button[href*='tel:0']");
        featuresSection = page.locator("#features");
        mapIcon = page.getByTitle("Kaart icon");
    }
}
