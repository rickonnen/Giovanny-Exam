package com.jalasoft.selenium.pivotaltracker;

import com.jalasoft.selenium.pivotaltracker.framework.util.PropertiesInfo;
import com.jalasoft.selenium.pivotaltracker.pages.home.Home;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static com.jalasoft.selenium.pivotaltracker.framework.util.CommonActions.clickWebElement;
import static com.jalasoft.selenium.pivotaltracker.framework.util.PropertiesInfo.getInstance;
import static com.jalasoft.selenium.pivotaltracker.framework.util.CommonActions.setWebElement;
import static com.jalasoft.selenium.pivotaltracker.framework.util.PageTransporter.goToURL;
import static com.jalasoft.selenium.pivotaltracker.framework.util.Constants.HOME_PAGE;

/**
 * Login to the user entered.
 */
public class Login extends AbstractBasePage {

    private static final PropertiesInfo PROPERTIES_INFO = getInstance();

    @FindBy(id = "credentials_username")
    private WebElement userNameTestField;

    @FindBy(id = "credentials_password")
    private WebElement passwordTestField;

    @FindBy(css = ".app_signin_action_button")
    private WebElement signInBtn;

    /**
     * Method that writes the username parameter
     * into the name component.
     *
     * @param username the entry to be used as username
     */
    public void setUserNameTestField(String username) {
        setWebElement(userNameTestField, username);
    }

    /**
     * Method that writes the password parameter
     * into the password component.
     *
     * @param password the entry to be used as password
     */
    public void setPasswordTestField(String password) {
        setWebElement(passwordTestField, password);
    }

    /**
     * Method that checks a series of validations to verify
     * that the login with given parameters has been accomplished.
     *
     * @param userName the username used to validate the logged account
     * @param password the password used to validate the logged account
     * @return the home user page instance of Pivotal Tracker
     */
    public static Home loginAs(String userName, String password) {
        Home home = new Home();
        if (!home.getTextProfileName().equalsIgnoreCase(home.getUserName(userName))) {
            PivotalHome pivotalHome = new PivotalHome();
            Login login = pivotalHome.clickSingInLink();
            login.setUserNameTestField(userName);
            login.clickSignInButton();
            login.setPasswordTestField(password);
            return login.clickSignInButton();
        } else {
            goToURL(HOME_PAGE);
        }
        return home;
    }

    /**
     * Method that click the sign in button.
     *
     * @return the Dashboard instance needed on Pivotal's
     * main user page.
     */
    public Home clickSignInButton() {
        clickWebElement(signInBtn);
        return new Home();
    }

    /**
     * Method that uses the loginAs method to log in
     * as a primary user.
     *
     * @return the dashboard given the email and the password
     */
    public static Home loginAsPrimaryUser() {
        return loginAs(PROPERTIES_INFO.getEmail(),
                PROPERTIES_INFO.getPassword());
    }
}
