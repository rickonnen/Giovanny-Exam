package com.jalasoft.selenium.pivotaltracker;

import com.jalasoft.selenium.pivotaltracker.framework.util.PropertiesInfo;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static com.jalasoft.selenium.pivotaltracker.framework.util.CommonActions.clickWebElement;

/**
 * Pivotal tracker home page.
 */
public class PivotalHome extends AbstractBasePage {

    @FindBy(css = ".header__lg a[href*='signin']")
    private WebElement signInLink;

    /**
     * Class constructor.
     */
    public PivotalHome() {
        driver.get(PropertiesInfo.getInstance().getUrl());
    }

    /**
     * Method that clicks the sign in button
     * and creates a new Login instance.
     *
     * @return the Login page instance
     */
    public Login clickSingInLink() {
        clickWebElement(signInLink);
        return new Login();
    }
}
