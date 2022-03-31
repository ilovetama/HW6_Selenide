package com.epam.training.framework;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

public class WebDriverDiscovery {

  private static final int IMPLICITLY_WAIT_TIMEOUT = 6;
  private static final int PAGE_LOAD_TIMEOUT = 20;
  private static final ThreadLocal<RemoteWebDriver> remoteWebDriver =
      new ThreadLocal();

  public WebDriverDiscovery() {
    if (remoteWebDriver.get() == null) {
      startBrowser();
    }
  }

  private void startBrowser() {
    setWebDriver(Driver.getByDriverType(System.getProperty("driverType"))
        .getWebDriverCreator()
        .create());
  }

  private static void setWebDriver(RemoteWebDriver driver) {
    remoteWebDriver.set(driver);
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(IMPLICITLY_WAIT_TIMEOUT));
    driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(PAGE_LOAD_TIMEOUT));
  }

  public WebDriver getWebDriver() {
    return remoteWebDriver.get();
  }
}
