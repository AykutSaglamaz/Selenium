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
Create a class: IFrameTest
Create a method: iframeTest
Go to https://the-internet.herokuapp.com/iframe
Verify the Bolded text contains “Editor”
Locate the text box
Delete the text in the text box
Type “This text box is inside the iframe”
Verify the text Elemental Selenium text is displayed on the page
 */
public class Day06_C2_IFrame {
    WebDriver driver;
    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/iframe");
    }
    @Test
    public void iframeTest(){
 //    Create a class: IFrameTest
//    Create a method: iframeTest
//    Go to https://the-internet.herokuapp.com/iframe
//    Verify the Bolded text contains “Editor”
      String actualBoldedText =  driver.findElement(By.xpath("//h3")).getText();
      String expected ="Editor";
        Assert.assertTrue(actualBoldedText.contains(expected));
//    Locate the text box
        //1. way Switching to iframe by index - index starts from 0
//        driver.switchTo().frame(0);

        //2.way Switching iframe by id/name
    //    This iframe has id, then I can pass value of id and switch to the iframe
       /*  <iframe
                id="mce_0_ifr"
        frameborder="0"
        allowtransparency="true"
        title="Rich Text Area. Press ALT-0 for help."
        class="tox-edit-area__iframe"></iframe>
          */

//        driver.switchTo().frame("mce_0_ifr");

        //3.way
        //Switch iframe by WebElement
        WebElement iframeElement = driver.findElement(By.xpath("//iframe[@id='mce_0_ifr']"));
        driver.switchTo().frame(iframeElement);

        //Note //p element is inside the iframe
        WebElement textbox = driver.findElement(By.xpath("//p"));
 //    Delete the text in the text box
        //clear() -> deleting the existing text
        textbox.clear();
//    Type “This text box is inside the iframe”
        textbox.
                sendKeys("This text box is inside the iframe");
        //at this point my driver is INSIDE the IFRAME

//    Verify the text Elemental Selenium text is displayed on the page
        //Elemental Selenium is OUTSIDE of the IFRAME
        // switch to the parent frame

        driver.switchTo().parentFrame();// -> go to parent frame

       WebElement elementSelenium = driver.findElement(By.linkText("Elemental Selenium"));
        Assert.assertTrue(elementSelenium.isDisplayed());

    }

@After
    public void tearDown(){
    //    driver.close();
}

}
