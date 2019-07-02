package com.test.scripts;

import com.test.utilities.ThisRun;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;
import org.apache.logging.log4j.LogManager;

import java.io.File;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;


public class Command {
    private static org.apache.logging.log4j.Logger logger = LogManager.getLogger(Command.class.getName());
    private static final ThisRun thisRun = ThisRun.getInstance();
    private Command() {

    }

    public static void runShellCommand(String cmd, String message, int sleepFor) {
        try {
            logger.info(message + " - '" + (cmd) + "'");
            Process p = Runtime.getRuntime().exec(cmd);
            p.waitFor();
            thisRun.waitFor(sleepFor);
            logger.info("Done running command - '" + message + "' - " +(cmd) + "'");
        } catch (Exception e) {
            logger.error("Error running command: '" + message + "' - '" + (cmd) + "'\n" + e.getMessage());
        }
    }





}
