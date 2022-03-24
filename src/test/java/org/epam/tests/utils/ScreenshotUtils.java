package org.epam.tests.utils;

import com.codeborne.selenide.Screenshots;
import io.qameta.allure.Allure;
import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class ScreenshotUtils {

  protected static final Logger LOG = LoggerFactory.getLogger(ScreenshotUtils.class);

  public static void takeScreenshotAndAttachToAllureReport() {
    try {
      File screenshotAs = Screenshots.takeScreenShotAsFile();
      Allure.addAttachment("Screenshot", FileUtils.openInputStream(screenshotAs));
    } catch (IOException var1) {
      LOG.error("Error creating screenshot");
    }
  }
}