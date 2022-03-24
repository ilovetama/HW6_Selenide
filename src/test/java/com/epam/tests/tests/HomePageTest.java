package com.epam.tests.tests;

import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;

import com.epam.tests.listeners.AllureListener;
import com.epam.training.pageobject.CatalogPage;
import com.epam.training.pageobject.OnlinerHomePage;
import io.qameta.allure.Description;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(AllureListener.class)
public class HomePageTest extends BaseTest {

  @Test
  @Tag("test1")
  @Description("checking that catalog item title is visible")
  public void testCatalogItemTitleIsVisible() {
    $x(OnlinerHomePage.CATALOG_LINK).click();
    $$x(CatalogPage.CATALOG_ITEM_TITLE).shouldHave(size(10));
  }

  @Test
  @Tag("test4")
  @DisplayName("checking that screenshot is taken when test is failed")
  @Description("checking that screenshot is taken when test is failed")
  public void testShouldBeFailed() {
    $x(OnlinerHomePage.CATALOG_LINK).click();
    $$x(CatalogPage.CATALOG_ITEM_TITLE).shouldHave(size(11));
  }
}