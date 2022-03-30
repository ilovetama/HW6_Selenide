package com.epam.tests.listeners;

import static com.epam.tests.utils.ScreenshotUtils.takeScreenshotAndAttachToAllureReport;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestWatcher;

public class AllureListener implements TestWatcher {

  private static final Logger LOG = LogManager.getLogger(AllureListener.class.getName());

  public void testFailed(ExtensionContext context, Throwable cause) {
    LOG.info("Test Failed for: " + context.getDisplayName(), cause);
    takeScreenshotAndAttachToAllureReport();
  }

  public void testSuccessful(ExtensionContext context) {
    LOG.info("Test Successful for: " + context.getDisplayName());
  }

  public void testAborted(ExtensionContext context, Throwable cause) {
    LOG.info("Test Skipped for: " + context.getDisplayName(), cause);
    takeScreenshotAndAttachToAllureReport();
  }

}