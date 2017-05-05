package com.jalasoft.selenium.pivotaltracker.pages.home;

import com.jalasoft.selenium.pivotaltracker.AbstractBasePage;
import com.jalasoft.selenium.pivotaltracker.api.RequestManager;
import com.jalasoft.selenium.pivotaltracker.framework.util.CommonActions;
import com.jalasoft.selenium.pivotaltracker.pages.accounts.Accounts;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

import static com.jalasoft.selenium.pivotaltracker.framework.util.CommonActions.clickWebElement;

/**
 * Class that represents the Dashboard page
 * where the account button is present.
 */
public class Home extends AbstractBasePage {

    @FindBy(css = ".undefined.tc_profile_dropdown div a")
    @CacheLookup
    private WebElement userProfileName;

    @FindBy(css = ".button.button--action")
    @CacheLookup
    private WebElement createProjectBtn;

    @FindBy(css = "#notice")
    @CacheLookup
    private WebElement notificationModalMessage;

    @FindBy(css = "a[href='/accounts]'")
    @CacheLookup
    private WebElement accountsOption;

    /**
     * getTextProfileName.
     * @return an string of profile name
     */
    public String getTextProfileName() {
        return CommonActions.getElementText(userProfileName);
    }

    /**
     * Method that clicks the accounts button.
     * @return a NewProjectForm Page Object
     */
    public Accounts clickAccountsButton() {
        clickWebElement(userProfileName);
        clickWebElement(accountsOption);
        return new Accounts();
    }

    /**
     * Method that retrieves the user name.
     *
     * @param value the email of the user
     * @return the user name obtained
     */
    public String getUserName(String value) {

        final String endPointProfile = "/me";
        final String fieldEmail = "email";
        final String fieldUserName = "username";
        final String email = RequestManager.get(endPointProfile).jsonPath().get(fieldEmail);
        if (value.equalsIgnoreCase(email)) {
            return RequestManager.get(endPointProfile).jsonPath().get(fieldUserName);
        }
        return value;
    }
}
