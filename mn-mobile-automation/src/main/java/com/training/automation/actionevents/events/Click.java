package com.training.automation.actionevents.events;

import com.training.automation.actionevents.eventinterface.IClick;
import com.training.automation.enums.LocatorType;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;


/**
 * This Class contains the methods to handle click events.
 * This Class inherits the Interface IClick
 *
 * @author Sandib.Nayak
 * @version 1.0
 * @since 28-Dec-2021
 */
public class Click implements IClick {

    AppiumDriver<MobileElement> driver;

    //Initializing Click Class...
    public Click(AppiumDriver<MobileElement> driver) {
        this.driver = driver;
    }


    @Override
    public boolean clickElement(LocatorType locatorType, String locatorValue) {
        boolean clickStatus = false;
        try {
            switch (locatorType) {
                case XPATH:
                    driver.findElementByXPath(locatorValue).click();
                    clickStatus = true;
                    break;
                case ID:
                    driver.findElementById(locatorValue).click();
                    clickStatus = true;
                    break;
                case NAME:
                    driver.findElementByName(locatorValue).click();
                    clickStatus = true;
                    break;
                case CLASS:
                    driver.findElementByClassName(locatorValue).click();
                    clickStatus = true;
                    break;
                case TAG:
                    driver.findElementByTagName(locatorValue).click();
                    clickStatus = true;
                    break;
                case CSS:
                    driver.findElementByCssSelector(locatorValue).click();
                    clickStatus = true;
                    break;
            }
        } catch (Exception exception) {
            System.out.println("Exception Occurred \n" + exception.getMessage());
        }
        return clickStatus;
    }


    @Override
    public boolean clickElementByXPath(String xPathValue) {
        boolean clickStatus = false;
        try {
            driver.findElementByXPath(xPathValue).click();
            clickStatus = true;
        } catch (Exception exception) {
            System.out.println("Exception Occurred \n" + exception.getMessage());
        }
        return clickStatus;
    }


}
