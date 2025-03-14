package com.funda.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import lombok.Getter;

@Getter
public class MapComponent {
    private final Page page;
    private final Locator map;

    public MapComponent(Page page) {
        this.page = page;
        map = page.locator("css=div[class='map__view']");
    }

    public void dragMap() {
        map.dragTo(map, new Locator.DragToOptions().setTargetPosition(300, 100));
    }

}
