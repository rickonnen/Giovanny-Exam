package com.jalasoft.selenium.pivotaltracker.framework.selenium;

import org.openqa.selenium.WebDriver;

/**
 * Interface for factory pattern.
 */
public interface IDriver {

    /**
     * Initializes the driver.
     *
     * @return the driver instance.
     */
    WebDriver initDriver();
}
