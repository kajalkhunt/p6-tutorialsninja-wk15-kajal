package com.tutorialsninja.pages;

import com.tutorialsninja.utility.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

import java.util.List;

public class MyAccounts extends Utility {

    @FindBy(xpath = "//span[contains(text(),'My Account')]")
    WebElement myAccount;
    @CacheLookup
    @FindBy(xpath = "//h1[contains(text(),'Register Account')]")
    WebElement registerAccount;

    @CacheLookup
    @FindBy(xpath = "//h2[contains(text(),'Returning Customer')]")
    WebElement returningCustomerText;

    @CacheLookup
    @FindBy(id = "input-firstname")
    WebElement firstNameField;
    @CacheLookup
    @FindBy(id = "input-lastname")
    WebElement lastNameField;

    @CacheLookup
    @FindBy(id = "input-email")
    WebElement emailField;

    @CacheLookup
    @FindBy(id = "input-telephone")
    WebElement telephoneField;

    @CacheLookup
    @FindBy(id = "input-password")
    WebElement passwordField;

    @CacheLookup
    @FindBy(id = "input-confirm")
    WebElement confirmPasswordField;

    @CacheLookup
    @FindBy(xpath = "(//input[@type='radio'])[2]")
    WebElement clickOnRadio;

    @CacheLookup
    @FindBy(xpath = "//div[@class = 'buttons']//input[@name='agree']")
    WebElement clickAgree;
    @CacheLookup
    @FindBy(xpath = "//div[@class = 'buttons']//input[@value='Continue']")
    WebElement clickContinue;

    @CacheLookup
    @FindBy(xpath = "//h1[contains(text(),'Your Account Has Been Created!')]")
    WebElement accountMessage;


    @FindBy(xpath = "//a[contains(text(),'Continue')]")
    WebElement clickCont;

    @CacheLookup
    @FindBy(xpath = "//span[contains(text(),'My Account')]")
    WebElement clickAcc;


    @CacheLookup
    @FindBy(xpath = "//h1[contains(text(),'Account Logout')]")
    WebElement logoutText;


    @CacheLookup
    @FindBy(id = "input-email")
    WebElement email;

    @CacheLookup
    @FindBy(id = "input-password")
    WebElement password;

    @CacheLookup
    @FindBy(xpath = "//form[contains(@action,'login')]//input[@type='submit']")
    WebElement clickSubmit;


    @CacheLookup
    @FindBy(xpath = "//h1[contains(text(),'Account Logout')]")
    WebElement accountLogoutText;


    public void selectMyAccountOptions(String option) {
        Reporter.log("Selecting my account option");
        List<WebElement> myAccountList = driver.findElements(By.xpath("//div[@id='top-links']//li[contains(@class,'open')]/ul/li"));
        try {
            for (WebElement options : myAccountList) {
                if (options.getText().equalsIgnoreCase(option)) {
                    options.click();
                }
            }
        } catch (
                StaleElementReferenceException e) {
            myAccountList = driver.findElements(By.xpath("//div[@id='top-links']//li[contains(@class,'open')]/ul/li"));
        }

    }

    public void clickOnMyAccounts() {
        Reporter.log("Click on my accounts");
        clickOnElement(myAccount);
    }

    public String getRegisterText() {
        Reporter.log("Getting register text");
        return getTextFromElement(registerAccount);
    }

    public String getReturningCustomerText() {
        Reporter.log("Getting returning customer text");
        return getTextFromElement(returningCustomerText);
    }

    public void fieldRegisterAccountDetails() {
        Reporter.log("Filling account registration details");
        sendTextToElement(firstNameField, "prime" + getAlphaNumericString(4));
        sendTextToElement(lastNameField, "test" + getAlphaNumericString(4));
        sendTextToElement(emailField, "prime" + getAlphaNumericString(4) + "@gmail.com");
        sendTextToElement(telephoneField, "07988112233");
        sendTextToElement(passwordField, "test123");
        sendTextToElement(confirmPasswordField, "test123");

    }

    public void clickOnRadioButton() {
        Reporter.log("Clicking on radio button");
        clickOnElement(clickOnRadio);

    }

    public void clickOnAgree() {
        Reporter.log("Clicking on agree");
        clickOnElement(clickAgree);
    }

    public void clickOnContinue() {
        Reporter.log("Click on continue");
        clickOnElement(clickContinue);
    }

    public String getAccountText() {
        Reporter.log("Getting account text");
        return getTextFromElement(accountMessage);
    }

    public void clickOnCont() {
        Reporter.log("Clicking on continue");
        clickOnElement(clickCont);
    }

    public String getLogOutText() {
        Reporter.log("Getting logout text");
        return getTextFromElement(logoutText);
    }

    public void sendEmailPasswordDetails() {
        Reporter.log("Sending email and password");
        sendTextToElement(email, "prime123@gmail.com");
        sendTextToElement(password, "test123");
    }

    public void clickOnSubmit() {
        Reporter.log("Clicking on submit");
        clickOnElement(clickSubmit);
    }

    public String getAccountLogOutText() {
        Reporter.log("Getting account logout text");
        return getTextFromElement(accountLogoutText);
    }

}
