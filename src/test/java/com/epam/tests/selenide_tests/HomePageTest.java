package com.epam.tests.selenide_tests;

import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.CollectionCondition.texts;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;

import com.codeborne.selenide.junit5.SoftAssertsExtension;
import com.epam.tests.listeners.AllureListener;
import com.epam.training.pageobject.CatalogPage;
import com.epam.training.pageobject.OnlinerHomePage;
import io.qameta.allure.Description;
import io.qameta.allure.Step;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(AllureListener.class)
@ExtendWith(SoftAssertsExtension.class)
public class HomePageTest extends BaseTest {

  @Test
  @Step("Check catalog item title is visible")
  @DisplayName("Catalog item title is visible")
  @Description("Check catalog item title is visible")
  public void testCatalogItemTitleIsVisible() {
    LOG.info("Check catalog item title is visible");
    $x(OnlinerHomePage.CATALOG_LINK)
        .as("Click on 'Catalog' link")
        .shouldBe(visible)
        .click();
    $$x(CatalogPage.CATALOG_ITEM_TITLE)
        .as("Check 'Catalog' item title quantity")
        .shouldHave(size(10))
        .as("Check 'Catalog' item title content")
        .shouldHave(
            texts(
                "Электроника",
                "Компьютеры и сети",
                "Бытовая техника",
                "Стройка и ремонт",
                "Дом и сад",
                "Авто и мото",
                "Красота и спорт",
                "Детям и мамам",
                "Работа и офис",
                "Еда"
            )
        );
  }

  @Test
  @Disabled("for some reasons")
  @Step("Screenshot is taken when test is failed")
  @DisplayName("Screenshot is taken when test is failed")
  @Description("Check screenshot is taken when test is failed")
  public void testShouldBeFailed() {
    LOG.info("Check screenshot is taken when test is failed");
    $x(OnlinerHomePage.CATALOG_LINK).click();
    $$x(CatalogPage.CATALOG_ITEM_TITLE).shouldHave(size(11));
  }

  @Test
  @Disabled("for some reasons")
  @Step("Screenshot is taken when test is skipped")
  @DisplayName("Screenshot is taken when test is skipped")
  @Description("Check screenshot is taken when test is skipped")
  public void testShouldBeSkipped() {
    LOG.info("Check screenshot is taken when test is skipped");
    $x(OnlinerHomePage.BAD_CATALOG_LINK).click();
    $$x(CatalogPage.CATALOG_ITEM_TITLE).shouldHave(size(11));
  }
}