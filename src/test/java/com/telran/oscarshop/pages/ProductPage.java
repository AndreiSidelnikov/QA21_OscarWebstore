package com.telran.oscarshop.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductPage extends PageBase {
    public ProductPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = ".page-header.action")
    WebElement pageTitle;

    public boolean isItProductPage() {
        return pageTitle.isDisplayed();
    }

    @FindBy(xpath = "//body/div[2]/div[1]/div[1]/div[1]/section[1]/div[1]/ol[1]/li[1]/article[1]/div[2]/form[1]/button[1]")
    WebElement addFirstBook;

    public ProductPage AddFirstBookToTheBasket() {
        click(addFirstBook);
        return new ProductPage(driver);
    }

    @FindBy(xpath = "//body/div[2]/div[1]/div[1]/div[1]/section[1]/div[1]/ol[1]/li[1]/article[1]/div[2]/form[1]/button[1]")
    WebElement addSecondBook;

    public ProductPage AddSecondBookToTheBasket() {
        click(addSecondBook);
        return new ProductPage(driver);
    }
}