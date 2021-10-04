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

import java.util.concurrent.TimeUnit;

/*
  Create test method and complete the following task.
  Go to https://the-internet.herokuapp.com/checkboxes
  Locate the elements of checkboxes
  Then click on checkbox1 if box is not selected
  Then click on checkbox2 if box is not selected
  Then verify that checkbox1 is checked.
   */
public class Day05_C1_CheckBox {

    WebDriver driver;
    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }
    @Test
    public  void checkbox(){
//    Go to https://the-internet.herokuapp.com/checkboxes
        driver.get("https://the-internet.herokuapp.com/checkboxes");

//        Locate the elements of checkboxes
        WebElement checkbox1= driver.findElement(By.xpath("(//input[@type='checkbox'])[1]"));
        WebElement checkbox2= driver.findElement(By.xpath("(//input[@type='checkbox'])[2]"));
//        Then click on checkbox1 if box is NOT selected
        //IsSelected() is used to check if checkbox or radio button is checked or not
        //returns true if checkbox is already selected. return false if it is not selected
        if (!checkbox1.isSelected()){
            checkbox1.click();
        }
//        Then click on checkbox2 if box is NOT selected
        if (!checkbox2.isSelected()){
            checkbox2.click();
        }

//        Then verify that checkbox1 is checked.
        Assert.assertTrue(checkbox1.isSelected());
        Assert.assertTrue(checkbox2.isSelected());


    }
    @After
    public void tearDown(){
        driver.close();
    }


}
