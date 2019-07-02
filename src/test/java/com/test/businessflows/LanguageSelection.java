package com.test.businessflows;

import com.test.screens.LanguageScreen;

public class LanguageSelection {

    public void selectLanguage(String language) {
        LanguageScreen.getInstance().selectLanguage(language);
    }
}
