package com.test.screens;

import com.test.Exceptions.InvalidInputException;
import com.test.Exceptions.NotImplementedException;
import com.test.screens.Android.AndroidVideoPlayingScreen;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public abstract class VideoPlayingScreen extends BaseScreen{

    protected Logger logger =  LogManager.getLogger(VideoPlayingScreen.class.getName());
    final static String platform = PLATFORM;

    public VideoPlayingScreen() {
        logger.info("VideoPlayingScreen intialized");
    }

    public static VideoPlayingScreen getInstance() {
        final String appType = platform;
        switch(appType) {
            case "android":
                return new AndroidVideoPlayingScreen();
            case "ios":
                throw new NotImplementedException();
            default:
                throw new InvalidInputException() ;
        }
    }

    public abstract void playVideo();
}


