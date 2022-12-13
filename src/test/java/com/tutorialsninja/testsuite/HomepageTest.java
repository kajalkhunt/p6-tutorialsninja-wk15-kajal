package com.tutorialsninja.testsuite;

import com.tutorialsninja.customlisteners.CustomListeners;
import com.tutorialsninja.pages.HomePage;
import com.tutorialsninja.testbase.BaseTest;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
@Listeners(CustomListeners.class)
public class HomepageTest extends BaseTest {

    HomePage homePage;
    @BeforeMethod(alwaysRun = true)
    public void inIt(){
        homePage = new HomePage();
    }

    @Test(groups = {"sanity", "regression"})

    public void verifyUserShouldNavigateToDesktopsPageSuccessfully() {
        homePage.mouseHoverToElementAndClick(By.linkText("Desktops"));
        homePage.selectMenu("Show All Desktops");
        String expectedMessage = "Desktops";
        Assert.assertEquals(homePage.verifyDesktopText(), expectedMessage, "Not on Desktop Page");
    }

    @Test(groups = {"smoke", "regression"})
    public void verifyUserShouldNavigateToLaptopsAndNotebooksPageSuccessfully() {
        homePage.mouseHoverToElementAndClick(By.linkText("Laptops & Notebooks"));
        homePage.selectMenu("Show All Laptops & Notebooks");
        String expectedMessage = "Laptops & Notebooks";
        Assert.assertEquals(homePage.verifyLaptopAndNotebookText(), expectedMessage, "Not on Laptops & Notebooks Page");
    }
    @Test(groups = { "regression"})
    public void verifyUserShouldNavigateToComponentsPageSuccessfully() {
        homePage.mouseHoverToElementAndClick(By.linkText("Components"));
        homePage.selectMenu("Show All Components");
        String expectedMessage = "Components";
        Assert.assertEquals(homePage.verifyComponentsText(), expectedMessage, "Not on Components Page");
    }
}
