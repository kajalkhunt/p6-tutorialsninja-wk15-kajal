package com.tutorialsninja.testsuite;

import com.tutorialsninja.pages.Desktops;
import com.tutorialsninja.testbase.BaseTest;
import org.openqa.selenium.By;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DesktopsTest extends BaseTest {

    Desktops desktops;
    @BeforeMethod(alwaysRun = true)
    public void inIt(){
        desktops = new Desktops();
    }

    @Test(groups = {"sanity", "regression"})
    public void verifyProductArrangeInAlphaBaticalOrder() {
        desktops.getMouseHoverDesktop();
        desktops.alphabeticalOrder();
    }

    @Test(groups = {"smoke", "regression"})
    public void verifyProductAddedToShoppingCartSuccessFully(){
        desktops.getMouseHoverDesktop();
        desktops.aToZAlphabeticalOrder();

        assertAssert("HP LP3065 Not Matched ", desktops.exptectedTextMessage("HP LP3065"), desktops.actualTextToVerify(By.xpath("//h1[contains(text(),'HP LP3065')]")));
        desktops.deliveryDate();
        desktops.clickOnAddToCart();
        assertAssert("Not added to Cart", desktops.exptectedTextMessage ("Success: You have added HP LP3065 to your shopping cart!"), desktops.actualTextToVerify(By.xpath("//div[@class = 'alert alert-success alert-dismissible']")).substring(0, 56));
        desktops.clickOnShoppingCart();
        assertAssert("Not on Shopping Cart ", desktops.exptectedTextMessage("Shopping Cart"), desktops.actualTextToVerify(By.xpath("//div[@id='content']//h1")).substring(0,13));
        assertAssert("HP LP3065 Not found ", desktops.exptectedTextMessage("HP LP3065"), desktops.actualTextToVerify(By.xpath("//div[@class = 'table-responsive']/table/tbody/tr/td[2]/a")));
        assertAssert("Invalid Date ", desktops.exptectedTextMessage("2022-11-30"), desktops.actualTextToVerify(By.xpath("(//small[contains(text(), '2022-11-30')])[2]")).substring(15,25));
        assertAssert("Product 21 Not found", desktops.exptectedTextMessage("Product 21"), desktops.actualTextToVerify(By.xpath("//div[@class = 'table-responsive']/table/tbody/tr/td[3]")));
        desktops.currencyConverter();
        assertAssert("Price is incorrect", desktops.exptectedTextMessage("£74.73"), desktops.actualTextToVerify(By.xpath("//div[@class = 'table-responsive']/table/tbody/tr/td[6]")));

    }
}
