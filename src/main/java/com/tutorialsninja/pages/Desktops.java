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

public class Desktops extends Utility {

    @CacheLookup
    @FindBy(linkText = "Desktops")
    WebElement mouseHoverOnDesktop;
    @CacheLookup
    @FindBy(linkText = "Show All Desktops")
    WebElement mouseHoverShowAllDesktop;
    @CacheLookup
    @FindBy(xpath = "//a[contains(text(),'HP LP3065')]")
    WebElement hPLP3065;

    @CacheLookup
    @FindBy(xpath = "//h1[contains(text(),'HP LP3065')]")
    WebElement hPLP3065Text;

    @CacheLookup
    @FindBy(xpath = "//button[@id='button-cart']")
    WebElement addToCartButton;

    By successShoppingCart = By.cssSelector("body:nth-child(2) div.container:nth-child(4) > div.alert.alert-success.alert-dismissible");


    public void getMouseHoverDesktop() {
        Reporter.log("Mouse hovering on desktop");
        mouseHoverToElement(mouseHoverOnDesktop);
        mouseHoverToElementAndClick(mouseHoverShowAllDesktop);
    }

    public void alphabeticalOrder() {
        Reporter.log("Sorting product in Z to A");
        List<WebElement> products = driver.findElements(By.xpath("//h4/a"));
        ArrayList<String> originalProductsName = new ArrayList<>();
        for (WebElement e : products) {
            originalProductsName.add(e.getText());
        }
        System.out.println(originalProductsName);

        Collections.reverse(originalProductsName);
        System.out.println(originalProductsName);
        selectByVisibleTextFromDropDown(By.id("input-sort"), "Name (Z - A)");
        products = driver.findElements(By.xpath("//h4/a"));
        ArrayList<String> afterSortByZToAProductsName = new ArrayList<>();
        for (WebElement e : products) {
            afterSortByZToAProductsName.add(e.getText());
        }
        System.out.println(afterSortByZToAProductsName);
        Assert.assertEquals(originalProductsName, afterSortByZToAProductsName, "Product not sorted into Z to A order");
    }

    public void aToZAlphabeticalOrder() {
        Reporter.log("Sorting product to A to Z");
        selectByVisibleTextFromDropDown(By.id("input-sort"), "Name (A - Z)");
        clickOnElement(hPLP3065);
    }

    public String verifyHPL3065Text() {
        Reporter.log("Verifying product text");
        return getTextFromElement(hPLP3065Text);
    }

    public void deliveryDate() {
        Reporter.log("Changing date");
        String year = "2022";
        String month = "November";
        String date = "30";
        clickOnElement(By.xpath("//div[@class = 'input-group date']//button"));
        while (true) {
            String monthAndYear = driver.findElement(By.xpath("//div[@class = 'datepicker']/div[1]//th[@class='picker-switch']")).getText();
            String[] arr = monthAndYear.split(" ");
            String mon = arr[0];
            String yer = arr[1];
            if (mon.equalsIgnoreCase(month) && yer.equalsIgnoreCase(year)) {
                break;
            } else {
                clickOnElement(By.xpath("//div[@class = 'datepicker']/div[1]//th[@class='next']"));
            }
        }
        List<WebElement> allDates = driver.findElements(By.xpath("//div[@class = 'datepicker']/div[1]//tbody/tr/td[@class = 'day']"));
        for (WebElement e : allDates) {
            if (e.getText().equalsIgnoreCase(date)) {
                e.click();
                break;
            }
        }
    }

    public String exptectedTextMessage(String exp) {
        Reporter.log("Expected text");
        return exp;
    }

    public String actualTextToVerify(By by) {
        Reporter.log("Getting actual text");
        String act = driver.findElement(by).getText();
        System.out.println(act);
        return act;
    }

    public void clickOnAddToCart() {
        Reporter.log("Clicking on add to cart");
        clickOnElement(By.xpath("//button[@id='button-cart']"));
    }

    public void clickOnShoppingCart() {
        Reporter.log("Clicking on shopping cart");
        clickOnElement(By.xpath("//a[contains(text(),'shopping cart')]"));
    }

    public void currencyConverter() {
        Reporter.log("Selecting currency");
        clickOnElement(By.xpath("//span[contains(text(),'Currency')]"));
        List<WebElement> currencyList = driver.findElements(By.xpath("//ul[@class = 'dropdown-menu']/li"));
        for (WebElement e : currencyList) {
            if (e.getText().equalsIgnoreCase("£ Pound Sterling")) {
                e.click();
                break;
            }
        }
    }

}
