package com.training.automation.actionevents.events;

import com.training.automation.actionevents.eventinterface.IAlert;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * This Class contains the methods to handle alert actions.
 * This Class inherits the Interface IAlert
 *
 * @author Sandib.Nayak
 * @version 1.0
 * @since 28-Dec-2021
 */
public class Alert implements IAlert {

    AppiumDriver<MobileElement> driver;

    //Initializing Alert Class...
    public Alert(AppiumDriver<MobileElement> driver) {
        this.driver = driver;
    }

    /**
     * This method is used to verify if alert is present within specified time seconds
     */
    public boolean isAlertPresent(int timeoutSeconds) {
        boolean isAlertPresent = false;
        try {
            new WebDriverWait(driver, timeoutSeconds).until(ExpectedConditions.alertIsPresent());
            isAlertPresent = true;
        } catch (NoAlertPresentException noAlertPresentException) {
            System.out.println("Exception Occurred \n" + noAlertPresentException.getMessage());
        } catch (TimeoutException timeoutException) {
            System.out.println("Exception Occurred \n" + timeoutException.getMessage());
        }
        return isAlertPresent;
    }

    /**
     * This method is used to verify if alert text within specified time seconds
     */
    @Override
    public String getAlertText(int timeoutSeconds) {

        String alertText = null;
        try {
            if (isAlertPresent(timeoutSeconds)) {
                driver.switchTo().alert();
                alertText = driver.switchTo().alert().getText();
                driver.switchTo().alert().accept();
            } else {
                System.out.println("Alert is not present.");
            }
        } catch (NoAlertPresentException noAlertPresentException) {
            System.out.println("Exception Occurred \n" + noAlertPresentException.getMessage());
        } catch (TimeoutException timeoutException) {
            System.out.println("Exception Occurred \n" + timeoutException.getMessage());
        }
        return alertText;
    }

    /**
     * This method is used to switch to the alert and confirm the alert
     */
    @Override
    public boolean confirmAlert(int timeoutSeconds) {
        boolean confirmAlertStatus = false;
        try {
            if (isAlertPresent(timeoutSeconds)) {
                driver.switchTo().alert().accept();
                confirmAlertStatus = true;
            } else {
                System.out.println("Alert is not present");
            }
        } catch (NoAlertPresentException noAlertPresentException) {
            System.out.println(noAlertPresentException.getLocalizedMessage());
        }
        return confirmAlertStatus;
    }
}
