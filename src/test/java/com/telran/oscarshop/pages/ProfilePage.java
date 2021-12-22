package com.telran.oscarshop.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProfilePage extends PageBase {

    public ProfilePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "delete_profile")
    WebElement deleteAccountBtn;

    public ProfilePage clickOnDeleteAccount() {
        deleteAccountBtn.click();
        return this;
    }

    @FindBy(id = "id_password")
    WebElement deletePwdField;

    @FindBy(css = ".btn.btn-lg.btn-danger")
    WebElement deleteBtn;

    public HomePage deleteAccount(String text) {
        type(deletePwdField, text);
        deleteBtn.click();
        return new HomePage(driver);
    }

    @FindBy(id = "logout_link")
    WebElement logout;

    public boolean isLogOutPresent() {
        return isElementPresent(By.id("logout_link"));
    }

    public HomePage logOut() {
        click(logout);
        return new HomePage(driver);
    }
}
