package com.telran.oscarshop.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BasketPage extends PageBase {
    public BasketPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = ".page-header.action")
    WebElement basketTitle;

    public boolean isItBasketPage() {
        return basketTitle.isDisplayed();
    }

    @FindBy(css = ".h1 a")
    WebElement Logo;

    public HomePage clickOnLogo() {
        pause(2000);
        click(Logo);
        return new HomePage(driver);
    }

    @FindBy(css = ".input-group-btn .btn btn-default")
    WebElement clickOnUpdate;

    @FindBy(id = "id_form-0-quantity")
    WebElement quantity;


    public BasketPage removeAllItemsFromBasket() {
        while (isElementPresent(By.cssSelector(".basket-items"))) {
            type(quantity, "0");
            click(clickOnUpdate);
            pause(2000);
        }
        return this;
    }
}
