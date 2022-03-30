package com.epam.tests.tests;

import static com.codeborne.selenide.AssertionMode.SOFT;
import static com.codeborne.selenide.Selenide.open;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.TestWatcher;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BaseTest implements TestWatcher {

  private static final String ONLINER_HOME_PAGE_LINK = "https://onliner.by/";
  protected static final Logger LOG = LoggerFactory.getLogger(BaseTest.class);

  @BeforeEach
  void setUp() {

    SelenideLogger.addListener("AllureSelenide",
        (new AllureSelenide()).screenshots(true).savePageSource(false));
    Configuration.savePageSource = false;
    Configuration.screenshots = false;
    Configuration.assertionMode = SOFT;
    Configuration.browserSize = "1600x900";
    open(ONLINER_HOME_PAGE_LINK);

  }
}
