package com.training.automation.enums;

/**
 * This is enumeration class provide mobile device platform
 *
 * @author arun.pareek
 */
public enum DevicePlatform {
    IOS("ios"), ANDROID("android");

    private final String devicePlatform;

    DevicePlatform(String devicePlatform) {
        this.devicePlatform = devicePlatform;
    }

    /**
     * This method returns string value for device platform
     *
     * @return Device Platform
     */
    public String getValue() {
        return this.devicePlatform;
    }
}
