package com.epam.tests.selenide_tests;

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
import io.qameta.allure.Step;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(AllureListener.class)
@ExtendWith(SoftAssertsExtension.class)
public class CatalogPageTest extends BaseTest {

  @Test
  @Tag("test2")
  @Step("'Computers and Networks' menu is visible")
  @DisplayName("'Computers and Networks' menu is visible")
  @Description("Check 'Computers and Networks' menu is visible")
  public void testComputersAndNetworksMenuIsVisible() {
    LOG.info("Check 'Computers and Networks' menu is visible");
    $x(OnlinerHomePage.CATALOG_LINK)
        .as("Click on 'Catalog' link")
        .shouldBe(visible)
        .click();
    $x(CatalogPage.CATALOG_CLASSIFIER_LINK)
        .as("Click on 'Computers and Networks' link")
        .shouldBe(visible)
        .click();
    $$x(CatalogPage.CATALOG_MENU_ITEM_TITLE)
        .as("Check 'Computers and Networks' menu item size")
        .shouldHave(size(11))
        .shouldBe(allMatch("Collection`s element is empty",
            element -> !element.getText().isEmpty()));
    LOG.info($$x(CatalogPage.CATALOG_MENU_ITEM_TITLE).toString());
  }

  @Test
  @Tag("test3")
  @Step("Product title and product description in 'Components' section is visible")
  @DisplayName("Product title and product description in 'Components' section is visible")
  @Description("Check product title and product description in 'Components' section are visible")
  public void testComponentsSectionTitleAndDescriptionIsVisible() {
    LOG.info("Check product title and product description in 'Components' section are visible");
    $x(OnlinerHomePage.CATALOG_LINK)
        .as("Click on 'Catalog' link")
        .shouldBe(visible)
        .click();
    $x(CatalogPage.CATALOG_CLASSIFIER_LINK)
        .as("Click on 'Computers and Networks' link")
        .shouldBe(visible)
        .click();
    $x(CatalogPage.CATALOG_CLASSIFIER_CATEGORY_LINK)
        .as("Click on 'Components' link")
        .shouldBe(visible)
        .click();
    $$x(CatalogPage.PRODUCT_TITLE)
        .as("Check 'Product title' quantity in 'Components' section")
        .shouldHave(size(13))
        .shouldBe(allMatch("Collection`s element is empty",
            element -> !element.getText().isEmpty()));
    $$x(CatalogPage.PRODUCT_DESCRIPTION)
        .as("Check 'Product description' quantity in 'Components' section")
        .shouldHave(size(13))
        .shouldBe(allMatch("Collection`s element is empty",
            element -> !element.getText().isEmpty()));
  }
}