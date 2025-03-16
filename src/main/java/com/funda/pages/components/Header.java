package com.funda.pages.components;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import lombok.Getter;

@Getter
public class Header {
  private static final String BUTTON_LOCATOR = "id=headlessui-menu-button-v-0-%s";
  private final Locator buyButton;
  private final Locator rentButton;
  private final Locator sellButton;
  private final Locator myHomeIcon;
  private final Locator favouritesButton;
  private final Locator loginButton;
  private final Locator fundaLabel;

  public Header(Page page) {
    this.buyButton = page.locator(BUTTON_LOCATOR.formatted("17"));
    this.rentButton = page.locator(BUTTON_LOCATOR.formatted("23"));
    this.sellButton = page.locator(BUTTON_LOCATOR.formatted("26"));
    this.myHomeIcon = page.locator("css=a[href='https://www.funda.nl/mijn-huis/']");
    this.favouritesButton = page.locator("css=a[href='https://www.funda.nl/favorieten']");
    this.loginButton = page.locator("xpath=//button//span[text()='Inloggen']");
    this.fundaLabel = page.getByLabel("Funda", new Page.GetByLabelOptions().setExact(true));
  }
}
