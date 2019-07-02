package com.test.stepdefinitions;

import com.test.businessflows.Search;
import com.test.screens.SearchResultScreen;
import cucumber.api.PendingException;
import cucumber.api.java8.En;

public class SearchSteps implements En {

    public SearchSteps() {
        When("^I search for \"([^\"]*)\" video and play video number \"([^\"]*)\"$", (String videoName, String videoNumber) -> {
            new Search().searchAndClickOnMedia(videoName, Integer.parseInt(videoNumber));
        });

    }

}
