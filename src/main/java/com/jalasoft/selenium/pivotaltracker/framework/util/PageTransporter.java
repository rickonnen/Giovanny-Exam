package com.jalasoft.selenium.pivotaltracker.framework.util;

import com.jalasoft.selenium.pivotaltracker.framework.selenium.DriverManager;

/**
 * Class that represents the URL to gather used on Login.
 */
public final class PageTransporter {

    private static String baseUrl = PropertiesInfo.getInstance().getUrl();

    /**
     * PageTransporter constructor.
     */
    private PageTransporter() {
    }

    /**
     * Method to go to an specific page through the url.
     * @param endPoint End point.
     */
    public static void goToURL(String endPoint) {
        String url = String.format("%s%s", baseUrl, endPoint);
        DriverManager.getInstance().getDriver().navigate().to(url);
    }
}
