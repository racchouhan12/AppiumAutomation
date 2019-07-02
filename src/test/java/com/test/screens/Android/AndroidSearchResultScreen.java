package com.test.screens.Android;

import com.test.screens.SearchResultScreen;
import com.test.screens.VideoPlayingScreen;
import org.openqa.selenium.By;

public class AndroidSearchResultScreen extends SearchResultScreen {
    @Override
    public SearchResultScreen searchMedia(String mediaToSearchText) {
        final String searchIconLocator = "action_search";
        final String searchTextBoxLocator = "search_text";

        waitForElementToBeClickableAndClickOnElement(By.id(searchIconLocator));
        waitForElementAndSendTextInElement(By.id(searchTextBoxLocator), mediaToSearchText, 15);
        hideKeyBoard();
        return SearchResultScreen.getInstance();
    }

    public VideoPlayingScreen clickOnSearchResult(int number) {
        final String playIconNumber = String.format("//android.widget.ImageView[@resource-id='in.startv.hotstar:id/play' and @index = %s]", number);

        waitForElementToBeClickableAndClickOnElement(By.xpath(playIconNumber), 20);
        return VideoPlayingScreen.getInstance();
    }
}
