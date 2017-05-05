package com.jalasoft.selenium.pivotaltracker.framework.selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Class that represents the firefox we b driver..
 */
public class Firefox implements IDriver {

    private static final String WEB_DRIVER_PATH = "drivers/geckodriver.exe";

    private static final String WEB_DRIVER_KEY = "webdriver.gecko.driver";

    /**
     * {@inheritDoc}
     *
     * @return the Firefox browser
     */
    @Override
    public WebDriver initDriver() {
        System.setProperty(WEB_DRIVER_KEY, WEB_DRIVER_PATH);
        return new FirefoxDriver();
    }
}
