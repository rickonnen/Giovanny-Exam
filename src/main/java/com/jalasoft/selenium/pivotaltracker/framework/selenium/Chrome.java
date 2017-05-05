package com.jalasoft.selenium.pivotaltracker.framework.selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Class that represents the Chrome driver to use.
 */
public class Chrome implements IDriver {

    private static final String WEBDRIVER_CHROME_DRIVER = "webdriver.chrome.driver";

    private static final String DRIVER_PATH = "drivers/chromedriver.exe";

    /**
     * {@inheritDoc}
     *
     * @return The Chrome browser
     */
    @Override
    public WebDriver initDriver() {
        System.setProperty(WEBDRIVER_CHROME_DRIVER, DRIVER_PATH);
        return new ChromeDriver();
    }
}
