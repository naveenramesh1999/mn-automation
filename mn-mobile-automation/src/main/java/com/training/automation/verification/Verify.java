package com.training.automation.verification;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.testng.Assert;

/**
 * This class contains assertion methods.
 *
 * @author arun.pareek
 */
public class Verify {
    /**
     * This method helps in string assertion of actualText and expectedText
     *
     * @param actualText
     * @param expectedText
     * @return Returns verification status as true when assertion is pass or false otherwise
     */
    public static boolean verifyString(String actualText, String expectedText, String verificationStepMessage, ExtentTest test) {
        test.log(LogStatus.INFO, verificationStepMessage);
        boolean status = false;
        try {
            Assert.assertEquals(actualText, expectedText);
            status = true;
            test.log(LogStatus.PASS,"Actual Result :: " + expectedText + " == " + " Expected Result :: " + actualText);
        } catch (AssertionError assertionError) {
            test.log(LogStatus.FAIL,"Actual Result :: " + expectedText + " == " + " Expected Result :: " + actualText);
        }
        return status;
    }

    /**
     * This method helps in boolean assertion of actual and expected values
     *
     * @param actual
     * @param expected
     * @return Returns verification status as true when assertion is pass or false otherwise
     */
    public static boolean verifyBoolean(boolean actual, boolean expected, String verificationStepMessage, ExtentTest test) {
        test.log(LogStatus.INFO, verificationStepMessage);
        boolean status = false;
        try {
            Assert.assertEquals(actual, expected);
            status = true;
            test.log(LogStatus.PASS,"Actual Result :: " + actual + " == " + " Expected Result :: " + expected);
        } catch (AssertionError assertionError) {
            test.log(LogStatus.PASS,"Actual Result :: " + actual + " == " + " Expected Result :: " + expected);
        }
        return status;
    }

    /**
     * This method helps in integer assertion of actual and expected values
     *
     * @param actual
     * @param expected
     * @return Returns verification status as true when assertion is pass or false otherwise
     */
    public static boolean verifyInteger(int actual, int expected, String verificationStepMessage, ExtentTest test) {
        test.log(LogStatus.INFO, verificationStepMessage);
        boolean status = false;
        try {
            Assert.assertEquals(actual, expected);
            status = true;
            test.log(LogStatus.PASS,"Actual Result :: " + actual + " == " + " Expected Result :: " + expected);
        } catch (AssertionError assertionError) {
            test.log(LogStatus.FAIL,"Actual Result :: " + actual + " == " + " Expected Result :: " + expected);
        }
        return status;
    }
}
