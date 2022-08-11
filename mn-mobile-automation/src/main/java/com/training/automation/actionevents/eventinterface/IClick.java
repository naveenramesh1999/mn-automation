package com.training.automation.actionevents.eventinterface;

import com.training.automation.enums.LocatorType;

/**
 * This Interface to handle click events.
 *
 * @author Sandib.Nayak
 * @version 1.0
 * @since 28-Dec-2021
 */
public interface IClick {
    /**
     * This method click on element derived from given locator and return the boolean click status.
     *
     * @param locatorType  An enum locator type i.e. "Id","Name","Class","Tag","XPath","CSS".
     * @param locatorValue A String locator value.
     * @return The status of click.
     * @author Sandib.Nayak
     * @since 29-Dec-2021
     */
    public boolean clickElement(LocatorType locatorType, String locatorValue);

    /**
     * This method click on element derived from given xpath and return the boolean click status.
     *
     * @param xPathValue A String locator XPath.
     * @return The status of click.
     * @author Sandib.Nayak
     * @since 29-Dec-2021
     */
    public boolean clickElementByXPath(String xPathValue);
}
