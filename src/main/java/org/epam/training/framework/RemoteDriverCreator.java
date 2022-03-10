package org.epam.training.framework;

import java.net.MalformedURLException;
import java.net.URL;
import org.openqa.selenium.Platform;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class RemoteDriverCreator implements WebDriverCreator<RemoteWebDriver> {

  private static final String URL = "http://localhost:4444";

  @Override
  public RemoteWebDriver create() {
    DesiredCapabilities capabilities = new DesiredCapabilities();
    FirefoxOptions firefoxOptions = new FirefoxOptions();
    capabilities.setPlatform(Platform.WIN10);
    firefoxOptions.addArguments("start-maximized");
    firefoxOptions.merge(capabilities);
    return new RemoteWebDriver(getGridUrl(), firefoxOptions);
  }

  private URL getGridUrl() {
    try {
      return new URL(System.getProperty(URL));
    } catch (MalformedURLException e) {
      throw new IllegalStateException(e.getMessage(), e);
    }
  }
}
