package com.jalasoft.selenium.pivotaltracker.framework.selenium;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriverException;

/**
 * Class for driver factory pattern.
 */
public final class DriverFactory {

    private static final String BROWSER_NOT_FOUND_MSG = "Browser not found.";

    /**
     * Class constructor.
     */
    private DriverFactory() {
    }

    /**
     * Map of browser options.
     */
    private static final Map<String, IDriver> BROWSERS = new HashMap<>();
    static {
        BROWSERS.put("chrome", new Chrome());
        BROWSERS.put("firefox", new Firefox());
    }

    /**
     * method that returns the browser selected.
     *
     * @param browser the browser selected
     * @return the proper instance
     */
    public static IDriver getDriver(String browser) {
        IDriver driver = BROWSERS.get(browser);
        if (driver == null) {
            throw new WebDriverException(BROWSER_NOT_FOUND_MSG);
        }
        return driver;
    }
}
