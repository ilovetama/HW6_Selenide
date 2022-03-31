package com.epam.tests.api_tests;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

import com.epam.training.navigation.OnlinerNavigation;
import com.epam.training.pageobject.OnlinerHeader;
import com.epam.training.rest_api.model.ProductFacet;
import com.epam.training.rest_api.service.ProductService;
import java.util.Collection;
import java.util.List;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class ProductNavigationTest extends BaseTest {

  private static final OnlinerHeader onlinerHeader = new OnlinerHeader();

  @BeforeAll
  public static void navigateToOnliner() {
    OnlinerNavigation.navigateToOnlinerHomePage();
  }

  @Test
  public void testUserIsAbleToNavigateToProductPageViaCatalog() {
    Collection<String> ProductName = onlinerHeader
        .clickOnCatalogNavigationLink()
        .clickOnCatalogClassifierLink("Еда")
        .selectCategory("Суши")
        .selectProduct("Суши Весла")
        .getProductName();
    assertThat(ProductName)
        .as("Product name is not displayed")
        .isNotEmpty();

    ProductService productService = new ProductService();
    List<ProductFacet> productFacets = productService.getProductFacetItems();
    LOG.info(productFacets);
  }

  @AfterAll
  public static void closeBrowser() {
    onlinerHeader.closeBrowser();
  }
}
