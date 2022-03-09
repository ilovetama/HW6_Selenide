package org.epam.tests;

import static com.codeborne.selenide.Selenide.open;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeEach;

public class BaseTest {

  public static final String ONLINER_HOME_PAGE_LINK = "https://onliner.by";

  @BeforeEach
  public void setUp() {

    Configuration.browserSize = "1920x1080";
    open(ONLINER_HOME_PAGE_LINK);

  }
}
