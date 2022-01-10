package com.telran.oscarshop.tests;

import com.telran.oscarshop.pages.HomePage;
import com.telran.oscarshop.pages.LoginPage;
import com.telran.oscarshop.pages.ProductPage;
import com.telran.oscarshop.pages.RegistrationPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HomePageTests extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() {
        if (new HomePage(driver).isLogoutPresent()) {
            new HomePage(driver).clickOnLogout();
        }
    }

    @Test
    public void guestCanSelectProductFromMenuTest() {
        new HomePage(driver).selectCategory();
        Assert.assertTrue(new ProductPage(driver).isItProductPage());
    }

    @Test
    public void LogoTest() {
        new HomePage(driver).clickOnLogo();
        new HomePage(driver).selectCategoryBooks();
        new HomePage(driver).clickOnLogo();
        Assert.assertTrue(new HomePage(driver).getItemOfHomePage().contains("Welcome to Oscar's sandbox site."));
    }

    @Test
    public void guestLoginButtonTest() {
        new HomePage(driver).clickOnLoginOrRegistrationButton();
        Assert.assertTrue(new LoginPage(driver).isItLoginPage());
    }

    @Test
    public void guestRegistrationButtonTest() {
        new HomePage(driver).clickOnLoginOrRegistrationButton();
        Assert.assertTrue(new RegistrationPage(driver).isItRegistrationPage());
    }

    @Test
    public void guestAllProductsOptionTest() {
        new HomePage(driver).chooseAllProductsOption();
        Assert.assertTrue(new ProductPage(driver).isItProductPage());
    }

    @Test
    public void guestClothingOptionTest() {
        new HomePage(driver).chooseClothingOption();
        Assert.assertTrue(new ProductPage(driver).isItProductPage());
    }

    @Test
    public void guestBooksOptionTest() {
        new HomePage(driver).chooseBooksOption();
        Assert.assertTrue(new ProductPage(driver).isItProductPage());
    }

    @Test
    public void guestOffersOptionTest() {
        new HomePage(driver).chooseOffersOption();
        Assert.assertTrue(new ProductPage(driver).isItProductPage());
    }

    @Test
    public void guestEmptySearchTest() {
        new HomePage(driver).addSearchField("       ");
        new HomePage(driver).clickOnSearch();
        Assert.assertTrue(new HomePage(driver).checkSearchField().contains("Products matching \"\""));
    }

    @Test
    public void guestChangeLanguageTest() {
        new HomePage(driver).selectLanguage("suomi");
        new HomePage(driver).clickOnGoButton();
        Assert.assertTrue(new HomePage(driver).checkTextBasketTotal().contains("Kori yhteensä"));
    }

}