package com.training.automation.actionevents.events;

import com.training.automation.actionevents.eventinterface.ILabel;
import com.training.automation.enums.LocatorType;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * This Class contains the methods to handle application UI label text related events.
 * This Class inherits the Interface Label
 *
 * @author Sandib.Nayak
 * @version 1.0
 * @since 29-Dec-2021
 */
public class Label implements ILabel {

    AppiumDriver<MobileElement> driver;

    //Initializing Label Class...
    public Label(AppiumDriver<MobileElement> driver) {
        this.driver = driver;
    }


    @Override
    public String getText(LocatorType locatorType, String locatorValue) {
        String labelText = null;
        try {
            switch (locatorType) {
                case XPATH:
                    labelText = driver.findElementByXPath(locatorValue).getText();
                    break;
                case ID:
                    labelText = driver.findElementById(locatorValue).getText();
                    break;
                case NAME:
                    labelText = driver.findElementByName(locatorValue).getText();
                    break;
                case CLASS:
                    labelText = driver.findElementByClassName(locatorValue).getText();
                    break;
                case TAG:
                    labelText = driver.findElementByTagName(locatorValue).getText();
                    break;
                case CSS:
                    labelText = driver.findElementByCssSelector(locatorValue).getText();
                    break;
            }
        } catch (Exception exception) {
            System.out.println("Exception Occurred \n" + exception.getMessage());
        }
        return labelText;
    }

    @Override
    public String waitAndGetTextByXPath(String xPathValue, int timeout) {
        String labelText = null;
        WebDriverWait wait;
        try {
            wait = new WebDriverWait(driver, timeout);
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xPathValue)));
            labelText = driver.findElementByXPath(xPathValue).getText();
        } catch (Exception exception) {
            System.out.println("Exception Occurred \n" + exception.getMessage());
        }
        return labelText;
    }

    @Override
    public boolean isElementDisplayed(LocatorType locatorType, String locatorValue, int timeout) {
        boolean elementStatus = false;
        WebDriverWait wait;
        try {
            switch (locatorType) {
                case XPATH:
                    wait = new WebDriverWait(driver, timeout);
                    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locatorValue)));
                    elementStatus = driver.findElementByXPath(locatorValue).isDisplayed();
                    break;
                case ID:
                    wait = new WebDriverWait(driver, timeout);
                    wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(locatorValue)));
                    elementStatus = driver.findElementById(locatorValue).isDisplayed();
                    break;
                case NAME:
                    wait = new WebDriverWait(driver, timeout);
                    wait.until(ExpectedConditions.visibilityOfElementLocated(By.name(locatorValue)));
                    elementStatus = driver.findElementByName(locatorValue).isDisplayed();
                    break;
                case CLASS:
                    wait = new WebDriverWait(driver, timeout);
                    wait.until(ExpectedConditions.visibilityOfElementLocated(By.className(locatorValue)));
                    elementStatus = driver.findElementByClassName(locatorValue).isDisplayed();
                    break;
                case TAG:
                    wait = new WebDriverWait(driver, timeout);
                    wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName(locatorValue)));
                    elementStatus = driver.findElementByTagName(locatorValue).isDisplayed();
                    break;
                case CSS:
                    wait = new WebDriverWait(driver, timeout);
                    wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(locatorValue)));
                    elementStatus = driver.findElementByCssSelector(locatorValue).isDisplayed();
                    break;
            }
        } catch (Exception exception) {
            System.out.println("Exception Occurred \n" + exception.getMessage());
        }
        return elementStatus;
    }
}
