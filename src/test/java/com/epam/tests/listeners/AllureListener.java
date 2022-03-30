package com.epam.tests.listeners;

import static com.epam.tests.utils.ScreenshotUtils.takeScreenshotAndAttachToAllureReport;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestWatcher;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AllureListener implements TestWatcher {

  private static final Logger LOG = LoggerFactory.getLogger(AllureListener.class);

  public void testFailed(ExtensionContext context, Throwable cause) {
    LOG.info("Test Failed for test {}: ", context.getDisplayName());
    takeScreenshotAndAttachToAllureReport();
  }

  public void testSuccessful(ExtensionContext context) {
    LOG.info("Test Successful for test {}: ", context.getDisplayName());
  }

  public void testAborted(ExtensionContext context, Throwable cause) {
    LOG.warn("Test Aborted for test {}: ", context.getDisplayName());
    takeScreenshotAndAttachToAllureReport();
  }

}