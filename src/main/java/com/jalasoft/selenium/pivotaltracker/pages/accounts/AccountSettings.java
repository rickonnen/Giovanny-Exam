package com.jalasoft.selenium.pivotaltracker.pages.accounts;

import com.jalasoft.selenium.pivotaltracker.AbstractBasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static com.jalasoft.selenium.pivotaltracker.framework.util.CommonActions.clickWebElement;

/**
 * Class that has the account settings and its elements.
 */
public class AccountSettings extends AbstractBasePage {

    @FindBy(css = "a[data-method='delete']")
    private WebElement deleteAccountLink;

    @FindBy(css = ".account_name>span")
    private WebElement accountName;

    @FindBy(xpath = "//h4[text()='ID']/following-sibling::div")
    private WebElement accountID;

    /**
     * Method that deletes the account where the settings is present.
     *
     * @return The Accounts page once we remove the account on Settings tab
     */
    public Accounts deleteAccount() {
        clickWebElement(deleteAccountLink);
        wait.until(ExpectedConditions.alertIsPresent()).accept();
        return new Accounts();
    }

    /**
     * This method gets the account ID from the Account instance.
     *
     * @return the account ID
     */
    public String getAccountID() {
        return accountID.getText();
    }

    /**
     * This method gets the account name from the Account instance.
     *
     * @return the account name
     */
    public String getAccountName() {
        return accountName.getText();
    }
}
