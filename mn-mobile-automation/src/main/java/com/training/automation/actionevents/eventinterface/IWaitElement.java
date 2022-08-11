package com.training.automation.actionevents.eventinterface;

import com.training.automation.enums.LocatorType;

public interface IWaitElement {
    /**
     * This method is to check whether the element is available or not.
     *
     * @param locatorType  An enum locator type i.e. "Id","Name","Class","Tag","XPath","CSS".
     * @param locatorValue A String locator value.
     * @return The availability of element.
     * @author thenmozhi.sundaram
     * @since 30-Dec-2021
     */
    public void waitForElement(LocatorType locatorType, String locatorValue, int timeout);


}
