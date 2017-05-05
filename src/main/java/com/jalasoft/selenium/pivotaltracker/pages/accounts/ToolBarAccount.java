package com.jalasoft.selenium.pivotaltracker.pages.accounts;

import com.jalasoft.selenium.pivotaltracker.AbstractBasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static com.jalasoft.selenium.pivotaltracker.framework.util.CommonActions.clickWebElement;

/**
 * Class that has the settings for an account.
 */
public class ToolBarAccount extends AbstractBasePage {

    @FindBy(xpath = "//a[contains(.,'Settings')]")
    private WebElement settingTab;

    /**
     * Method that clicks the SETTINGS tab present on the Account.
     *
     * @return the account setting page instance
     */
    public AccountSettings clickSettingTab() {
        clickWebElement(settingTab);
        return new AccountSettings();
    }
}
