package com.techproed;

import com.github.javafaker.Faker;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;
/*
Complete the following task.
Go to https://www.facebook.com/
Click on Create an Account button
Locate the elements of radio buttons
Then click on the radio buttons for your gender if they are not selected
 */
public class Day05_C2_RadioButton {

    WebDriver driver;
    Faker faker = new Faker();
    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }
    @Test
    public void radiobutton() throws InterruptedException {
//        Go to https://www.facebook.com/

        driver.get("https://www.facebook.com/");
//        Click on Create an Account button
        driver.findElement(By.linkText("Create New Account")).click();
//  Entering required fields
        driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys(faker.name().firstName());
        driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys(faker.name().lastName());
        driver.findElement(By.xpath("//input[@name='reg_email__']")).sendKeys(faker.internet().emailAddress());

        driver.findElement(By.xpath("//input[@name='reg_email_confirmation__']")).sendKeys(faker.internet().emailAddress());
        driver.findElement(By.xpath("//input[@name='reg_passwd__']")).sendKeys(faker.internet().password());

        //Oct 10 1990
        //Locating the month
        WebElement month = driver.findElement(By.xpath("//select[@id='month']"));
        Select select = new Select(month);
        select.selectByVisibleText("Oct");
        //Locating the day
        WebElement day = driver.findElement(By.xpath("//select[@id='day']"));
        Select dayDropdown = new Select(day);
        dayDropdown.selectByVisibleText("10");
        //Locating the year
        WebElement year = driver.findElement(By.xpath("//select[@id='year']"));
        Select yearDropdown = new Select(year);
        yearDropdown.selectByVisibleText("1990");

    //   Locate the elements of radio buttons
        WebElement maleOption= driver.findElement(By.xpath("(//input[@type='radio' and @value='2'])"));
//        WebElement femaleOption= driver.findElement(By.xpath("(//input[@type='radio' and @value='1'])"));

//        Then click on the radio buttons for your gender if they are not selected
        if (!maleOption.isSelected()){
            maleOption.click();
        }
        Thread.sleep(1000);
        driver.findElement(By.xpath("//button[@name='websubmit']")).click();

    }
    @After
    public void tearDown(){
        driver.close();
    }

}
