package com.funda.pages.propertypage;

import static com.funda.utils.PlaywrightUtility.name;

import com.funda.pages.propertypage.components.MediaContainer;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import lombok.Getter;

@Getter
public class PropertyPage {
  private final MediaContainer mediaContainer;
  private final Locator address;
  private final Locator aboutSection;
  private final Locator price;
  private final Locator description;
  private final Locator agentTitle;
  private final Locator contactAgentButton;
  private final Locator requestViewingButton;
  private final Locator showPhoneNumber;
  private final Locator phoneNumber;
  private final Locator featuresSection;
  private final Locator mapIcon;

  public PropertyPage(Page page) {
    this.mediaContainer = new MediaContainer(page);
    this.aboutSection = page.locator("#about");
    this.address = page.locator("h1[data-global-id]");
    this.price =
        aboutSection.locator(
            "css=div[class='flex gap-2 font-bold']"); // will be good to replace in future
    this.description = page.locator("css=div[class*='listing-description']");
    this.contactAgentButton =
        page.getByRole(AriaRole.LINK, name("Neem contact op"))
            .first(); // remove locale dependency from locator
    this.requestViewingButton =
        page.getByRole(AriaRole.LINK, name("Vraag bezichtiging aan")).first();
    this.showPhoneNumber = page.getByRole(AriaRole.BUTTON, name("Toon telefoonnummer")).first();
    this.phoneNumber = page.locator("css=button[href*='tel:']");
    this.featuresSection = page.locator("#features");
    this.mapIcon = page.getByTitle("Kaart icon");
    this.agentTitle = page.locator("css=h3 a[href*='https://www.funda.nl/makelaars/']");
  }
}
