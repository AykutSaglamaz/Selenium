package com.techproed;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Day04_GoogleSearchTest {
/*
Create a new class : GoogleSearchTest
Create main method and complete the following task.
When user goes to https://www.google.com/
Search for “porcelain teapot”
And print how many related results displayed on Google
 */
    WebDriver driver;

  @Before
    public void setUp(){
      WebDriverManager.chromedriver().setup();
      driver = new ChromeDriver();
      //Adding implicit wait
      //wait up to 30 second when NEEDED //This is not like Thread.sleep(3000)
      //This means, if driver needs 1 second wait, then wait will be ONLY 1 second
      /* Why wait is needed?
            - page may be  slow due to lots of image, videos, iframe
            - internet may be slow
            - database may be slow
            - local computer may be slow
       */
      driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

      driver.manage().window().maximize();

  }

  @Test
  public void teaPotSearch(){
      driver.get("https://www.google.com");
      driver.
              findElement(By.xpath("//input[@name='q']")).
              sendKeys("porcelain teapot"+ Keys.ENTER);

      //Printing the number of results
      String resultText = driver.
                                findElement(By.xpath("//div[@id='result-stats']")).
                                getText().
                                substring(6,17);
      System.out.println(resultText);//18,800,000

  }
    @After
    public void tearDown(){
        driver.close();
    }

  }


