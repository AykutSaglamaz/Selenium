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

import java.util.List;

/*
Create a class : LocatorsIntro
Create main method and complete the following task.
user goes to http://a.testaddressbook.com/sign_in
Locate the elements of email textbox, password textbox, and signin button
Enter below username and password then click sign in button
Username :  testtechproed@gmail.com
Password : Test1234!
Then verify that the expected user id  testtechproed@gmail.com (USE getText() method to get the text from the page)
Verify the Addresses and Sign Out  texts are displayed
Find the number of total link on the page
Sign out from the page
 */
public class Day02_C3_Locators {
    WebDriver driver;

    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();

    }

    @Test
    public void locators(){
        driver.get("http://a.testaddressbook.com/sign_in");
//        driver
//                .findElement(By.id("session_email"))//Locating the element by id
//                .sendKeys("testtechproed@gmail.com");//typing in the element
        //OR: Return typed of findElement is WebElement
        WebElement emailBox=driver.findElement(By.id("session_email"));
        emailBox.sendKeys("testtechproed@gmail.com");
        // Password by name
        driver.findElement(By.name("session[password]")).sendKeys("Test1234!");

        // Locating sign in button and click on it
        driver.findElement(By.name("commit")).click();


        // then verify that the expected user id

        WebElement userId = driver.findElement(By.className("navbar-text"));
//        System.out.println(userId);// [[ChromeDriver: chrome on WINDOWS (83f647c51744ce1fb54fe3910f6a12ac)] -> class name: navbar-text]
//
//        //getText(); return the test of the WebElements. Return type is a String
//        String userIdText = userId.getText();
//        System.out.println(userIdText);//testtechproed@gmail.com

        //Or
       String userIdText = driver.findElement(By.className("navbar-text")).getText();
       String expectedUserId="testtechproed@gmail.com";
       Assert.assertEquals(expectedUserId,userIdText);

       //Verify the Addresses and Sign Out  texts are displayed
    WebElement addressesElement =  driver.findElement(By.linkText("Addresses"));
    // isDisplayed() method is used to verify if an element is on the page or not
        //Return type is boolean
        //Return true if element is on the page
        //Return false if element is not on the page
    Assert.assertTrue(addressesElement.isDisplayed());
       // System.out.println(addressesElement.isDisplayed());

        //Sign out element is displayed on the page or not
       WebElement signOutElement = driver.findElement(By.partialLinkText("Sign out"));
      //  WebElement signOutElement = driver.findElement(By.partialLinkText("gn out"));
       Assert.assertTrue(signOutElement.isDisplayed());
/*
    What is the difference between LinkText() and partialLinkText()
    - linkText -> we must give the entire text with extra spaces and all
    - partialLinkText-> we can give the entire text or part of the text
    - linkText is safer, since you have to put the original text
 */
       // Find the number of total link on the page
        //Links are created by 'a' tag, so we can find all links by finding all elements with 'a' tag
        List<WebElement> allLinks= driver.findElements(By.tagName("a"));
        int linkSize = allLinks.size();
        System.out.println("The size of all Links is : "+linkSize);

       // Sign out from the page
        driver.findElement(By.linkText("Sign out")).click();

        //verify if the sign out is successful
        boolean isLoggedOut = driver.
                                    getCurrentUrl().
                                    equals("http://a.testaddressbook.com/sign_in");
        Assert.assertTrue(isLoggedOut);

    }
    @After
    public void tearDown(){
        driver.close();
    }
}
