package com.jalasoft.selenium.pivotaltracker.pages.accounts;

import com.jalasoft.selenium.pivotaltracker.AbstractBasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static com.jalasoft.selenium.pivotaltracker.framework.util.CommonActions.setWebElement;

/**
 * Created by xianqe on 5/5/2017.
 */
public class CreateAccountForm extends AbstractBasePage {

    @FindBy(id = "account_name")
    private WebElement accountNameTextField;

    @FindBy(id = "add_account_button")
    private WebElement createNewAccountBtn;

    @FindBy(className = "close_popup")
    private WebElement cancelCreateAccountButton;

    /**
     * Method that puts the account name
     * on the text field web element.
     *
     * @param accountName the account name to be inserted
     */
    public void setAccountNameTextField(String accountName) {
        setWebElement(accountNameTextField, accountName);
    }

    /**
     * Method that clicks the create account button
     * and then goes to the Accounts page.
     *
     * @return the Accounts page instance
     */
    public Accounts clickCreateAccountBtn() {
        createNewAccountBtn.click();
        return new Accounts();
    }

    /**
     * Method that clicks the X to cancel the form to
     * create a new account.
     *
     * @return the account instance
     */
    public Accounts clickCancelCreateButton() {
        cancelCreateAccountButton.click();
        return new Accounts();
    }
}
