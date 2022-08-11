package com.training.automation.base;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.training.automation.appium.AppiumManager;
import com.training.automation.constants.FilePathConstants;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.testng.annotations.*;

import java.lang.reflect.Method;

/**
 * This is base class initializing appium drivers
 *
 * @author arun.pareek
 */
public class MobileTestBase {
    public AppiumDriver<MobileElement> driver;
    public static ExtentReports extent;
    public static ExtentTest test;

    @BeforeSuite
    public void beforeSuite() {
        extent = new ExtentReports(FilePathConstants.EXTENT_REPORT_PATH);
    }

    @BeforeClass
    public void beforeClass() {
        initDriver();
    }

    @BeforeMethod
    public void beforeMethod(Method method) {
        test = extent.startTest((this.getClass().getSimpleName() + "::" +method.getName()), method.getName());
    }

    @AfterMethod
    public void afterMethod() {
        extent.endTest(test);
    }

    @AfterClass
    public void afterClass() {
        if (driver!=null) {
            driver.quit();
        }
    }

    @AfterSuite
    public void afterSuite() {
        extent.flush();
        extent.close();
    }

    /**
     * This method initializes the mobile driver
     */
    private void initDriver() {
        AppiumManager appiumManager = new AppiumManager();
        if (driver==null) {
            driver = appiumManager.getMobileDriver();
        }
    }
}
