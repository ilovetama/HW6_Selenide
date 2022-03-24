package com.epam.tests.listeners;

import com.epam.tests.tests.BaseTest;
import com.epam.tests.utils.ScreenshotUtils;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestWatcher;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AllureListener implements TestWatcher {

  private static final Logger LOG = LoggerFactory.getLogger(BaseTest.class);

  public void testFailed(ExtensionContext context, Throwable cause) {
    LOG.info("Test Failed for test {}: ", context.getDisplayName());
    ScreenshotUtils.takeScreenshotAndAttachToAllureReport();
  }

  public void testAborted(ExtensionContext context, Throwable cause) {
    LOG.info("Test Aborted for test {}: ", context.getDisplayName());
    ScreenshotUtils.takeScreenshotAndAttachToAllureReport();
  }
}