package com.epam.tests.api_tests;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

import com.codeborne.selenide.junit5.SoftAssertsExtension;
import com.epam.tests.listeners.AllureListener;
import com.epam.training.navigation.OnlinerNavigation;
import com.epam.training.rest_api.model.ProductFacet;
import com.epam.training.rest_api.service.ProductService;
import io.qameta.allure.Description;
import io.qameta.allure.Step;
import java.util.Collection;
import java.util.List;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(AllureListener.class)
@ExtendWith(SoftAssertsExtension.class)
public class ProductNavigationTest extends BaseTest {

  @BeforeAll
  public static void navigateToOnliner() {
    OnlinerNavigation.navigateToOnlinerHomePage();
  }

  @Test
  @Step("User is able to navigate to product page via catalog")
  @DisplayName("User is able to navigate to product page via catalog")
  @Description("Check that user is able to navigate to product page via catalog")
  public void testUserIsAbleToNavigateToProductPageViaCatalog() {
    LOG.info("Check that user is able to navigate to product page via catalog");
    Collection<String> ProductName = onlinerHeader
        .clickOnCatalogNavigationLink("Каталог")
        .clickOnCatalogClassifierLink("Еда")
        .selectCategory("Суши")
        .selectProduct("Суши Весла")
        .getProductName();
    assertThat(ProductName)
        .as("Product name is not displayed")
        .isNotEmpty();
    ProductService productService = new ProductService();
    List<ProductFacet> productFacets = productService.getProductFacetItems();
    LOG.info(productFacets.toString());
  }

  @AfterAll
  public static void closeBrowser() {
    onlinerHeader.closeBrowser();
  }
}
