package com.epam.tests.api_tests;

import static org.assertj.core.api.Assertions.assertThat;

import com.epam.training.rest_api.service.ProductService;
import java.util.List;
import org.junit.jupiter.api.Test;

public class ChooseATypeOfProductTest extends BaseTest {

  @Test
  public void testUserIsAbleToChooseATypeOfProduct() {
    ProductService productService = new ProductService();
    List<String> typesOfProducts = productService.getNameOfProductType();
    assertThat(typesOfProducts)
        .as("Name_prefix does not contains type of product")
        .allMatch(element -> element.contains("Роллы"));
  }
}
