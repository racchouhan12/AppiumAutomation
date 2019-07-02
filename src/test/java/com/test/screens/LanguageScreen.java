package com.test.screens;

import com.test.Exceptions.InvalidInputException;
import com.test.Exceptions.NotImplementedException;
import com.test.helpers.KEYS;
import com.test.screens.Android.AndroidLanguageScreen;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public abstract class LanguageScreen extends BaseScreen{

    protected Logger logger =  LogManager.getLogger(LanguageScreen.class.getName());
    final static String platform = PLATFORM;

    public LanguageScreen() {
        logger.info("LanguageScreen intialized");
    }

    public static LanguageScreen getInstance() {
        final String appType = platform;
        switch(appType) {
            case "android":
                return new AndroidLanguageScreen();
            case "ios":
                throw new NotImplementedException();
            default:
                throw new InvalidInputException() ;
        }
    }

    public abstract void selectLanguage(String languageToSelect);
}
