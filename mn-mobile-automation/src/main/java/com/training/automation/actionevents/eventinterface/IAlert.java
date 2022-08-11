package com.training.automation.actionevents.eventinterface;

/**
 * Interface to handle alert related actions.
 *
 * @author Sandib.Nayak
 * @version 1.0
 * @since 28-Dec-2021
 */
public interface IAlert {
    /**
     * This method click on element derived from given locator and return the boolean click status.
     *
     * @param timeoutSeconds time out.
     * @return Return alert text
     * @author thenmozhi.sundaram
     * @since 30-Dec-2021
     */
    public String getAlertText(int timeoutSeconds);

    /**
     * This method is used to switch to the alert and confirm the alert
     *
     * @param timeoutSeconds time out.
     * @return Return alert confirmation status
     * @author subhashini.bollineni
     * @since 31/12/2021
     */
    public boolean confirmAlert(int timeoutSeconds);

}
