package com.telran.oscarshop.tests;

import com.telran.oscarshop.data.UserData;
import com.telran.oscarshop.pages.BasketPage;
import com.telran.oscarshop.pages.HomePage;
import com.telran.oscarshop.pages.LoginPage;
import com.telran.oscarshop.pages.ProductPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class OrderOfTwoBooksTest extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() {
        new HomePage(driver).clickOnLoginOrRegistrationButton();
        new LoginPage(driver).fillLoginForm(UserData.USER_NAME, UserData.USER_PASSWORD);
        new HomePage(driver).selectLanguage("British English");
        new HomePage(driver).clickOnAusführenButton();
        new HomePage(driver).clickOnViewBasket();
        new BasketPage(driver).removeAllItemsFromBasket();
        new BasketPage(driver).clickOnLogo();
    }

    @Test
    public void twoBooksPositiveTest() {
        new HomePage(driver).selectCategoryBooks();
        Assert.assertTrue(new ProductPage(driver).isItProductPage());
        new ProductPage(driver).AddFirstBookToTheBasket();
        new ProductPage(driver).AddSecondBookToTheBasket();
        new HomePage(driver).clickOnViewBasket();
        Assert.assertTrue(new BasketPage(driver).isItBasketPage());
    }
}
