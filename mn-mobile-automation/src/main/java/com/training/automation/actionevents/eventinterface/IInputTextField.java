package com.training.automation.actionevents.eventinterface;

import com.training.automation.enums.LocatorType;

/**
 * This Interface to handle input text field related events and actions
 *
 * @author Sandib.Nayak
 * @version 1.0
 * @since 28-Dec-2021
 */
public interface IInputTextField {
    /**
     * This method enter the input text on field and return the boolean data input status.
     *
     * @param locatorType  An enum locator type i.e. "Id","Name","Class","Tag","XPath","CSS".
     * @param locatorValue A String locator value.
     * @param text         A String text to be entered in input filed.
     * @return The status of data input.
     * @author Sandib.Nayak
     * @since 29-Dec-2021
     */
    public boolean enterText(LocatorType locatorType, String locatorValue, String text);

    /**
     * This method enter the input text on field and return the boolean data input status.
     *
     * @param xPathValue A String locator XPath.
     * @param text       A String text to be entered in input filed.
     * @return The status of data input.
     * @author Sandib.Nayak
     * @since 29-Dec-2021
     */
    public boolean enterTextByXPath(String xPathValue, String text);

    /**
     * This method get the text in the input text field and return the text as String
     *
     * @param xPathValue A String locator XPath.
     * @return The Text in the input text field.
     * @author Subhashini.Bollineni
     * @since 29-Dec-2021
     */
    public String getTextByXPath(String xPathValue);


}
