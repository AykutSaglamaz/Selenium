package com.techproed.tests;

import com.techproed.utilities.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class Day09_C3_Javascript_Executor extends TestBase {

    /*
    JavaScript Executor can be used to handle some browser events
    - scroll up/down/right/left
    - scroll into an element
    - click
    - generate alert
    - change the color
    NOTE: scrollIntoView method scroll to the desired element
    It automatically scrolls to the element
    If the element is at the bottom, this scrolls to the bottom
    If element is at the right, this scrolls to the right
     */


    @Test
    public void scrollIntoView() throws InterruptedException {
        driver.get("http://www.carettahotel.com/");

        /*
        * Given user is on the application url
        * Then verify the text "Recent Blog" is on the page
        */

        //Creating javascript executor object
        JavascriptExecutor je = (JavascriptExecutor) driver;

        //We will scroll down to this element
        WebElement resentBlog = driver.findElement(By.xpath("//*[.='Recent Blog']"));

        //Scrolling down to the element using scrollIntoView(true) method
        je.executeScript("arguments[0].scrollIntoView(true);",resentBlog);

        //Waiting for 3 second for the element text
        Thread.sleep(3000);

        Assert.assertEquals(resentBlog.getText(),"Recent Blog");
    }
}
