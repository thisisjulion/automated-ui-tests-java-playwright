package com.funda.utilities;

import com.microsoft.playwright.Page;

public class PlaywrightUtility {
    public static Page.GetByRoleOptions name(String name) {
        return new Page.GetByRoleOptions().setName(name);
    }
}
