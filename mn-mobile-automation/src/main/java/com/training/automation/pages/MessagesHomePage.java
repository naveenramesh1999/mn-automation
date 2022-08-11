package com.training.automation.pages;

import com.training.automation.constants.FilePathConstants;
import com.training.automation.message.ErrorMessages;
import com.training.automation.page.keys.MessagesHomePageKey;
import com.training.automation.utils.PropertyParser;
import com.training.automation.testscripts.MessagesHomeTest;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.NoSuchElementException;

/**
 * This class contains supported methods for executing test methods
 * of @{@link MessagesHomeTest} class.
 *
 * @author arun.pareek
 */
public class MessagesHomePage {
    PropertyParser propertyParser;

    public MessagesHomePage() {
        propertyParser = new PropertyParser(FilePathConstants.MESSAGES_LOCATOR_FILE_PATH);
    }

    /**
     * This method is used to click Start New Conversation button
     * in Messages home page screen
     */
    public boolean clickStartConversationButton(AppiumDriver<MobileElement> driver) {
        boolean clickStatus = false;
        String startConversationButtonXPath = propertyParser.getPropertyValue(MessagesHomePageKey.START_NEW_CONVERSATION_BUTTON_IMAGEVIEW_KEY);
        if (startConversationButtonXPath.length() != 0) {
            try {
                MobileElement startConversationButton = driver.findElementByXPath(startConversationButtonXPath);
                startConversationButton.click();
                clickStatus = true;
            } catch (NoSuchElementException noSuchElementException) {
                System.out.println(noSuchElementException.getLocalizedMessage());
            }
        } else {
            System.out.println(ErrorMessages.MISSING_CONVERSATION_BUTTON_XPATH_MESSAGE);
        }

        return clickStatus;
    }
}
