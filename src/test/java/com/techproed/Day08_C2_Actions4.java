package com.techproed;

import com.techproed.utilities.TestBase;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

/*
Create a class: ActionClass4
Create test method : scrollUpDown()
Go to amazon
Scroll the page down
Scroll the page up
 */
public class Day08_C2_Actions4 extends TestBase {
    //Now that we used TESTBASE, we do not use before and after method
//    WebDriver driver;
//
//    @Before
//    public void setUp(){
//        WebDriverManager.chromedriver().setup();
//        driver = new ChromeDriver();
//        driver.manage().window().maximize();
//
//    }
    @Test
    public void scrollUpDown() throws InterruptedException {

        driver.get("https://www.amazon.com");

        Actions actions = new Actions(driver);
        /*
        Page_Down-> scroll down the page
        Arrow_Down -> scroll down the page
        Page_UP-> scroll up
        Arrow_Up -> scroll up
         */
        actions.
                sendKeys(Keys.PAGE_DOWN).//Page_Down-> scroll down the page
                perform();
        actions.
                sendKeys(Keys.PAGE_DOWN).
                perform();// it does twice
        //Arrow_Down scrolls the page down less than Page_Down
        actions.sendKeys(Keys.ARROW_DOWN).perform();
        Thread.sleep(3000);
        actions.sendKeys(Keys.PAGE_UP).perform();
        Thread.sleep(3000);
        /*ARROW_UP moves the page up a little bit*/
        actions.sendKeys(Keys.ARROW_UP).perform();


    }
//@After
//    public void tearDown(){
//        driver.close();
//}

}
