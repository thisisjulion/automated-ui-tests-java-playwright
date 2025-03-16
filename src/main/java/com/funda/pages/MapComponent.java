package com.funda.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import lombok.Getter;

@Getter
public class MapComponent {
  private final Locator map;

  public MapComponent(Page page) {
    this.map = page.locator("css=div[class='map__view']");
  }
}
