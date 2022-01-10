package com.telran.oscarshop.pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.Collection;

public class HomePage extends PageBase {

    public HomePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = ".dropdown-submenu")
    WebElement submenuBook;


    public ProductPage selectCategory() {
        click(submenuBook);
        return new ProductPage(driver);
    }

    @FindBy(id = "login_link")
    WebElement loginLink;

    public RegistrationPage clickOnLoginOrRegistrationButton() {
        loginLink.click();
        return new RegistrationPage(driver);
    }

    @FindBy(xpath = "//i[@class='icon-user']")
    WebElement accountButton;

    public ProfilePage clickOnAccount() {
        accountButton.click();
        return new ProfilePage(driver);
    }

    @FindBy(id = "logout_link")
    WebElement logoutLink;

    public boolean isLogoutPresent() {
        return isElementPresent(By.id("logout_link"));
    }

    public HomePage clickOnLogout() {
        click(logoutLink);
        return new HomePage(driver);
    }

    @FindBy(css = ".h1 a")
    WebElement Logo;

    public HomePage clickOnLogo() {
        pause(2000);
        click(Logo);
        return this;
    }

    @FindBy(css = ".dropdown-submenu")
    WebElement booksSubmenu;

    public ProductPage selectCategoryBooks() {
        click(booksSubmenu);
        return new ProductPage(driver);
    }

    public String getItemOfHomePage() {
        String text = driver.findElement(By.xpath("//body/div[2]/div[1]/div[1]/div[1]/div[2]/section[1]")).getText();
        return text;
    }

    @FindBy(xpath = "//a[contains(text(),'All products')]")
    WebElement allProductsOption;

    public ProductPage chooseAllProductsOption() {
        click(allProductsOption);
        return new ProductPage(driver);
    }

    @FindBy(xpath = "//a[contains(text(),'Clothing')]")
    WebElement clothingOption;

    public ProductPage chooseClothingOption() {
        click(clothingOption);
        return new ProductPage(driver);
    }

    @FindBy(xpath = "//a[contains(text(),'Books')]")
    WebElement booksOption;

    public ProductPage chooseBooksOption() {
        click(booksOption);
        return new ProductPage(driver);
    }

    @FindBy(xpath = "//a[contains(text(),'Offers')]")
    WebElement offersOption;

    public ProductPage chooseOffersOption() {
        click(offersOption);
        return new ProductPage(driver);
    }

    @FindBy(css = "#id_q")
    WebElement searchField;

    public HomePage addSearchField(String searchName) {
        type(searchField, searchName);
        return this;
    }

    @FindBy(xpath = "//header/div[2]/div[1]/div[2]/form[1]/input[1]")
    WebElement searchButton;

    public ProductPage clickOnSearch() {
        click(searchButton);
        return new ProductPage(driver);
    }

    public String checkSearchField() {
        String text = driver.findElement(By.xpath("//h1[contains(text(),'Products matching \"\"')]")).getText();
        return text;
    }

    @FindBy(xpath = "//body/div[@id='top_page']/div[2]/div[1]/form[1]/div[1]/select[1]")
    WebElement selectLanguage;

    public HomePage selectLanguage(String text) {
        Select select = new Select(selectLanguage);
        select.selectByVisibleText(text);
        return this;
    }

    @FindBy(xpath = "//button[contains(text(),'Go')]")
    WebElement clickOnGoButton;

    public HomePage clickOnGoButton() {
        click(clickOnGoButton);
        return this;
    }

    @FindBy(xpath = "//strong[contains(text(),'Kori yhteensä:')]")
    WebElement TextBasketTotal;

    public String checkTextBasketTotal() {
        String text = TextBasketTotal.getText();
        return text;
    }

    @FindBy(xpath = "//a[contains(text(),'View basket')]")
    WebElement ViewBasketButton;

    public String clickOnViewBasket() {
        String text = ViewBasketButton.getText();
        return text;
    }

    @FindBy(xpath = "//button[contains(text(),'Ausführen')]")
    WebElement clickOnAusführenButton;

    public HomePage clickOnAusführenButton() {
        click(clickOnAusführenButton);
        return this;
    }
}

