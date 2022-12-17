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

import java.util.Set;
import java.util.concurrent.TimeUnit;

/*
Method name:windowHandle
Given user is on the https://the-internet.herokuapp.com/windows
Then user verifies the text : “Opening a new window”
Then user verifies the title of the page is “The Internet”
When user clicks on the “Click Here” button
Then user verifies the new window title is “New Window”
Then user verifies the text:  “New Window”
When user goes back to the previous window and then verifies the title : “The Internet”
 */
public class Day07_C2_WindowHandle {
    WebDriver driver;
@Before
public void setUp() {
    WebDriverManager.chromedriver().setup();
    driver = new ChromeDriver();
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    driver.manage().window().maximize();
}
        @Test
 public void windowHandle () {
//     Given user is on the https://the-internet.herokuapp.com/windows
         driver.get("https://the-internet.herokuapp.com/windows");
//     Then user verifies the text : “Opening a new window”
       WebElement window1Heading =  driver.findElement(By.xpath("//h3[.='Opening a new window']"));
            Assert.assertEquals("Opening a new window", window1Heading.getText() );
//     Then user verifies the title of the page is “The Internet”
            String window1Title = driver.getTitle();
            Assert.assertEquals("The Internet", window1Title);
//     When user clicks on the “Click Here” button
        driver.findElement(By.linkText("Click Here")).click();

        //Driver is still on the window1
        //1. Get the window 1 handle
       String window1handle =  driver.getWindowHandle();
       //2.Get all window handles
        Set<String> allWindowHandles = driver.getWindowHandles();

        //allWindowHandles has window1 and window2 (this is the one I want to switch)
        //3. Switching the windows using window handles
            for (String eachWindowHandle:allWindowHandles){
                if(!eachWindowHandle.equals(window1handle)){
                    driver.switchTo().window(eachWindowHandle);
                    break;
                }
            }
            /*
             * driver.getWindowHandle();  ->>>>> returns the existing window
             *
             * driver.getWindowHandles(); ->>>>> returns all windows
             *
             * Note that we can not switch the specific window using index,...
             * Logic: Change the window if driver is not on window1
             *
             * if driver is not on window1 : if (!eachWindowHandle.equals(window1Handle))
             * Then switch the other window : driver.switchTo().window(eachWindowHandle);
             */
//     Then user verifies the new window title is “New Window”

           String window2Title = driver.getTitle();
           Assert.assertEquals("New Window", window2Title);
//     Then user verifies the text:  “New Window”
           Assert.assertEquals("New Window",driver.findElement(By.xpath("//h3[.='New Window']")).getText());


           //Getting window 2 handle/ Since driver is on window 2,
            // this returns window 2 handle

            String window2Handle = driver.getWindowHandle();

//     When user goes back to the previous window and then verifies the title : “The Internet”
            driver.switchTo().window(window1handle);
           Assert.assertTrue( driver.getTitle().equals("The Internet"));
            //Driver is on the back window 1

 }
    @After
    public void tearDown(){
   // driver.close();//close only active driver
     driver.quit();//close all open automated drivers
    }
}
