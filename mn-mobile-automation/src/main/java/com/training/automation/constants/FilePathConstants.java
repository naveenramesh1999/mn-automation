package com.training.automation.constants;

import java.io.File;

/**
 * This class contains path of the common files/folders of the project.
 *
 * @author arun.pareek
 */
public class FilePathConstants {
    public static final String USER_DIR_PATH = System.getProperty("user.dir");
    public static final String RESOURCES_PATH = USER_DIR_PATH + File.separator + "src" + File.separator + "main" + File.separator + "resources" + File.separator;
    public static final String LOCATOR_HOME = RESOURCES_PATH + "locators" + File.separator;

    public static final String TESTNG_FILE_PATH = USER_DIR_PATH + File.separator + "testng.xml";
    public static final String CONFIG_FILE_PATH = RESOURCES_PATH + "config.properties";
    public static final String CLOUD_FILE_PATH = RESOURCES_PATH + "cloud.properties";
    public static final String EXTENT_REPORT_PATH = USER_DIR_PATH + "/test-output/ExtentReport.html";
    public static final String EXTENT_CONFIG_FILE_PATH = USER_DIR_PATH + "/test-output/extent-config.xml";

    // Messages App Related Constants
    public static final String MESSAGES_LOCATOR_FILE_PATH = FilePathConstants.LOCATOR_HOME+"messageshomepage.properties";
}
