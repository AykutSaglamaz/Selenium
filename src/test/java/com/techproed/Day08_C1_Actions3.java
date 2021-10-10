package com.techproed;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

/*
Create a class: Actions3
Create test method : keysUpDown()
Go to google/amazon
Send iPhone X prices => convert small letter capital vice versa.
Highlight the search box by double clicking
 */
public class Day08_C1_Actions3 {
    WebDriver driver;

    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();

    }
    @Test
    public void keyUpDown(){
        driver.get("https://www.google.com");
        // if you see cokies then add this line
        //driver.findElement(By.xpath("//*[@id='L2AGLb']")).click();
      WebElement searchBox = driver.findElement(By.xpath("//input[@name ='q']"));
      //searchBox.SendKeys("iPhone X prices")
        Actions actions = new Actions(driver);

        actions.
                keyDown(searchBox, Keys.SHIFT).//press on shift button
                sendKeys("iPhone X prices").//type on in the element
                keyUp(searchBox,Keys.SHIFT).//unpress on the shift button
                sendKeys(" too expensive"+ Keys.ENTER).
                build().//build is optionally used to make perform stronger.Without build(), this will work
                perform();



    }


    @After
    public void tearDown(){
   //     driver.close();

    }

}
