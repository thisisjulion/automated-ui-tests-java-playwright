package com.funda.utilities;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.Request;

import java.util.function.Consumer;

public class RequestListener {

    public static void listenToApi(Page page, Consumer<Request> handler) {
        page.onRequest(handler);
    }
}
