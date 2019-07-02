package com.test.screens;

import com.test.Exceptions.InvalidInputException;
import com.test.Exceptions.NotImplementedException;
import com.test.screens.Android.AndroidSearchResultScreen;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public abstract class SearchResultScreen extends BaseScreen{

    protected Logger logger =  LogManager.getLogger(SearchResultScreen.class.getName());
    final static String platform = PLATFORM;

    public SearchResultScreen() {
        logger.info("SearchResultScreen intialized");
    }

    public static SearchResultScreen getInstance() {
        final String appType = platform;
        switch(appType) {
            case "android":
                return new AndroidSearchResultScreen();
            case "ios":
                throw new NotImplementedException();
            default:
                throw new InvalidInputException() ;
        }
    }

    public abstract SearchResultScreen searchMedia(String mediaToSearchText);
    public abstract VideoPlayingScreen clickOnSearchResult(int number);
}

