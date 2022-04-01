package com.epam.training.pageobject;

import com.epam.training.framework.BasePage;
import org.openqa.selenium.By;

public class OnlinerHeader extends BasePage {

    private static final String MAIN_NAVIGATION_LINK_XPATH_PATTERN =
        "//*[contains(@class, 'main-navigation__text') and contains(text(), '%s')]";

    public void clickOnMainNavigationLink(String link) {
        waitForElementVisible(By.xpath(String.format(MAIN_NAVIGATION_LINK_XPATH_PATTERN, link)))
            .click();
    }

    public CatalogPage clickOnCatalogNavigationLink(String link) {
        clickOnMainNavigationLink(link);
        return new CatalogPage();
    }
}
