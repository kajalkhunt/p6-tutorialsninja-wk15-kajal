package com.tutorialsninja.pages;

import com.tutorialsninja.utility.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

import java.util.List;

public class HomePage extends Utility {

    public void selectMenu(String menu) {
        List<WebElement> topMenuList = driver.findElements(By.xpath("//nav[@id='menu']//ul/li[contains(@class, 'open')]/div/child::*"));
        try {
            for (WebElement element : topMenuList) {
                if (element.getText().equalsIgnoreCase(menu)) {
                    element.click();
                }
            }
        } catch (StaleElementReferenceException e) {
            topMenuList = driver.findElements(By.xpath("//nav[@id='menu']//ul/li[contains(@class, 'open')]/div/child::*"));
        }
    }

    @CacheLookup
    @FindBy(linkText = "Desktops")
    WebElement mouseHoverDesktop;
    @CacheLookup
    @FindBy(xpath = "//h2[contains(text(),'Desktops')]")
    WebElement desktopText;

    @CacheLookup
    @FindBy(linkText = "Laptops & Notebooks")
    WebElement mouseHoverLaptopAndNotebooks;
    @CacheLookup
    @FindBy(xpath = "//h2[contains(text(),'Laptops & Notebooks')]")
    WebElement laptopAndNotebookText;
    @CacheLookup
    @FindBy(linkText = "Components")
    WebElement mouseHoverComponents;
    @CacheLookup
    @FindBy(xpath = "//div/h2[contains(text(),'Components')]")
    WebElement componentsText;

    public void showAllDesktop(){
        Reporter.log("Show all desktop");
        mouseHoverToElement(mouseHoverDesktop);
        selectMenu("Show All Desktops");
    }

    public String verifyDesktopText(){
        Reporter.log("Verifying desktop text");
        return getTextFromElement(desktopText);
    }

    public void showAllLaptopAndNotebook(){
        Reporter.log("Showing all laptop and desktops");
        mouseHoverToElement(mouseHoverLaptopAndNotebooks);
        selectMenu("Show All Laptops & Notebooks");
    }

    public String verifyLaptopAndNotebookText(){
        Reporter.log("Verifying laptops and notebooks text");
        return getTextFromElement(laptopAndNotebookText);
    }
    public void showAllComponents(){
        Reporter.log("Clicking on show all componant");
        mouseHoverToElement(mouseHoverComponents);
        selectMenu("Show All Components");
    }

    public String verifyComponentsText(){
        Reporter.log("Verifying componant text");
        return  getTextFromElement(componentsText);
    }

}
