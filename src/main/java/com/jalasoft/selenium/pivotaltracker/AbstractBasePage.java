package com.jalasoft.selenium.pivotaltracker;

import com.jalasoft.selenium.pivotaltracker.framework.selenium.DriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import static com.jalasoft.selenium.pivotaltracker.framework.util.Constants.WAIT_TIME;

/**
 * Abstract class that represents a template
 * for the rest of pages that will be invoked
 * on the Test.
 */
public abstract class AbstractBasePage {

    protected WebDriver driver;

    protected WebDriverWait wait;

    /**
     * AbstractBasePage class constructor.
     */
    public AbstractBasePage() {
        driver = DriverManager.getInstance().getDriver();
        wait = new WebDriverWait(driver, WAIT_TIME);
        PageFactory.initElements(driver, this);
    }

    /**
     * Methods that refreshes the page where we are.
     */
    public void refreshPage() {
        driver.navigate().refresh();
    }
}
