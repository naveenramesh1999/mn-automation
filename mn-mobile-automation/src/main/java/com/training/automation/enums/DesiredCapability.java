package com.training.automation.enums;

/**
 * This is enumeration class provide desired capabilities keys
 *
 * @author arun.pareek
 */
public enum DesiredCapability {

    PLATFORM_NAME("platformName"),
    DEVICE_NAME("deviceName"),
    PLATFORM_VERSION("platformVersion"),
    APP("app"),
    APP_PACKAGE("appPackage"),
    APP_ACTIVITY("appActivity"),
    BUNDLE_ID("bundleId"),
    UDID("udid"),
    PROJECT("project"),
    BUILD("build"),
    NAME("name");

    private final String desiredCapability;

    DesiredCapability(String desiredCapability) {
        this.desiredCapability = desiredCapability;
    }

    /**
     * This method returns string value for desired capability key
     *
     * @return Desired Capability Key
     */
    public String getValue() {
        return this.desiredCapability;
    }

}
