package com.epam.training.pageobject;

import com.epam.training.framework.BasePage;

public class OnlinerHomePage extends BasePage {

  public static final String CATALOG_LINK = "//a[contains(@href, 'https://catalog.onliner.by')"
      + " and contains(text(), 'Каталог')]";

  public static final String BAD_CATALOG_LINK = "//a[contains(@href, 'https://auto.onliner.by')"
      + " and contains(text(), 'Каталог')]";
}
