package com.test.screens;

import com.test.helpers.KEYS;
import com.test.utilities.ThisRun;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;

public abstract class BaseScreen {
    final WebDriver driver ;
    protected static Logger logger = LogManager.getLogger(BaseScreen.class.getName());
    static ThisRun thisRun = ThisRun.getInstance();
    protected final static String PLATFORM = thisRun.getAsString(KEYS.PLATFORM.name());

    protected BaseScreen() {
        logger.info("BaseScreen initialized...");

        driver = thisRun.driver();

    }


    protected void sendText(MobileBy by, String text) {
        driver.findElement(by).sendKeys(text);

    }

    protected void clickOnElement(By by) {
        //waitForElementToBeClickableAndClickOnElement(MobileBy.AndroidUIAutomator("new UiSelector().resourceId(\"com.tv.v18.viola:id/google_login_btn_lyt\").instance(0)"), 10);
        driver.findElement(by).click();

    }

    protected void waitForElementAndSendTextInElement(By by, String text) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(by)).sendKeys(text);
    }

    protected void waitForElementAndSendTextInElement(By by, String text, int timeToWaitInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, timeToWaitInSeconds);
        wait.until(ExpectedConditions.elementToBeClickable(by)).sendKeys(text);
    }

    protected void waitForElementToBeClickableAndClickOnElement(By by) {
        waitForElementToBeClickableAndClickOnElement(by, 10);
    }

    protected void waitForElementToBeClickableAndClickOnElement(By by, int timeOut) {
        logger.info("Value of driver "+driver);
        WebDriverWait wait = new WebDriverWait(driver, timeOut);
        wait.until(ExpectedConditions.elementToBeClickable(by)).click();
    }

    protected void waitForElementToBeClickable(By by, int timeOut) {
        logger.info("Value of driver "+driver);
        WebDriverWait wait = new WebDriverWait(driver, timeOut);
        wait.until(ExpectedConditions.elementToBeClickable(by));
    }

    protected void hideKeyBoard() {
        ((AppiumDriver)driver).hideKeyboard();
    }

    protected Object executeJavaScript(String script) {
        return ((JavascriptExecutor)driver).executeScript(script);
    }


}
