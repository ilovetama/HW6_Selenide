package org.epam.tests.tests;

import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;

import io.qameta.allure.Description;
import org.epam.training.pageobject.CatalogPage;
import org.epam.training.pageobject.OnlinerHomePage;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith({org.epam.tests.listeners.AllureListener.class})
public class HomePageTest extends BaseTest {

  @Test
  @Tag("test1")
  @Description("checking that catalog item title is visible")
  public void testCatalogItemTitleIsVisible() {
    $x(OnlinerHomePage.CATALOG_LINK).click();
    $$x(CatalogPage.CATALOG_ITEM_TITLE).shouldHave(size(10));
  }
}