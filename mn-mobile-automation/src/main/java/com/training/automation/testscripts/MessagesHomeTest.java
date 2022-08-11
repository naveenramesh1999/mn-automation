package com.training.automation.testscripts;

import com.relevantcodes.extentreports.LogStatus;
import com.training.automation.base.MobileTestBase;
import com.training.automation.message.InfoMessages;
import com.training.automation.message.VerifyMessages;
import com.training.automation.pages.MessagesHomePage;
import com.training.automation.verification.Verify;
import org.testng.annotations.Test;

/**
 * This class contains test methods for executing automation scripts
 * for the home page screen of the Messages application.
 *
 * @author arun.pareek
 */
public class MessagesHomeTest extends MobileTestBase {

    MessagesHomePage messagesHomePage = new MessagesHomePage();

    @Test
    public void sampleTestMethod() {
        String actualText = "Message";
        String expectedText = "Message";

        Verify.verifyString(actualText, expectedText, VerifyMessages.VERIFY_SAMPLE_TEXT_MESSAGE, test);
    }

    @Test
    public void verifyMessagesAppHomePage() {
        test.log(LogStatus.INFO, InfoMessages.MESSAGES_APP_HOMEPAGE_TEST_START_MESSAGE);
        
        boolean startConversationButtonStatus = messagesHomePage.clickStartConversationButton(driver);
        Verify.verifyBoolean(startConversationButtonStatus, true, VerifyMessages.VERIFY_CONVERSATION_BUTTON_MESSAGE, test);
    }
}
