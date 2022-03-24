package org.epam.tests.tests;

import static com.codeborne.selenide.Selenide.open;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeEach;

public class BaseTest {

  public static final String ONLINER_HOME_PAGE_LINK = "https://onliner.by";

  @BeforeEach
  public void setUp() {
    SelenideLogger.addListener("AllureSelenide",
        (new AllureSelenide()).screenshots(true).savePageSource(true));
    Configuration.browserSize = "1600x900";
    open(ONLINER_HOME_PAGE_LINK);

  }
}
