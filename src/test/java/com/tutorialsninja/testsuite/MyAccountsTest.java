package com.tutorialsninja.testsuite;

import com.tutorialsninja.pages.MyAccounts;
import com.tutorialsninja.testbase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class MyAccountsTest extends BaseTest {

    MyAccounts myAccounts;
    @BeforeMethod(alwaysRun = true)
    public void inIt(){
        myAccounts = new MyAccounts();
    }

    @Test(groups = {"sanity", "regression"})
    public void verifyUserShouldNavigateToRegisterPageSuccessfully() {
        myAccounts.clickOnMyAccounts();
        myAccounts.selectMyAccountOptions("Register");
        Assert.assertEquals(myAccounts.getRegisterText(),"Register Account","Not Matching");

    }
    @Test(groups = {"smoke", "regression"})
    public void verifyUserShouldNavigateToLoginPageSuccessfully() {
        myAccounts.clickOnMyAccounts();
        myAccounts.selectMyAccountOptions("Login");
        Assert.assertEquals(myAccounts.getReturningCustomerText(),"Returning Customer","Not Matching");

    }

    @Test(groups = {"smoke", "regression"})
    public void verifyThatUserRegisterAccountSuccessfully(){
        myAccounts.clickOnMyAccounts();
        myAccounts.selectMyAccountOptions("Register");
        myAccounts.fieldRegisterAccountDetails();
        myAccounts.clickOnRadioButton();
        myAccounts.clickOnAgree();
        myAccounts.clickOnContinue();
        Assert.assertEquals(myAccounts.getAccountText(),"Your Account Has Been Created!","Not Matching");
        myAccounts.clickOnCont();
        myAccounts.clickOnMyAccounts();
        myAccounts.selectMyAccountOptions("Logout");
        Assert.assertEquals(myAccounts.getLogOutText(),"Account Logout","Not matching");
        myAccounts.clickOnCont();
    }

    @Test(groups = "regression")
    public void verifyThatUserShouldLoginAndLogoutSuccessfully(){
        myAccounts.clickOnMyAccounts();
        myAccounts.selectMyAccountOptions("Login");
        myAccounts.sendEmailPasswordDetails();
        myAccounts.clickOnSubmit();
        myAccounts.clickOnMyAccounts();
        myAccounts.selectMyAccountOptions("Logout");
        Assert.assertEquals(myAccounts.getAccountLogOutText(),"Account Logout","Not matching");
    }
    }


