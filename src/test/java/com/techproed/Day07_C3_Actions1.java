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

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.beans.PropertyChangeListener;
import java.util.concurrent.TimeUnit;
/*
Create a test method : contextClickMethod() and test the following scenario:
Given user is on the https://the-internet.herokuapp.com/context_menu
When use Right clicks on the box
Then verify the alert message is “You selected a context menu”
Then accept the alert
 */
public class Day07_C3_Actions1 {

    WebDriver driver;
    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }
    @Test
    public  void contextClickMethod(){
//        Given user is on the https://the-internet.herokuapp.com/context_menu

        driver.get("https://the-internet.herokuapp.com/context_menu");
//        When use Right clicks on the box
        //1.create action object
        Actions actions = new Actions(driver);
        //2.Locate the elements that you want to intact
        WebElement box = driver.findElement(By.id("hot-spot"));
        //3. Now that I got actions and element, I can right click. perform () must be used at the end
        actions.contextClick(box).perform();

//        Then verify the alert message is “You selected a context menu”
        String alert = driver.switchTo().alert().getText();
        Assert.assertEquals("You selected a context menu", alert);
//        Then accept the alert

        driver.switchTo().alert().accept();
    }

    @After
    public  void closePage(){

        driver.close();
    }
}
