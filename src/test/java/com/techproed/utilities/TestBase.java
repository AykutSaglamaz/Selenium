package com.techproed.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public abstract class TestBase {
    //Making TestBase abstract because we do not want to create an object of TestBase class
    //we want to use the objects or methods in this class by extending it
   protected WebDriver driver;

    @Before
    public  void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);// this must be used. preferrable
        driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);//just wait for page load-> optional
    }

    @After
    public void tearDown(){
      driver.close();
    }
}
