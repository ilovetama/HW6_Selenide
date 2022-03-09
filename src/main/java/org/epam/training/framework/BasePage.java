package org.epam.training.framework;

import org.openqa.selenium.WebDriver;

public abstract class BasePage {

  private final WebDriver driver;
  private final WebDriverDiscovery webDriverDiscovery;

  public BasePage() {
    webDriverDiscovery = new WebDriverDiscovery();
    driver = webDriverDiscovery.getWebDriver();
  }
}
