package com.jalasoft.selenium.pivotaltracker.framework.selenium;

import java.util.concurrent.TimeUnit;

import com.jalasoft.selenium.pivotaltracker.framework.util.PropertiesInfo;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import static com.jalasoft.selenium.pivotaltracker.framework.util.Constants.IMPLICIT_WAIT_TIME;
import static com.jalasoft.selenium.pivotaltracker.framework.util.Constants.LOAD_PAGE_TIME;
import static com.jalasoft.selenium.pivotaltracker.framework.util.Constants.WAIT_TIME;


/**
 * DriverManager Singleton class that manages
 * the Selenium driver and initialize the
 * main resources.
 */
public final class DriverManager {

    private static DriverManager instance;

    private WebDriver driver;

    private WebDriverWait wait;

    /**
     * DriverManager class constructor.
     */
    private DriverManager() {
        initWebDriver();
    }

    /**
     * getInstance.
     * @return a DriverManager Object
     */
    public static DriverManager getInstance() {
        if (instance == null) {
            instance = new DriverManager();
        }
        return instance;
    }

    /**
     * method that initialize the driver manager.
     */
    private void initWebDriver() {
        driver = DriverFactory.getDriver(PropertiesInfo.getInstance().getBrowser().toUpperCase()).initDriver();
        driver.manage().timeouts().implicitlyWait(IMPLICIT_WAIT_TIME, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(LOAD_PAGE_TIME, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, WAIT_TIME);
    }

    /**
     * getDriver.
     * @return a WebDriver Object
     */
    public WebDriver getDriver() {
        return driver;
    }

    /**
     * getWait.
     * @return a WebDriverWait Object
     */
    public WebDriverWait getWait() {
        return wait;
    }
}
