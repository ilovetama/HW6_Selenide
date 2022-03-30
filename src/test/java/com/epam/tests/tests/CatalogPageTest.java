package com.epam.tests.tests;

import static com.codeborne.selenide.CollectionCondition.allMatch;
import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;

import com.codeborne.selenide.junit5.SoftAssertsExtension;
import com.epam.tests.listeners.AllureListener;
import com.epam.training.pageobject.CatalogPage;
import com.epam.training.pageobject.OnlinerHomePage;
import io.qameta.allure.Description;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(AllureListener.class)
@ExtendWith(SoftAssertsExtension.class)

public class CatalogPageTest extends BaseTest {

  @Test
  @Tag("test2")
  @DisplayName("'Computers and Networks' menu is visible")
  @Description("Check 'Computers and Networks' menu is visible")
  public void testComputersAndNetworksMenuIsVisible() {
    LOG.info("Check 'Computers and Networks' menu is visible");
    $x(OnlinerHomePage.CATALOG_LINK)
        .as("Catalog link is not visible")
        .shouldBe(visible)
        .click();
    LOG.debug("Catalog link is not visible");
    $x(CatalogPage.CATALOG_CLASSIFIER_LINK)
        .as("'Computers and Networks' link is not visible")
        .shouldBe(visible)
        .click();
    LOG.debug("'Computers and Networks' link is not visible");
    $$x(CatalogPage.CATALOG_MENU_ITEM_TITLE)
        .as("'Computers and Networks' menu size is incorrect")
        .shouldHave(size(10))
        .shouldBe(allMatch("collection element is empty",
            element -> !element.getText().isEmpty()));
    LOG.debug("'Computers and Networks' menu size is incorrect or empty");
  }

  @Test
  @Tag("test3")
  @DisplayName("Product title and product description in 'Components' section is visible")
  @Description("Check product title and product description in 'Components' section are visible")
  public void testComponentsSectionTitleAndDescriptionIsVisible() {
    LOG.info("Check product title and product description in 'Components' section are visible");
    $x(OnlinerHomePage.CATALOG_LINK)
        .as("Catalog link is not visible")
        .shouldBe(visible)
        .click();
    LOG.error("Catalog link is not visible");
    $x(CatalogPage.CATALOG_CLASSIFIER_LINK)
        .as("'Computers and Networks' link is not visible")
        .shouldBe(visible)
        .click();
    LOG.error("'Computers and Networks' link is not visible");
    $x(CatalogPage.CATALOG_CLASSIFIER_CATEGORY_LINK)
        .as("'Components' link is not visible")
        .shouldBe(visible)
        .click();
    LOG.error("'Components' link is not visible");
    $$x(CatalogPage.PRODUCT_TITLE)
        .as("Product title quantity is incorrect in 'Components' section")
        .shouldHave(size(13))
        .shouldBe(allMatch("collection element is empty",
            element -> !element.getText().isEmpty()));
    LOG.error("Product title quantity is incorrect in 'Components' section");
    $$x(CatalogPage.PRODUCT_DESCRIPTION)
        .as("Product description quantity is incorrect or empty in 'Components' section")
        .shouldHave(size(13))
        .shouldBe(allMatch("collection element is empty",
            element -> !element.getText().isEmpty()));
    LOG.error("Product description quantity is incorrect or empty in 'Components' section");
  }
}