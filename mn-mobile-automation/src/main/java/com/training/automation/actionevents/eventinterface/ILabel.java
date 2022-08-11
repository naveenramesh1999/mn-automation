package com.training.automation.actionevents.eventinterface;

import com.training.automation.enums.LocatorType;

/**
 * This Interface to handle application UI label text related events.
 *
 * @author Sandib.Nayak
 * @version 1.0
 * @since 29-Dec-2021
 */
public interface ILabel {
    /**
     * This method get the text of given label and return the String text.
     *
     * @param locatorType  An enum locator type i.e. "Id","Name","Class","Tag","XPath","CSS".
     * @param locatorValue A String locator value.
     * @return The String text of data input.
     * @author Sandib.Nayak
     * @since 29-Dec-2021
     */
    public String getText(LocatorType locatorType, String locatorValue);

    /**
     * This method wait for the element and get the text of given label and return the String text.
     *
     * @param xPathValue A String locator XPath.
     * @param timeout Timeout to wait explicitly.
     * @return The status of data input.
     * @author Sandib.Nayak
     * @since 29-Dec-2021
     */
    public String waitAndGetTextByXPath(String xPathValue, int timeout);

    /**
     * This method is to check whether the element is available or not.
     *
     * @param locatorType  An enum locator type i.e. "Id","Name","Class","Tag","XPath","CSS".
     * @param locatorValue A String locator value.
     * @return The availability of element.
     * @author thenmozhi.sundaram
     * @since 30-Dec-2021
     */
    public boolean isElementDisplayed(LocatorType locatorType, String locatorValue, int timeout);

}
