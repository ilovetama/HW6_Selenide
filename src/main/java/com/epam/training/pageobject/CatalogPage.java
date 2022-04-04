package com.epam.training.pageobject;

import static java.lang.String.format;

import com.epam.training.framework.BasePage;
import org.openqa.selenium.By;

public class CatalogPage extends BasePage {

  public static final String CATALOG_ITEM_TITLE =
      "//*[@class = 'catalog-navigation-classifier__item-title-wrapper']";
  public static final String CATALOG_CLASSIFIER_LINK =
      "//li[contains(@class, 'catalog-navigation-classifier__item') and @data-id=2]";
  public static final String CATALOG_MENU_ITEM_TITLE =
      "//*[@class = 'catalog-navigation-list__category' and @data-id='2']"
          + "//*[@class = 'catalog-navigation-list__aside-item']";
  public static final String CATALOG_CLASSIFIER_CATEGORY_LINK =
      "//div[@class='catalog-navigation-list__aside-title' and contains(text(),'Комплектующие')]";
  public static final String PRODUCT_TITLE =
      "//div[@class='catalog-navigation-list__aside-title' and contains(text(),"
          + " 'Комплектующие') and not (contains(text(), 'Комплектующие для'))]"
          + "//following-sibling::div[@class='catalog-navigation-list__dropdown']"
          + "//a//*[contains(@class, 'title')]";
  public static final String PRODUCT_DESCRIPTION =
      "//div[@class='catalog-navigation-list__aside-title' and contains(text(),"
          + " 'Комплектующие') and not (contains(text(), 'Комплектующие для'))]"
          + "//following-sibling::div[@class='catalog-navigation-list__dropdown']"
          + "//a//*[contains(@class, 'description') and contains(text(), 'товар')]";
  private static final String CATALOG_CLASSIFIER_LINK_XPATH_PATTERN =
      "//*[contains(@class, 'catalog-navigation-classifier__item')]//*[contains(text(), '%s')]";
  private static final String CATALOG_CLASSIFIER_CATEGORY_XPATH_PATTERN =
      "//*[@class='catalog-navigation-list__aside-title' and contains(text(), '%s')]";
  private static final String PRODUCT_LINK_XPATH_PATTERN =
      "//*[contains(@class, 'item_active')]//a[.//*[contains(text(), '%s')]]";
  public static final int QUANTITY_OF_MENU_ITEMS = 10;

  public CatalogPage clickOnCatalogClassifierLink(String link) {
    waitForElementVisible(By.xpath(format(CATALOG_CLASSIFIER_LINK_XPATH_PATTERN, link))).click();
    return this;
  }

  public CatalogPage selectCategory(String category) {
    waitForElementVisible(
        By.xpath(format(CATALOG_CLASSIFIER_CATEGORY_XPATH_PATTERN, category))).click();
    return this;
  }

  public ProductPage selectProduct(String product) {
    waitForElementVisible(By.xpath(format(PRODUCT_LINK_XPATH_PATTERN, product))).click();
    return new ProductPage();
  }
}