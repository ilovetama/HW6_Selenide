package org.epam.tests;

import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;

import org.epam.training.pageobject.CatalogPage;
import org.epam.training.pageobject.OnlinerHomePage;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

public class HomePageTest extends BaseTest {

  @Test
  @Tag("test1")
  public void testCatalogItemTitleIsVisible() {
    $x(OnlinerHomePage.CATALOG_LINK).click();
    $$x(CatalogPage.CATALOG_ITEM_TITLE).shouldHave(size(10));
  }
}