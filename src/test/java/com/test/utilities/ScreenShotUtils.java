package com.test.utilities;

import cucumber.api.Scenario;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public final class ScreenShotUtils {
    private static Logger logger = LogManager.getLogger(ScreenShotUtils.class.getName());
    private static ThisRun thisRun = ThisRun.getInstance();

    private ScreenShotUtils() {
        logger.info("Initializing - ScreenShotUtils");

    }

    public static void embedScreenShotInReport(Scenario scenario, String scenarioName) {
        logger.debug("Finished running scenario - '" + scenarioName + "', Embedding screenshot in report");
        WebDriver driver = thisRun.driver();
        if (null != driver) {
            final byte[] screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
            scenario.embed(screenshot, "image/png"); // ... and embed it in the report.
        }
    }
}