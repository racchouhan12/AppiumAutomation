package com.test.businessflows;

import com.test.screens.SearchResultScreen;

public class Search {

    public void searchAndClickOnMedia(String searchString, int number) {
        searchMedia(searchString);
        clickOnSearchMedia(number);
    }

    public void searchMedia(String searchString) {
        SearchResultScreen.getInstance().searchMedia(searchString);

    }

    public void clickOnSearchMedia(int number) {
        SearchResultScreen.getInstance().clickOnSearchResult(number);
    }
}
