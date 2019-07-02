package com.test.screens.Android;

import com.test.screens.LanguageScreen;
import org.openqa.selenium.By;

public class AndroidLanguageScreen extends LanguageScreen {

    @Override
    public void selectLanguage(String languageToSelect) {
        final String chooseLanguageLocator = "btn_choose";
        final String xpathForLangaugeToSelect = String.format("//android.widget.TextView[@text='%s']", languageToSelect);
        final String continueLocator = "tv_continue";

        waitForElementToBeClickableAndClickOnElement(By.id(chooseLanguageLocator), 20);
        waitForElementToBeClickableAndClickOnElement(By.xpath(xpathForLangaugeToSelect));
        waitForElementToBeClickableAndClickOnElement(By.id(continueLocator));
    }
}
