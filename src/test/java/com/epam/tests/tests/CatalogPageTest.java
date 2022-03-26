package com.epam.tests.tests;

import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;

import com.codeborne.selenide.junit5.TextReportExtension;
import com.epam.training.pageobject.CatalogPage;
import com.epam.training.pageobject.OnlinerHomePage;
import io.qameta.allure.Description;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(TextReportExtension.class)
public class CatalogPageTest extends BaseTest {

  @Test
  @Tag("test2")
  @DisplayName("'Computers and Networks' menu is visible")
  @Description("checking that 'Computers and Networks' menu is visible")
  public void testComputersAndNetworksMenuIsVisible() {
    $x(OnlinerHomePage.CATALOG_LINK).click();
    $x(CatalogPage.CATALOG_CLASSIFIER_LINK).click();
    $$x(CatalogPage.CATALOG_MENU_ITEM_TITLE).shouldHave(size(10));
  }

  @Test
  @Tag("test3")
  @DisplayName("product title and product description in 'Components' section is visible")
  @Description("checking that product title and product description in 'Components' section is visible")
  public void testComponentsSectionTitleAndDescriptionIsVisible() {
    $x(OnlinerHomePage.CATALOG_LINK).click();
    $x(CatalogPage.CATALOG_CLASSIFIER_LINK).click();
    $x(CatalogPage.CATALOG_CLASSIFIER_CATEGORY_LINK).click();
    $$x(CatalogPage.PRODUCT_TITLE).shouldHave(size(13));
    $$x(CatalogPage.PRODUCT_DESCRIPTION).shouldHave(size(13));
  }
}