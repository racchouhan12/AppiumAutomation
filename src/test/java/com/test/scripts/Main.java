package com.test.scripts;

import com.test.helpers.KEYS;
import com.test.utilities.FileUtils;
import com.test.utilities.ThisRun;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Main {
    private static Logger logger = LogManager.getLogger(Main.class.getName());
    private static ThisRun thisRun = ThisRun.getInstance();
    private static final String FEATURE_FILE_PATH = thisRun.getAsString(KEYS.FEATURE_FILES_PATH.name());
    private static String reportFolderPath;

    public Main() {

    }

    private static String createReportFolder(String isJenkins) {
        if("true".equals(isJenkins)) {
            reportFolderPath = thisRun.getAsString(KEYS.PROJECT_PATH.name())+"/reports";
        } else {
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd_HH_mm_ss");
            reportFolderPath = thisRun.getAsString(KEYS.PROJECT_PATH.name()) + "/reports/reports_" + dateFormat.format(new Date());
        }
        FileUtils.createFolder(reportFolderPath);
        logger.info("Report folder created: "+ reportFolderPath);

        return reportFolderPath;
    }

    private static String getRunTag() {
        return System.getenv("run");
    }

    private static String[] getExcludeTags() {
        String[] excludeTags = {"~@wip", "~@failing"};
        return excludeTags;
    }

    private static void generateHTMLReports(String reportPath) {
        String[] reportArgs = {reportPath};
        com.test.utilities.Reporter.main(reportArgs);
    }

    private static String[] getCucumberOptions() {

        String[] commonOptions = {
                "--glue",
                "com.test.automation.stepdefinitions",
                "--tags",
                getExcludeTags()[0],
                "--tags",
                getExcludeTags()[1],
                "--plugin",
                "pretty",
                "--plugin",
                "html:"+reportFolderPath+"/html",
                "--plugin",
                "json:"+reportFolderPath+"/cucumber.json",
                FEATURE_FILE_PATH
        };
        if (getRunTag() != null) {
           logger.info("Running all Scenarios: with tags: " +getRunTag() + " (except @wip, @failing)......" );
            String[] runtag =  {"--tags", getRunTag()};
            return ArrayUtils.addAll(runtag, commonOptions);

        }
        logger.info("Running all Scenarios except @wip, @failing...");
            return commonOptions;

    }

    public static void main(String[] argv) throws Throwable {
        String reportPath = createReportFolder(System.getenv("isJenkins"));
        logger.info("Starting Scenario execution....");
        byte exitstatus = cucumber.api.cli.Main.run(getCucumberOptions(), Thread.currentThread().getContextClassLoader());
        generateHTMLReports(reportPath);
        logger.info("Exit status is:" +exitstatus);
    }
}
