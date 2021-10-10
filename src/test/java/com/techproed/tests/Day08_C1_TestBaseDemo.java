package com.techproed.tests;

import com.techproed.utilities.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

/*
test1 search “porcelain teapot” on google
Then verify page contains “porcelain teapot”
——————————-
test2 search “porcelain teapot” on amazon
Then verify page contains “porcelain teapot”
 */
public class Day08_C1_TestBaseDemo extends TestBase {
    //Since I have before-after methods in TestBase, do not use them in here
    // this is a TEST Class and will have only @Test methods
    @Test
    public void test1(){
        driver.get("https://www.google.com");
        driver.
                findElement(By.name("q")).
                sendKeys("porcelain teapot" + Keys.ENTER);
        Assert.assertTrue(driver.getPageSource().contains("porcelain teapot"));
    }

    @Test
    public  void test2(){
        driver.get("https://www.amazon.com");
        driver.
                findElement(By.id("twotabsearchtextbox")).
                sendKeys("porcelain teapot"+ Keys.ENTER);
        Assert.assertTrue(driver.getPageSource().contains("porcelain teapot"));
    }
}
