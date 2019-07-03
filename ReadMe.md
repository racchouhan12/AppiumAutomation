
#  About Project

It is Appium - Cucumber (BDD) project use to automate Andriod/IOS application.
Project has Page Object model as its design pattern. I have Windows so I configured and ran this test only on windows machine for Android only.
We can run the test in Android emulator or real device.


## Pre-requisites:

1. Java8 or higher should be installed.
2. NodeJS should be installed (Version - 6.4.1 or higher) [NodeJS installation guide](https://www.guru99.com/download-install-node-js.html#1)
3. Install appium - npm install -g appium  (I have used 1.13.0)
4. Steps for Android sdk can be found in [Android Libraries and SDK installation Guide](https://www.toolsqa.com/mobile-automation/appium/appium-tutorial/)
5. Set JAVA_HOME
6. Install gradle and set GRADLE_HOME
7. Add JAVA_HOME\bin and GRADLE_HOME\bin in your Path variable.
8. Add ANDROID_HOME and other required values in path variable using Step 4.

## Framework structure:

1. Project is a gradle project.
2. Our framework code lies mainly in src/test folder.
3. Project has three layer approach or calling:
    feature -> stepdefinitions -> businessflows -> screens

    1.      feature -> It is test/resources. It will contain all feature files (.feature).
    2.      stepdefinitions -> This folder has java files which contains step definitions corresponding in feature file.
    3.      businessflows -> This folder has java files which contains which contains business logic or assertions
    4.      screens -> This folder has java files which perform actual actions on the web browser.
            1. There are base screens classes which are abstract.
            2. These abstarct classes are extended by respective Android / IOS screens.

4. In resources there are couple of more files like .apk, log4j2.properties.
5. We have utilities package which contains utilities for Appium Server, driver, reporting and maintaing session state of objects(ThisRun.java)
6. Call flows are as follows:
    Now execution will begin

        Call hierarchy are as follows:

        Runcuckes ->  Hooks:  -> features ->  stepdefinitions -> businessflows ->  screens

        ######  Note: ThisRun.java will be called in Hooks itself and driver intialization and other Keys are setup here

 ##  Rules to be followed:

 1. We should not call screens directly from stepdefinitions call hierarchy should be maintained (stepdefinitions -> businessflows -> screens).
 2. All assertions should be done in businessflows only
 3. Mutiple businessflows can be called from stepdefinitions
 4. Another businessflows can be called within one businessflow

 ##  How to run Test:

 1. To run specific scenarios use command :
    For Windows/MAC you need to set environment variables
    1. set run=@foo    [Tag to run]
    2. set app_name=Hotstar.apk  [name of apk]
    3. set udid=emulator-5554   [Note: Value should be device id connected, command to get devices "adb devices"]
    4. set platform=android/ios

 2. To run all scenarios use command : gradle cucumber
