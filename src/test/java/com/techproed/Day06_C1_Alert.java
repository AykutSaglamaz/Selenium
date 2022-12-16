package com.techproed;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Day06_C1_Alert {
/*
Go to https://the-internet.herokuapp.com/javascript_alerts
Create a class: AlertTest
Create setUp method
Create 3 test methods:
acceptAlert() => click on the first alert, verify the text “I am a JS Alert” , click OK , and Verify “You successfuly clicked an alert”
dismissAlert()=> click on the second alert, verify text "I am a JS Confirm”, click cancel, and Verify “You clicked: Cancel”
sendKeysAlert()=> click on the third alert, verify text “I am a JS prompt”, type “Hello Word”, click OK, and Verify “You entered: Hello Word”
 */
    /*
    *****Alerts:
    -accept()->Same as clicking OK of an alert.
        driver.switchTo().alert().accept();
    -dismiss()->Same as clicking Cancel of an alert.
        driver.switchTo().alert().dismiss();
    -getText()-> To get the alert message of the alert.
        driver.switchTo().alert().getText();
    -sendKeys("Text")->To send a text into alert textbox
        driver.switchTo().alert().sendKeys("Text")
     */
WebDriver driver;
    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("http://the-internet.herokuapp.com/javascript_alerts");
    }
    @Test
    public void acceptAlert(){
//        click on the first alert,
        driver.findElement(By.xpath("//button[@onclick='jsAlert()']")).click();
//        verify the text “I am a JS Alert” ,
        String alertText=driver.switchTo().alert().getText();
        Assert.assertEquals("I am a JS Alert",alertText);
//        click OK ,
        driver.switchTo().alert().accept();
//        and Verify “You successfully clicked an alert”
        String result = driver.findElement(By.id("result")).getText();
        Assert.assertEquals("You successfully clicked an alert",result);
    }

    @Test
    public void dismissAlert(){
  //     dismissAlert()=> click on the second alert,
        driver.findElement(By.xpath("//button[@onclick='jsConfirm()']")).click();
  //     verify text "I am a JS Confirm”,
        Assert.assertEquals("Text does not match", "I am a JS Confirm", driver.switchTo().alert().getText());
  //     click cancel
        driver.switchTo().alert().dismiss();
  //     and Verify “You clicked: Cancel”
      String  result2 = driver.findElement(By.xpath("//p[@id='result']")).getText();
      Assert.assertEquals("You clicked: Cancel", result2);

    }
    @Test
    public void sendKeys(){
//sendKeysAlert()=> click on the third alert,
        driver.findElement(By.xpath("//button[@onclick='jsPrompt()']")).click();
// verify text “I am a JS prompt”,
      String actual =  driver.switchTo().alert().getText();
      String expected = "I am a JS prompt";
      Assert.assertEquals(actual, expected);
// type “Hello Word”,
        driver.switchTo().alert().sendKeys("Hello World");
        //click OK, and
        driver.switchTo().alert().accept();
// Verify “You entered: Hello World”
        Assert.assertEquals("You entered: Hello World", driver.findElement(By.xpath("//p[@id='result']")).getText());
// done
    }
@After
    public void tearDown(){
        driver.close();
}
}


