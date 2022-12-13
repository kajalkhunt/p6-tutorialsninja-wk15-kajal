package com.tutorialsninja.testsuite;

import com.tutorialsninja.pages.LaptopsAndNoteBooks;
import com.tutorialsninja.testbase.BaseTest;
import org.openqa.selenium.By;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LaptopsAndNoteBooksTest extends BaseTest {


    LaptopsAndNoteBooks laptopsAndNoteBooks;

    @BeforeMethod(alwaysRun = true)
    public void inIt(){
        laptopsAndNoteBooks = new LaptopsAndNoteBooks();
    }
    @Test(groups = {"sanity", "regression"})
    public void verifyProductsPriceDisplayHighToLowSuccessfully() throws InterruptedException {
        laptopsAndNoteBooks.verifyProductsPriceDisplayHighToLowSuccessfully();
    }

    @Test(groups = {"smoke", "regression"})
    public void verifyThatUserPlaceOrderSuccessfully() throws InterruptedException {
        laptopsAndNoteBooks.verifyProductsPriceDisplayHighToLowSuccessfully();
        //2.4 Select Product “MacBook”
        laptopsAndNoteBooks.clickOnMacBook();
        //2.5 Verify the text “MacBook”
        Thread.sleep(5000);
        assertAssert("MacBook not selected", laptopsAndNoteBooks.exptectedTextMessage("MacBook"), laptopsAndNoteBooks.actualTextToVerify(By.xpath("//h1[text()='MacBook']")));
        //2.6 Click on ‘Add To Cart’ button
        laptopsAndNoteBooks.clickOnAddToCart();
        //2.7 Verify the message “Success: You have added MacBook to your shopping cart!”
        assertAssert("Product has not been added to Cart", laptopsAndNoteBooks.exptectedTextMessage("Success: You have added MacBook to your shopping cart!"), laptopsAndNoteBooks.actualTextToVerify(By.xpath("//div[@class = 'alert alert-success alert-dismissible']")).substring(0, 54));
        //2.8 Click on link “shopping cart” display into success message
        laptopsAndNoteBooks.clickOnShoppingCart();
        //2.9 Verify the text "Shopping Cart"
        assertAssert("Not on Shopping cart", laptopsAndNoteBooks.exptectedTextMessage("Shopping Cart"), laptopsAndNoteBooks.actualTextToVerify(By.xpath("//h1[contains(text(), 'Shopping Cart')]")).substring(0, 13));

        //2.10 Verify the Product name "MacBook"
        assertAssert("MacBook is not on cart", laptopsAndNoteBooks.exptectedTextMessage("MacBook"), laptopsAndNoteBooks.actualTextToVerify(By.xpath("//div[@class = 'table-responsive']/table/tbody/tr/td[2]/a")));

        //2.11 Change Quantity "2"
        laptopsAndNoteBooks.sendTextToElement();

        //2.12 Click on “Update” Tab
        laptopsAndNoteBooks.clickOnUpdate();

        //2.13 Verify the message “Success: You have modified your shopping cart!”
        assertAssert("Cart not modified", laptopsAndNoteBooks.exptectedTextMessage("Success: You have modified your shopping cart!"), laptopsAndNoteBooks.actualTextToVerify(By.xpath("//div[@class = 'alert alert-success alert-dismissible']")).substring(0, 46));

        //Convert Currency to pounds
        laptopsAndNoteBooks.currencyConverter();

        //2.14 Verify the Total £737.45
        assertAssert("Total is not Matching", laptopsAndNoteBooks.exptectedTextMessage("£737.45"), laptopsAndNoteBooks.actualTextToVerify(By.xpath("//div[@class = 'table-responsive']/table/tbody/tr/td[6]")));

        //2.15 Click on “Checkout” button
        laptopsAndNoteBooks.clickOnCheckoutButton();

        //2.16 Verify the text “Checkout”
        assertAssert("Not on Checkout", laptopsAndNoteBooks.exptectedTextMessage("Checkout"), laptopsAndNoteBooks.actualTextToVerify(By.xpath("//h1[contains(text(),'Checkout')]")));
        Thread.sleep(2000);
        //2.17 Verify the Text “New Customer”
        assertAssert("New customer text is not display", laptopsAndNoteBooks.exptectedTextMessage("New Customer"), laptopsAndNoteBooks.actualTextToVerify(By.xpath("//h2[text()='New Customer']")));

        //2.18 Click on “Guest Checkout” radio button
        laptopsAndNoteBooks.clickOnRadioButton();

        //2.19 Click on “Continue” tab
        laptopsAndNoteBooks.clickOnContinueButton();

        //2.20 Fill the mandatory fields
        laptopsAndNoteBooks.addingMandatoryFields("Enter First Name", "Raghav", By.id("input-payment-firstname"));
        laptopsAndNoteBooks.addingMandatoryFields("Enter Last Name", "Raja", By.id("input-payment-lastname"));
        laptopsAndNoteBooks.addingMandatoryFields("Enter Email", "RaghavRaja@gmail.com", By.id("input-payment-email"));
        laptopsAndNoteBooks.addingMandatoryFields("Enter Telephone", "02089056066", By.id("input-payment-telephone"));
        laptopsAndNoteBooks.addingMandatoryFields("Enter Address1", "95 Harrow Road", By.id("input-payment-address-1"));
        laptopsAndNoteBooks.addingMandatoryFields("Enter City", "London", By.id("input-payment-city"));
        laptopsAndNoteBooks.addingMandatoryFields("Enter Postcode", "HA8 9ZZ", By.id("input-payment-postcode"));
        laptopsAndNoteBooks.selectCountry();
        laptopsAndNoteBooks.selectState();


        //2.21 Click on “Continue” Button
        laptopsAndNoteBooks.clickOnContinueButtonPayment();

        //2.22 Add Comments About your order into text area
        laptopsAndNoteBooks.addComment();

        //2.23 Check the Terms & Conditions check box
        laptopsAndNoteBooks.checkBoxClick();

        //2.24 Click on “Continue” button
        laptopsAndNoteBooks.clickOnLastContinueButton();

        //2.25 Verify the message “Warning: Payment method required!”
        assertAssert("Not checking payment method", laptopsAndNoteBooks.exptectedTextMessage("Warning: Payment method required!"), laptopsAndNoteBooks.actualTextToVerify(By.xpath("//div[@class = 'alert alert-danger alert-dismissible']")).substring(0, 33));

    }
}
