package com.jalasoft.selenium.pivotaltracker;

import com.jalasoft.selenium.pivotaltracker.pages.accounts.AccountSettings;
import com.jalasoft.selenium.pivotaltracker.pages.accounts.Accounts;
import com.jalasoft.selenium.pivotaltracker.pages.accounts.CreateAccountForm;
import com.jalasoft.selenium.pivotaltracker.pages.home.Home;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

/**
 * Test exam.
 */
public class TestAccountsExam {

    private static final String ACCOUNT_NAME = "AccountExam";

    private Home home;

    /**
     * Before method.
     */
    @BeforeMethod (groups = {"exam"})
    public void setUp() {
        // Given
        home = Login.loginAsPrimaryUser();
    }

    /**
     * testAccountPivotal.
     */
    @Test (groups = {"exam"})
    public void testAccountPivotal() {
        // When
        Accounts account = home.clickAccountsButton();
        CreateAccountForm createAccountForm = account.clickNewAccountBtn();
        createAccountForm.setAccountNameTextField(ACCOUNT_NAME);
        AccountSettings accountSettings = account.getToolBarAccount().clickSettingTab();
        String actualAccountname = accountSettings.getAccountName();

        //Then verify account has been created
        String expectedAccountName = "AccountExam";
        assertEquals(actualAccountname.toLowerCase(), expectedAccountName.toLowerCase());

        account = account.clickAccountsButton();

        // Then verify the account is displayed inside Accounts page
        String actualAccountName = "AccountExam";
        assertEquals(actualAccountName.toLowerCase(), account.getAnAccountName(ACCOUNT_NAME));

        accountSettings = account.getToolBarAccount().clickSettingTab();
        account = accountSettings.deleteAccount();

        //Verify the account has been removed
        String actualDeletedMessage = account.getDeleteAccountMessage();
        String expectedMessage = ACCOUNT_NAME + " was successfully deleted";
        assertEquals(actualDeletedMessage.toLowerCase(), expectedMessage.toLowerCase());
    }
}
