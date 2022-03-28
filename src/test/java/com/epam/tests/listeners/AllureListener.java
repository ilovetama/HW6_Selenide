package com.epam.tests.listeners;

import static com.epam.tests.utils.ScreenshotUtils.takeScreenshotAndAttachToAllureReport;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestWatcher;

public class AllureListener implements TestWatcher {

  private static final Logger LOG = LogManager.getLogger(AllureListener.class);

  public void testFailed(ExtensionContext context, Throwable cause) {
    LOG.error("Test Failed for test {}: ", context.getDisplayName());
    takeScreenshotAndAttachToAllureReport();
  }

  public void testAborted(ExtensionContext context, Throwable cause) {
    LOG.warn("Test Aborted for test {}: ", context.getDisplayName());
    takeScreenshotAndAttachToAllureReport();
  }

}