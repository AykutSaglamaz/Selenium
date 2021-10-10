package com.techproed.homework;

import com.github.javafaker.Faker;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;

public class AccountCreationTest {
    /*
    ENTER ALL REQUIRED FIELDS AND VERIFY THE ACCOUNT CREATION IS SUCCESSFUL
1. Create a class SignInHomework
2. Go to http://automationpractice.com/index.php
3. Click on sign in link
4.Send your email and click on create an account button
5.Verify the Text : CREATE AN ACCOUNT
6. Verify the Text : YOUR PERSONAL INFORMATION
7. Verify the Text : Title
8. Select your title
9. Enter your first name
10. Enter your last name
11. Enter your email
12. Enter your password
13. ENTER DATE OF BIRTH
14. Click on Sign up for our newsletter!
15. Enter your first name
16. Enter your last lane
17. Enter your company
18. Enter your Address
19. Enter your City
20. SELECT STATE
21. Enter Postal Code
22.SELECT COUNTRY
23. Enter additional information
24. Enter home phone
25. Enter mobile phone
26. Enter reference name
27. Click Register
20. Then verify MY ACCOUNT is displayed on the home page-SEE BELOW IMAGE
     */
    WebDriver driver;
    Faker faker = new Faker();
    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }
        @Test
        public void SignInHomework () {
        String name = faker.name().firstName();
        String lastname = faker.name().lastName();
        String email = faker.internet().emailAddress();
        String pwd = faker.internet().password();


// 2. Go to http://automationpractice.com/index.php
            driver.get("http://automationpractice.com/index.php");
//3. Click on sign in link
          WebElement signElement = driver.findElement(By.linkText("Sign in"));
            signElement.click();
//4.Send your email and click on create an account button
            driver.findElement(By.xpath("//input[@id='email_create']")).sendKeys(email);
            driver.findElement(By.id("SubmitCreate")).click();
//5.Verify the Text : CREATE AN ACCOUNT
          Assert.assertTrue(driver.findElement(By.xpath("//h1")).isDisplayed());

//6. Verify the Text : YOUR PERSONAL INFORMATION
            Assert.assertTrue(driver.findElement(By.xpath("(//h3)[1]")).isDisplayed());

//7. Verify the Text : Title
            Assert.assertTrue(driver.findElement(By.xpath("//label[.='Title']")).isDisplayed());
//8. Select your title
            WebElement boxMale = driver.findElement(By.xpath("//*[@for='id_gender1']"));
            if (!boxMale.isSelected()) {
                boxMale.click();
            }
//9. Enter your first name
            driver.findElement(By.xpath("//input[@id='customer_firstname']")).sendKeys(name);
//10. Enter your last name
            driver.findElement(By.xpath("//input[@id='customer_lastname']")).sendKeys(lastname);
//11. Enter your email
            driver.findElement(By.xpath("//input[@id='email']")).sendKeys(email);
//12. Enter your password
            driver.findElement(By.xpath("//input[@id='passwd']")).sendKeys(pwd);
//13. ENTER DATE OF BIRTH
          WebElement dropdownD =  driver.findElement(By.id("days"));
            Select selectDay = new Select(dropdownD);
            selectDay.selectByValue("27");

          WebElement dropdownM =  driver.findElement(By.id("months"));
            Select selectMonth = new Select(dropdownM);
            selectMonth.selectByIndex(10);

          WebElement dropdownY = driver.findElement(By.id("years"));
          Select selectYear = new Select(dropdownY);
          selectYear.selectByValue("1999");

//14. Click on Sign up for our newsletter!
            driver.findElement(By.xpath("//input[@id='newsletter']")).click();
//15. Enter your first name
            driver.findElement(By.id("firstname")).sendKeys(name);
//16. Enter your last name
            driver.findElement(By.id("lastname")).sendKeys(lastname);
//17. Enter your company
            driver.findElement(By.id("company")).sendKeys(faker.company().name());
//18. Enter your Address
            driver.findElement(By.id("address1")).sendKeys(faker.address().fullAddress());
//19. Enter your City
            driver.findElement(By.id("city")).sendKeys(faker.address().city());
//20. SELECT STATE
           WebElement state = driver.findElement(By.id("id_state"));
           Select selectState = new Select(state);
           selectState.selectByVisibleText(faker.address().state());
//21. Enter Postal Code
            driver.findElement(By.id("postcode")).sendKeys(faker.address().zipCode());
//22.SELECT COUNTRY
          WebElement country =  driver.findElement(By.id("id_country"));
          Select selectCountry= new Select(country);
          if (!country.isSelected()){
              country.click();
          }
//23. Enter additional information
            driver.findElement(By.id("other")).sendKeys(faker.backToTheFuture().quote());
//24. Enter home phone
            driver.findElement(By.id("phone")).sendKeys(faker.phoneNumber().phoneNumber());
//25. Enter mobile phone
            driver.findElement(By.id("phone_mobile")).sendKeys(faker.phoneNumber().cellPhone());
//26. Enter reference name
            driver.findElement(By.xpath("//input[@id ='alias']")).sendKeys(faker.address().fullAddress());
//27. Click Register
            driver.findElement(By.xpath("//*[@id='submitAccount']")).click();
//20. Then verify MY ACCOUNT is displayed on the home page-SEE BELOW IMAGE
          WebElement myAccount =  driver.findElement(By.linkText("My account"));
//            Assert.assertEquals("MY ACCOUNT", myAccount.getText());
            Assert.assertTrue(myAccount.isDisplayed());
        }

    @After
    public  void closePage(){

       driver.close();
    }
}