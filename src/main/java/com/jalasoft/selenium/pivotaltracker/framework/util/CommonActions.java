package com.jalasoft.selenium.pivotaltracker.framework.util;

import com.jalasoft.selenium.pivotaltracker.framework.selenium.DriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.By;

import static com.jalasoft.selenium.pivotaltracker.framework.selenium.DriverManager.getInstance;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * CommonActions.
 */
public final class CommonActions {

    private static final WebDriverWait WEB_DRIVER_WAIT = getInstance().getWait();

    private static final WebDriver WEB_DRIVER = getInstance().getDriver();

    /**
     * Class constructor.
     */
    private CommonActions() {
    }

    /**
     * This Method return false o true if the element is present.
     *
     * @param webElement the web element to be verified
     * @return true or false
     */
    public static boolean isElementPresent(WebElement webElement) {
        try {
            webElement.getTagName();
            return true;
        } catch (WebDriverException e) {
            System.out.println("Web element not found" + e);
            return false;

        }
    }

    /**
     * This method sets the Web Element.
     *
     * @param webElement the object to be catched and the replaced
     * @param text the value that will be filled on the web element
     */
    public static void setWebElement(WebElement webElement, String text) {
        WEB_DRIVER_WAIT.until(ExpectedConditions.visibilityOf(webElement));
        webElement.clear();
        webElement.sendKeys(text);
    }

    /**
     * This Method do clicks the web element.
     *
     * @param webElement the object to be clicked.
     */
    public static void clickWebElement(WebElement webElement) {
        WEB_DRIVER_WAIT.until(ExpectedConditions.elementToBeClickable(webElement));
        webElement.click();
    }

    /**
     * This Method do clicks the by element.
     *
     * @param byElement the object to be clicked.
     */
    public static void clickWebElement(By byElement) {
        WEB_DRIVER_WAIT.until(ExpectedConditions.elementToBeClickable(byElement));
        WEB_DRIVER.findElement(byElement).click();
    }

    /**
     * getElementText.
     * @param webElement a general webelement
     * @return an string of webelement.
     */
    public static String getElementText(final WebElement webElement) {
        WEB_DRIVER_WAIT.until(ExpectedConditions.visibilityOf(webElement));
        return webElement.getText();
    }

    /**
     *scrollIntoViewWebElement.
     * @param webElement that requires to scroll to be visible.
     */
    public static void scrollIntoViewWebElement(final WebElement webElement) {
        final String textScript = "arguments[0].scrollIntoView(true);";
        ((JavascriptExecutor) DriverManager.getInstance().getDriver())
                .executeScript(textScript, webElement);
    }
}
