package com.epam.tests.tests;

import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;

import com.codeborne.selenide.junit5.SoftAssertsExtension;
import com.epam.tests.listeners.AllureListener;
import com.epam.training.pageobject.CatalogPage;
import com.epam.training.pageobject.OnlinerHomePage;
import io.qameta.allure.Description;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(AllureListener.class)
@ExtendWith(SoftAssertsExtension.class)
public class HomePageTest extends BaseTest {

  @Test
  @Tag("test1")
  @DisplayName("catalog item title is visible")
  @Description("checking that catalog item title is visible")
  public void testCatalogItemTitleIsVisible() {
    $x(OnlinerHomePage.CATALOG_LINK)
        .as("Catalog link is not visible")
        .shouldBe(visible)
        .click();
    $$x(CatalogPage.CATALOG_ITEM_TITLE)
        .as("Catalog item title quantity is incorrect")
        .shouldHave(size(10));
  }

  @Test
  @Tag("test4")
  @DisplayName("screenshot is taken when test is failed")
  @Description("checking that screenshot is taken when test is failed")
  public void testShouldBeFailed() {
    $x(OnlinerHomePage.CATALOG_LINK).click();
    $$x(CatalogPage.CATALOG_ITEM_TITLE).shouldHave(size(11));
  }

  @Test
  @Disabled("screenshot creation checking")
  @Tag("test5")
  @DisplayName("screenshot is taken when test is skipped")
  @Description("checking that screenshot is taken when test is skipped")
  public void testShouldBeSkipped() {
    $x(OnlinerHomePage.CATALOG_LINK).click();
    $$x(CatalogPage.CATALOG_ITEM_TITLE).shouldHave(size(11));
  }
}