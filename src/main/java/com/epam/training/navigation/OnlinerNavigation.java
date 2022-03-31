package com.epam.training.navigation;

import com.epam.training.pageobject.OnlinerHomePage;

public class OnlinerNavigation {

    public static void navigateToOnlinerHomePage() {
        new OnlinerHomePage().navigate("https://www.onliner.by/");
    }
}
