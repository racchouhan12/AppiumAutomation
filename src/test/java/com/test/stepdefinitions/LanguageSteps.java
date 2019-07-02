package com.test.stepdefinitions;

import com.test.businessflows.LanguageSelection;
import cucumber.api.PendingException;
import cucumber.api.java8.En;

public class LanguageSteps implements En {

    public LanguageSteps() {
        Given("^I select my preferred language as \"([^\"]*)\"$", (String language) -> {
            new LanguageSelection().selectLanguage(language);
        });

    }

}
