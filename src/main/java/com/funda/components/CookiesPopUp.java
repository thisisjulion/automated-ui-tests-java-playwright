package com.funda.components;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class CookiesPopUp {
  private final Locator accept;

  public CookiesPopUp(Page page) {
    this.accept = page.locator("id=didomi-notice-agree-button");
  }

  public void acceptCookies() {
    accept.click();
  }
}
