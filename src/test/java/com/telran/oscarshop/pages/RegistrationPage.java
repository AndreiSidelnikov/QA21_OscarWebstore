package com.telran.oscarshop.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegistrationPage extends PageBase {
    public RegistrationPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "id_registration-email")
    WebElement emailField;

    @FindBy(id = "id_registration-password1")
    WebElement passwordField;

    @FindBy(id = "id_registration-password2")
    WebElement confirmPswField;

    @FindBy(name = "registration_submit")
    WebElement registerBtn;

    public RegistrationPage fillRegistrationForm(String email, String pwd, String pwd1) {
        type(emailField, email);
        type(passwordField, pwd);
        type(confirmPswField, pwd1);
        registerBtn.click();
        return this;
    }
}