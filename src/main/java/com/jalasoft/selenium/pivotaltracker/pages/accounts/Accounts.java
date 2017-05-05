package com.jalasoft.selenium.pivotaltracker.pages.accounts;

import com.jalasoft.selenium.pivotaltracker.AbstractBasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.util.concurrent.TimeUnit;

import static com.jalasoft.selenium.pivotaltracker.framework.util.CommonActions.clickWebElement;
import static com.jalasoft.selenium.pivotaltracker.framework.util.Constants.IMPLICIT_FAIL_WAIT_TIME;
import static com.jalasoft.selenium.pivotaltracker.framework.util.Constants.IMPLICIT_WAIT_TIME;

/**
 * Class for accounts page and its elements.
 */
public class Accounts extends AbstractBasePage {

    private final ToolBarAccount toolBarAccount;

    @FindBy(id = "notice")
    private WebElement deleteAccountMessage;

    @FindBy(xpath = "//a[contains(.,'Manage Account')]")
    private WebElement manageAccountBtn;

    @FindBy(className = "[class='create_account_button']")
    private WebElement createAccountButton;

    @FindBy(css = "[href='/accounts']")
    private WebElement accountBtn;

    private static final int POLLING = 5;

    /**
     * Class constructor,
     * This class instances a ToolBarAccount.
     */
    public Accounts() {
        toolBarAccount = new ToolBarAccount();
    }

    /**
     * method that clicks the manage account button.
     *
     * @return toolbar instance
     */
    public ToolBarAccount manageAccount() {
        clickWebElement(manageAccountBtn);
        return new ToolBarAccount();
    }

    /**
     * This method is used to catch the message that is displayed after deleting an
     * account.
     *
     * @return the message of deleting an account.
     */
    public String getDeleteAccountMessage() {
        return deleteAccountMessage.getText();
    }

    /**
     * This method clicks the new account button displayed on the page.
     *
     * @return {@link CreateAccountForm}
     */
    public CreateAccountForm clickNewAccountBtn() {
        clickWebElement(createAccountButton);
        return new CreateAccountForm();
    }

    /**
     * it returns the web element that represents
     * the manage accounts button.
     *
     * @return the web element from the instance
     */
    public WebElement getManageAccountBtn() {
        return manageAccountBtn;
    }

    /**
     * method that returns the account name.
     *
     * @param accountName the account to be reviewed.
     * @return the string with account name
     */
    public String getAnAccountName(String accountName) {
        String result = "";
        driver.manage().timeouts().implicitlyWait(IMPLICIT_FAIL_WAIT_TIME, TimeUnit.SECONDS);
        WebElement accNameRes = fluentWait(By.xpath("//h3/div/div[contains(.,'" + accountName.toLowerCase() + "')]"));
        String nameAsText = accNameRes.getText();
        if (!nameAsText.isEmpty()) {
            return nameAsText;
        } else {
            return result;
        }
    }

    /**
     * Method that specifies the fluent wait.
     *
     * @param locator value to play with the explicit timeout
     * @return the web element object
     */
    public WebElement fluentWait(final By locator) {
        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                .withTimeout(IMPLICIT_WAIT_TIME, TimeUnit.SECONDS)
                .pollingEvery(POLLING, TimeUnit.SECONDS)
                .ignoring(org.openqa.selenium.NoSuchElementException.class);
        return wait.until(driver1 -> driver1.findElement(locator));
    }

    /**
     * It gives us the tool bar account that is present on the instance.
     *
     * @return the tool bar account instance
     */
    public ToolBarAccount getToolBarAccount() {
        return toolBarAccount;
    }

    /**
     * Method that clicks the accounts button.
     * @return the account instance
     */
    public Accounts clickAccountsButton() {
        clickWebElement(accountBtn);
        return this;
    }
}
