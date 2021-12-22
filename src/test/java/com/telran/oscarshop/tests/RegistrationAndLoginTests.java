package com.telran.oscarshop.tests;

import com.telran.oscarshop.data.UserData;
import com.telran.oscarshop.pages.HomePage;
import com.telran.oscarshop.pages.LoginPage;
import com.telran.oscarshop.pages.ProfilePage;
import com.telran.oscarshop.pages.RegistrationPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RegistrationAndLoginTests extends TestBase {

    @BeforeMethod
    public void precondition() {
        new HomePage(driver).clickOnLoginOrRegistrationButton();
    }

    @Test(priority = 1)
    public void registrationUserPositiveTest() {
        new RegistrationPage(driver).fillRegistrationForm("fdsdsds@gsg.com", "fsfsfsfsfF1!", "fsfsfsfsfF1!");
        new HomePage(driver).clickOnAccount();
//        new ProfilePage(driver).clickOnDeleteAccount().deleteAccount("fsfsfsfsfF1!");
        new ProfilePage(driver).logOut();
        logger.info("User registered with email - fdsdsds@gsg.com & password - fsfsfsfsfF1!");
    }

    @Test(priority = 2)
    public void loginPositiveTest() {
        new LoginPage(driver).fillLoginForm(UserData.USER_NAME, UserData.USER_PASSWORD);
        Assert.assertTrue(new ProfilePage(driver).isLogOutPresent());
        new ProfilePage(driver).logOut();
    }


    @Test(priority = 3)
    public void registrationUserWithWrongPasswordTest() {
        new RegistrationPage(driver).fillRegistrationForm("fdsdsd@gsg.com", "56565656", "56565656");
        new HomePage(driver).clickOnAccount();
        new ProfilePage(driver).clickOnDeleteAccount().deleteAccount("56565656");
        logger.info("User registered with email - fdsdsd@gsg.com & password - 56565656");
    }
}