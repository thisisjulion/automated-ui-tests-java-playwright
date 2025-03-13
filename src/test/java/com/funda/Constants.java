package com.funda;

public enum Constants {
    HOME_PAGE("https://www.funda.nl/");
    private final String url;

    Constants(String url) {
        this.url = url;
    }

    public final String getUrl() {
        return url;
    }
}
