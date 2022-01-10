package com.telran.oscarshop.tests;

import com.telran.oscarshop.helpers.PropertiesLoader;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;


public class TestBase {

    WebDriver driver;

    public static String baseUrl = PropertiesLoader.loadProperty("url");

    Logger logger = LoggerFactory.getLogger(TestBase.class);


    @BeforeMethod
    public void setUp() {
//        ChromeOptions options = new ChromeOptions();
//        options.addArguments("headless");
//        options.addArguments("windows-size=1200x800");
//        driver = new ChromeDriver(options);
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        //   driver.manage().window().setSize(new Dimension(1920,1000));
        driver.get(baseUrl);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}