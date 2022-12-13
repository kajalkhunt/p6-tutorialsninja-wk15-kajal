package com.tutorialsninja.pages;

import com.tutorialsninja.utility.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.testng.Reporter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class LaptopsAndNoteBooks extends Utility {
    @CacheLookup
    @FindBy(linkText = "Laptops & Notebooks")
    WebElement mouseHoverOnLapNotBooks;
    @CacheLookup
    @FindBy(linkText = "Show All Laptops & Notebooks")
    WebElement mouseHoverShowAllLapNotBooks;
    @CacheLookup
    @FindBy(linkText = "MacBook")
    WebElement macBook;
    @CacheLookup
    @FindBy(xpath = "//button[@id='button-cart']")
    WebElement addToCart;
    @CacheLookup
    @FindBy(xpath = "//a[contains(text(),'shopping cart')]")
    WebElement shoppingCart;

      By qty = By.xpath("//input[contains(@name, 'quantity')]");

    @CacheLookup
    @FindBy(xpath = "//button[contains(@data-original-title, 'Update')]")
    WebElement update;
    @CacheLookup
    @FindBy(xpath = "//a[contains(text(),'Checkout')]")
    WebElement checkoutButton;

    @CacheLookup
    @FindBy(xpath = "//input[@value='guest']")
    WebElement radioButton;
    @CacheLookup
    @FindBy(xpath = "//input[@id='button-account']")
    WebElement continueButton;
    @CacheLookup
    @FindBy(id = "input-payment-country")
    WebElement country;
    @CacheLookup
    @FindBy(id = "input-payment-zone")
    WebElement state;

    @CacheLookup
    @FindBy(xpath = "//input[@id='button-guest']")
    WebElement contButton;

    @CacheLookup
    @FindBy (xpath = "//textarea[@name='comment']")
    WebElement addCommentText;

    @CacheLookup
    @FindBy(xpath = "//input[@name='agree']")
    WebElement checkBox;

    @CacheLookup
    @FindBy(xpath = "//input[@id='button-payment-method']")
    WebElement lastContButton;




    public void verifyProductsPriceDisplayHighToLowSuccessfully() throws InterruptedException {
        Reporter.log("Verifying product price desplay high to low");
        mouseHoverToElementAndClick(mouseHoverOnLapNotBooks);
        clickOnElement(mouseHoverShowAllLapNotBooks);
        List<WebElement> products = driver.findElements(By.xpath("//p[@class ='price']"));
        List<Double> originalProductsPrice = new ArrayList<>();
        for (WebElement e : products) {
            System.out.println(e.getText());
            String[] arr = e.getText().split("Ex Tax:");
            originalProductsPrice.add(Double.valueOf(arr[0].substring(1).replaceAll(",", "")));
        }
        System.out.println(originalProductsPrice);
        Collections.sort(originalProductsPrice, Collections.reverseOrder());
        System.out.println("Original Price List: " + originalProductsPrice);
        selectByVisibleTextFromDropDown(By.id("input-sort"), "Price (High > Low)");
        products = driver.findElements(By.xpath("//p[@class ='price']"));
        ArrayList<Double> afterSortByPrice = new ArrayList<>();
        for (WebElement e : products) {
            String[] arr = e.getText().split("Ex Tax:");
            afterSortByPrice.add(Double.valueOf(arr[0].substring(1).replaceAll(",", "")));
        }
        System.out.println(afterSortByPrice);
        Assert.assertEquals(originalProductsPrice, afterSortByPrice, "Product not sorted by price High to Low");
    }

    public void clickOnMacBook() {
        Reporter.log("Clicking on macbook");
        clickOnElement(macBook);
    }

    public String exptectedTextMessage(String exp) {
        Reporter.log("Expected Text");
        return exp;
    }

    public String actualTextToVerify(By by) {
        Reporter.log("Text verification");
        String act = driver.findElement(by).getText();
        System.out.println(act);
        return act;
    }

    public void clickOnAddToCart(){
        Reporter.log("Clicking on add to cart");
        clickOnElement(addToCart);
    }
    public void clickOnShoppingCart(){
        Reporter.log("Clicking on shopping cart");
        clickOnElement(shoppingCart);
    }
    public void sendTextToElement(){
        Reporter.log("Updating quantity");
        driver.findElement(qty).clear();
        sendTextToElement((qty),"2");
    }


    public void clickOnUpdate() {
        Reporter.log("Clicking on update");
        clickOnElement(update);
    }

    public void currencyConverter(){
        Reporter.log("Selecting currency");
        clickOnElement(By.xpath("//span[contains(text(),'Currency')]"));
        List<WebElement> currencyList = driver.findElements(By.xpath("//ul[@class = 'dropdown-menu']/li"));
        for (WebElement e:currencyList ) {
            if (e.getText().equalsIgnoreCase("£ Pound Sterling")){
                e.click();
                break;
            }
        }
    }
    public void clickOnCheckoutButton() {
        Reporter.log("Click on check out button");
        clickOnElement(checkoutButton);
    }
    public void clickOnRadioButton() {
        Reporter.log("Clicking radio button");
        clickOnElement(radioButton);
        clickOnElement(continueButton);
    }
    public void clickOnContinueButton() {
        Reporter.log("Clicking on continue button");
        clickOnElement(continueButton);
    }

    public void addingMandatoryFields(String fieldName, String sendText, By by){
        Reporter.log("Filling mandatory fields");
        sendTextToElement(by, sendText);
    }
    public void selectCountry(){
        Reporter.log("Selecting country");
        selectByVisibleTextFromDropDown(country, "United Kingdom");
    }
    public void selectState(){
        Reporter.log("Selecting state");
        selectByVisibleTextFromDropDown(state, "Surrey");
    }
    public void clickOnContinueButtonPayment(){
        Reporter.log("Clicking on continue button payment");
        clickOnElement(contButton);
    }
    public void addComment(){
        Reporter.log("adding comment");
        sendTextToElement(addCommentText, "Please BE AWARE of the TIGERS.......................");
    }
    public void checkBoxClick(){
        Reporter.log("Click on checkbox");
        clickOnElement(checkBox);
    }
    public void clickOnLastContinueButton(){
        Reporter.log("Clicking on continue button");
        clickOnElement(lastContButton);
    }
}
