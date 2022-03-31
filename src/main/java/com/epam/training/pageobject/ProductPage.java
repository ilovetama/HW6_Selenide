package com.epam.training.pageobject;

import com.epam.training.framework.BasePage;
import java.util.Collection;
import org.openqa.selenium.By;

public class ProductPage extends BasePage {

    private static final String PRODUCT_NAME =
        "//a[contains(@class, 'product-title-link')]"
            + "/*[contains(@data-bind, 'product.full_name')]";

    public Collection<String> getProductName() {
        return getTextsFromWebElements(waitForElementsVisible(By.xpath(PRODUCT_NAME)));
    }
}
