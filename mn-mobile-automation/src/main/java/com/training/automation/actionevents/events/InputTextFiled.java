package com.training.automation.actionevents.events;

import com.training.automation.actionevents.eventinterface.IInputTextField;
import com.training.automation.enums.LocatorType;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

/**
 * This Class contains the methods to handle input text field related events and actions.
 * This Class inherits the Interface IInputTextField
 *
 * @author Sandib.Nayak
 * @version 1.0
 * @since 28-Dec-2021
 */
public class InputTextFiled implements IInputTextField {

    AppiumDriver<MobileElement> driver;

    //Initializing InputTextFiled Class...
    public InputTextFiled(AppiumDriver<MobileElement> driver) {
        this.driver = driver;
    }


    @Override
    public boolean enterText(LocatorType locatorType, String locatorValue, String text) {
        boolean inputTextEntryStatus = false;
        try {
            switch (locatorType) {
                case XPATH:
                    driver.findElementByXPath(locatorValue).sendKeys(text);
                    inputTextEntryStatus = true;
                    break;
                case ID:
                    driver.findElementById(locatorValue).sendKeys(text);
                    inputTextEntryStatus = true;
                    break;
                case NAME:
                    driver.findElementByName(locatorValue).sendKeys(text);
                    inputTextEntryStatus = true;
                    break;
                case CLASS:
                    driver.findElementByClassName(locatorValue).sendKeys(text);
                    inputTextEntryStatus = true;
                    break;
                case TAG:
                    driver.findElementByTagName(locatorValue).sendKeys(text);
                    inputTextEntryStatus = true;
                    break;
                case CSS:
                    driver.findElementByCssSelector(locatorValue).sendKeys(text);
                    inputTextEntryStatus = true;
                    break;
            }
        } catch (Exception exception) {
            System.out.println("Exception Occurred \n" + exception.getMessage());
        }
        return inputTextEntryStatus;
    }

    @Override
    public boolean enterTextByXPath(String xPathValue, String text) {
        boolean inputTextEntryStatus = false;
        try {
            driver.findElementByXPath(xPathValue).sendKeys(text);
            inputTextEntryStatus = true;
        } catch (Exception exception) {
            System.out.println("Exception Occurred \n" + exception.getMessage());
        }
        return inputTextEntryStatus;
    }

    @Override
    public String getTextByXPath(String xPathValue) {
        String inputFieldText = "";
        try {
            inputFieldText = driver.findElementByXPath(xPathValue).getText();
        } catch (Exception exception) {
            System.out.println("Exception Occurred \n" + exception.getMessage());
        }
        return inputFieldText;
    }
}
