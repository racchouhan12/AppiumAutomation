package com.test.stepdefinitions;

import com.test.helpers.*;
import com.test.utilities.AppiumServerUtils;
import com.test.utilities.DriverUtils;
import com.test.utilities.ScreenShotUtils;
import com.test.utilities.ThisRun;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

import java.net.MalformedURLException;


public class Hooks {

    private ThisRun thisRun  = ThisRun.getInstance();
    private static Logger logger = LogManager.getLogger(Hooks.class.getName());
    private DriverUtils driverUtils;
    private WebDriver driver;

    @Before
    public void setup(Scenario scenario) throws MalformedURLException {
        logger.info("Running scenario : "+ scenario.getName());
        AppiumServerUtils.startServer();
        addDriverProperties();
    }


    private void addDriverProperties() throws MalformedURLException {
        driverUtils = new DriverUtils(thisRun.getAsString(KEYS.PLATFORM.toString()));
        driver = driverUtils.getDriver();
        thisRun.add(KEYS.DRIVER, driver);
    }


    @After
    public void tearDown(Scenario scenario) {
        logger.info("Inside teardown(), now Browser will quit.....");
        ScreenShotUtils.embedScreenShotInReport(scenario, scenario.getName());
        driverUtils.quitSession();
        AppiumServerUtils.stopServer();
    }

}
