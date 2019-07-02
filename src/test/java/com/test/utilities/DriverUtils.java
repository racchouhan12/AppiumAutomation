package com.test.utilities;

import com.test.helpers.KEYS;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.openqa.selenium.InvalidArgumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class DriverUtils {

    private WebDriver driver;

    private ThisRun thisRun = ThisRun.getInstance();

    private static Logger logger = LogManager.getLogger(DriverUtils.class.getName());
    private String platform;

    public DriverUtils(String platform) {
        this.platform = platform;
    }


    private WebDriver instantiateAndroidDriver() throws MalformedURLException {
        driver = new AndroidDriver<>(new URL("http://0.0.0.0:4723/wd/hub"), setCapabilitiesForAndroid());
        return driver;
    }

    private DesiredCapabilities setCapabilitiesForAndroid() {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.UDID, thisRun.getAsString(KEYS.UDID.toString())); //"emulator-5554"
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Android");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiautomator2");
        capabilities.setCapability(MobileCapabilityType.APP, thisRun.getAsString(KEYS.APP_PATH.toString()));
        capabilities.setCapability("autoGrantPermissions",true);

        return capabilities;
    }


    public WebDriver getDriver() throws MalformedURLException {
        logger.info("Instantiating Driver for : "+ platform);
        switch (platform.toLowerCase()) {
            case "android":
                return instantiateAndroidDriver();

            default:
                throw new InvalidArgumentException("Invalid platform type: set environment variable 'platform' as android");
        }
    }

    public void quitSession() {
        driver.quit();
    }
}
