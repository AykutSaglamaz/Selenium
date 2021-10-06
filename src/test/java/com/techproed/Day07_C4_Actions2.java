package com.techproed;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.concurrent.TimeUnit;

/*
Create test method : hoverOver() and test the following scenario:
Given user is on the https://www.amazon.com/
When use click on “Account” link
Then verify the page title contains “Your Account”
 */
public class Day07_C4_Actions2 {
    WebDriver driver;
    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }
    @Test
    public void hoverOver() throws InterruptedException {
//        Given user is on the https://www.amazon.com/
        driver.get("https://www.amazon.com/");

//        When use click on “Account” link-> hoverover the element to click account element
        //1.create actions
        Actions actions = new Actions(driver);
        //2.locate the element you want to move over
        WebElement accountList = driver.findElement(By.id("nav-link-accountList"));
        //3. do your hover out
        actions.moveToElement(accountList).perform();
        Thread.sleep(5000);
        driver.findElement(By.linkText("Account")).click();


//        Then verify the page title contains “Your Account”
        Assert.assertTrue(driver.getTitle().contains("Your Account"));
    }
    @After
    public void tearDown(){
        driver.close();

    }
}
