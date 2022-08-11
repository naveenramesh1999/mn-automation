package com.training.automation.appium;

import com.training.automation.constants.CloudPropertiesKeys;
import com.training.automation.constants.ConfigPropertiesKeys;
import com.training.automation.constants.FilePathConstants;
import com.training.automation.enums.CloudRunPlatform;
import com.training.automation.enums.DesiredCapability;
import com.training.automation.enums.DevicePlatform;
import com.training.automation.enums.RunMode;
import com.training.automation.utils.PropertyParser;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * This class contains methods related to launching application
 * as local or cloud.
 *
 * @author arun.pareek
 */
public class AppiumManager {
    PropertyParser configPropertyParser;
    PropertyParser cloudPropertyParser;

    public AppiumManager() {
        configPropertyParser = new PropertyParser(FilePathConstants.CONFIG_FILE_PATH);
        cloudPropertyParser = new PropertyParser(FilePathConstants.CLOUD_FILE_PATH);
    }

    /**
     * This method returns appium driver instance according run mode
     * defined in config.properties
     *
     * @return @{@link AppiumDriver} instance
     */
    public AppiumDriver<MobileElement> getMobileDriver() {
        AppiumDriver<MobileElement> driver = null;
        String automationRunMode = configPropertyParser.getPropertyValue(ConfigPropertiesKeys.AUTOMATION_RUN_MODE_KEY);

        switch(RunMode.valueOf(automationRunMode)) {
            case local:
                driver = getLocalDriver();
                break;
            case cloud:
                driver = getCloudDriver();
                break;
        }

        return driver;
    }

    /**
     * This method creates local appium driver instance
     *
     * @return @{@link AppiumDriver} instance
     */
    private AppiumDriver<MobileElement> getLocalDriver() {
        AppiumDriver<MobileElement> driver;

        URL appiumURL = getAppiumURL();
        DesiredCapabilities desiredCapabilities = getDesiredCapabilities();

        if (appiumURL==null) {
            System.out.println("Failed to get driver! Appium URL is null!");
            return null;
        }

        if (desiredCapabilities==null) {
            System.out.println("Failed to get driver! DesiredCapabilities is null!");
        }

        driver = new AppiumDriver<>(appiumURL, desiredCapabilities);
        return  driver;
    }

    /**
     * This method creates a cloud appium driver instance according to
     * cloud run platform defined in cloud.properties
     *
     * @return @{@link AppiumDriver} instance
     */
    private AppiumDriver<MobileElement> getCloudDriver() {
        AppiumDriver<MobileElement> driver = null;

        String cloudRunPlatform = cloudPropertyParser.getPropertyValue(CloudPropertiesKeys.CLOUD_RUN_PLATFORM_KEY);

        switch(CloudRunPlatform.valueOf(cloudRunPlatform)) {
            case browserstack:
                driver = getBrowserStackDriver();
                break;
            case saucelabs:
                System.out.println("SauceLabs Not Supported!");
                break;
            case kobiton:
                System.out.println("Kobiton Not Supported!");
                break;
        }

        return driver;
    }

    /**
     * This method creates BrowserStack appium driver instance.
     *
     * @return @{@link AppiumDriver} instance
     */
    private AppiumDriver<MobileElement> getBrowserStackDriver() {
        AppiumDriver<MobileElement> driver;

        URL browserStackURL = getBrowserStackURL();
        DesiredCapabilities desiredCapabilities = getBrowserStackDesiredCapabilities();

        if (browserStackURL==null) {
            System.out.println("Failed to get BrowserStack driver! Appium URL is null!");
            return null;
        }

        if (desiredCapabilities==null) {
            System.out.println("Failed to get BrowserStack driver! DesiredCapabilities is null!");
        }

        driver = new AppiumDriver<>(browserStackURL, desiredCapabilities);

        return driver;
    }

    /**
     * This method return appium server url
     * @return @{@link URL} instance for appium url
     */
    private URL getAppiumURL() {
        String appiumServerURL = configPropertyParser.getPropertyValue(ConfigPropertiesKeys.APPIUM_URL_KEY);

        URL appiumURL = null;

        if (appiumServerURL.length()!=0) {
            try {
                appiumURL = new URL(appiumServerURL);
            } catch (MalformedURLException malformedURLException) {
                malformedURLException.getLocalizedMessage();
            }
        } else {
            System.out.println("Please provide appium server url to 'appium.url' key in config.properties");
        }

        return appiumURL;
    }

    /**
     * This method return desired capabilities instance for Android/iOS
     *
     * @return @{@link DesiredCapabilities} instance
     */
    private DesiredCapabilities getDesiredCapabilities() {

        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();

        String platformName = configPropertyParser.getPropertyValue(ConfigPropertiesKeys.PLATFORM_NAME_KEY);
        String platformVersion = configPropertyParser.getPropertyValue(ConfigPropertiesKeys.PLATFORM_VERSION_KEY);
        String deviceName = configPropertyParser.getPropertyValue(ConfigPropertiesKeys.DEVICE_NAME_KEY);

        if (platformName.length()==0) {
            System.out.println("Please provide your device platform name.");
            return null;
        }

        if (platformVersion.length()==0) {
            System.out.println("Please provide a platform version.");
            return null;
        }

        if (deviceName.length()==0) {
            System.out.println("Please provide a device name.");
            return null;
        }

        desiredCapabilities.setCapability(DesiredCapability.PLATFORM_NAME.getValue(), platformName);
        desiredCapabilities.setCapability(DesiredCapability.PLATFORM_VERSION.getValue(), platformVersion);
        desiredCapabilities.setCapability(DesiredCapability.DEVICE_NAME.getValue(), deviceName);

        String appPath = configPropertyParser.getPropertyValue(ConfigPropertiesKeys.APP_KEY);

        if (appPath.length()==0) {

            if(platformName.equalsIgnoreCase(DevicePlatform.ANDROID.getValue())) {
                String appPackage = configPropertyParser.getPropertyValue(ConfigPropertiesKeys.APP_PACKAGE_KEY);
                String appActivity = configPropertyParser.getPropertyValue(ConfigPropertiesKeys.APP_ACTIVITY_KEY);

                if (appPackage.length()==0) {
                    System.out.println("Please provide an app package.");
                    return null;
                }

                if (appActivity.length()==0) {
                    System.out.println("Please provide an app activity.");
                    return null;
                }

                desiredCapabilities.setCapability(DesiredCapability.APP_PACKAGE.getValue(), appPackage);
                desiredCapabilities.setCapability(DesiredCapability.APP_ACTIVITY.getValue(), appActivity);

            } else if(platformName.equalsIgnoreCase(DevicePlatform.IOS.getValue())) {
                String bundleId = configPropertyParser.getPropertyValue(ConfigPropertiesKeys.BUNDLE_ID_KEY);
                String UDID = configPropertyParser.getPropertyValue(ConfigPropertiesKeys.UDID_KEY);

                if (bundleId.length()==0) {
                    System.out.println("Please provide a bundle id.");
                    return null;
                }

                if (UDID.length()==0) {
                    System.out.println("Please provide a device udid.");
                    return null;
                }

                desiredCapabilities.setCapability(DesiredCapability.BUNDLE_ID.getValue(), bundleId);
                desiredCapabilities.setCapability(DesiredCapability.UDID.getValue(), UDID);
            } else {
                System.err.println("Invalid Platform Name: Please provide a platform name as iOS or Android.");
            }
        } else {
            if(platformName.equalsIgnoreCase(DevicePlatform.ANDROID.getValue())
                    || platformName.equalsIgnoreCase(DevicePlatform.IOS.getValue())) {
                desiredCapabilities.setCapability(DesiredCapability.APP.getValue(), appPath);
            } else {
                System.err.println("Invalid Platform Name: Please provide a platform name as iOS or Android.");
            }

        }

        return desiredCapabilities;
    }

    /**
     * This method returns BrowserStack server url
     *
     * @return @{@link URL} instance for appium url
     */
    private URL getBrowserStackURL() {
        String userName = cloudPropertyParser.getPropertyValue(CloudPropertiesKeys.BS_USERNAME_KEY);
        String accessKey = cloudPropertyParser.getPropertyValue(CloudPropertiesKeys.BS_ACCESS_KEY_KEY);

        URL browserStackURL = null;
        if (userName.length()!=0 && accessKey.length()!=0) {
            String browserStackUrlString = "https://"+userName+":"+accessKey+"@hub-cloud.browserstack.com/wd/hub";

            try {
                browserStackURL = new URL(browserStackUrlString);
            } catch (MalformedURLException malformedURLException) {
                malformedURLException.getLocalizedMessage();
            }
        } else {
            System.out.println("Please provide a valid BrowserStack Username & Access Key.");
        }

        return browserStackURL;
    }

    /**
     * This method return BrowserStack desired capabilities instance
     * for Android/iOS
     *
     * @return @{@link DesiredCapabilities} instance
     */
    private DesiredCapabilities getBrowserStackDesiredCapabilities() {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();

        String platformName = cloudPropertyParser.getPropertyValue(CloudPropertiesKeys.BS_PLATFORM_NAME_KEY);
        String platformVersion = cloudPropertyParser.getPropertyValue(CloudPropertiesKeys.BS_PLATFORM_VERSION_KEY);
        String deviceName = cloudPropertyParser.getPropertyValue(CloudPropertiesKeys.BS_DEVICE_NAME_KEY);
        String projectName = cloudPropertyParser.getPropertyValue(CloudPropertiesKeys.BS_PROJECT_NAME_KEY);
        String build = cloudPropertyParser.getPropertyValue(CloudPropertiesKeys.BS_BUILD_KEY);
        String name = cloudPropertyParser.getPropertyValue(CloudPropertiesKeys.BS_NAME_KEY);
        String appPath = cloudPropertyParser.getPropertyValue(CloudPropertiesKeys.BS_APP_KEY);

        if (platformName.length()==0) {
            System.out.println("BrowserStack: Please provide a platform name.");
            return null;
        }

        if(!(platformName.equalsIgnoreCase(DevicePlatform.ANDROID.getValue()) || platformName.equalsIgnoreCase(DevicePlatform.IOS.getValue()))) {
            System.err.println("BrowserStack: Invalid Platform Name: Please provide a platform name as iOS or Android.");
            return null;
        }

        if (platformVersion.length()==0) {
            System.out.println("BrowserStack: Please provide a platform version.");
            return null;
        }

        if (deviceName.length()==0) {
            System.out.println("BrowserStack: Please provide a device name.");
            return null;
        }

        if (projectName.length()==0) {
            System.out.println("BrowserStack: Please provide a project name.");
            return null;
        }

        if (build.length()==0) {
            System.out.println("BrowserStack: Please provide a build name.");
            return null;
        }

        if (name.length()==0) {
            System.out.println("BrowserStack: Please provide a test name.");
            return null;
        }

        if (appPath.length()==0) {
            System.out.println("BrowserStack: Please provide an app path.");
            return null;
        }

        desiredCapabilities.setCapability(DesiredCapability.PLATFORM_NAME.getValue(), platformName);
        desiredCapabilities.setCapability(DesiredCapability.PLATFORM_VERSION.getValue(), platformVersion);
        desiredCapabilities.setCapability(DesiredCapability.DEVICE_NAME.getValue(), deviceName);
        desiredCapabilities.setCapability(DesiredCapability.PROJECT.getValue(), projectName);
        desiredCapabilities.setCapability(DesiredCapability.BUILD.getValue(), build);
        desiredCapabilities.setCapability(DesiredCapability.NAME.getValue(), name);
        desiredCapabilities.setCapability(DesiredCapability.APP.getValue(), appPath);

        return desiredCapabilities;
    }
}
