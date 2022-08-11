package com.training.automation.actionevents.events;

import com.training.automation.actionevents.eventinterface.IWaitElement;
import com.training.automation.enums.LocatorType;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * This Class contains the methods to explicitly wait for mobile elements.
 * This Class inherits the Interface IAlert
 *
 * @author Thenmozhi.Sundaram
 * @version 1.0
 * @since 28-Dec-2021
 */
public class WaitElement implements IWaitElement {
    AppiumDriver<MobileElement> driver;
    //Initializing WaitElement Class...
    public WaitElement(AppiumDriver<MobileElement> driver) {
        this.driver = driver;
    }
    /**
     * This method is used to implement the explicit wait to wait for element in the given timeout.
     *
     * @author thenmozhi.sundaram
     * Date 31-Dec-2021
     */
    @Override
    public void waitForElement(LocatorType locatorType, String locatorValue, int timeout) {
        WebDriverWait wait;
        try {
            switch (locatorType) {
                case XPATH:
                    wait = new WebDriverWait(driver, 20);
                    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locatorValue)));
                    break;
                case ID:
                    wait = new WebDriverWait(driver, 20);
                    wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(locatorValue)));
                    break;
                case NAME:
                    wait = new WebDriverWait(driver, 20);
                    wait.until(ExpectedConditions.visibilityOfElementLocated(By.name(locatorValue)));
                    break;
                case CLASS:
                    wait = new WebDriverWait(driver, 20);
                    wait.until(ExpectedConditions.visibilityOfElementLocated(By.className(locatorValue)));
                    break;
                case TAG:
                    wait = new WebDriverWait(driver, 20);
                    wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName(locatorValue)));
                    break;
                case CSS:
                    wait = new WebDriverWait(driver, 20);
                    wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(locatorValue)));
                    break;
            }
        } catch (Exception exception) {
            System.out.println("Exception Occurred \n" + exception.getMessage());
        }
    }
}
