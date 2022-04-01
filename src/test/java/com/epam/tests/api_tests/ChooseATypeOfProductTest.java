package com.epam.tests.api_tests;

import static org.assertj.core.api.Assertions.assertThat;

import com.codeborne.selenide.junit5.SoftAssertsExtension;
import com.epam.training.rest_api.service.ProductService;
import io.qameta.allure.Description;
import io.qameta.allure.Step;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(SoftAssertsExtension.class)
public class ChooseATypeOfProductTest extends BaseTest {

  @Test
  @Step("User is able to choose a product type")
  @DisplayName("User is able to choose a product type")
  @Description("Check that user is able to choose a product type")
  public void testUserIsAbleToChooseATypeOfProduct() {
    LOG.info("Check that user is able to choose a product type");
    ProductService productService = new ProductService();
    List<String> typesOfProducts = productService.getNameOfProductType();
    assertThat(typesOfProducts)
        .as("Name_prefix does not contains type of product")
        .allMatch(element -> element.contains("Роллы"));
    LOG.info(typesOfProducts);
  }
}
