package org.epam.training.pageobject;

import org.epam.training.framework.BasePage;

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
}
