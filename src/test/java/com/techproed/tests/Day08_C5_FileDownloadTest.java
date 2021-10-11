package com.techproed.tests;

import com.techproed.utilities.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;

import java.nio.file.Files;
import java.nio.file.Paths;

/*
Create a class:FileDownloadTest
downloadTest()
In the downloadTest() method, do the following test:
Go to https://the-internet.herokuapp.com/download
Download flower.png file
Then verify if the file downloaded successfully
 */
public class Day08_C5_FileDownloadTest extends TestBase {

    @Test
    public void FileDownloadTest() throws InterruptedException {
//        Go to https://the-internet.herokuapp.com/download
        driver.get("https://the-internet.herokuapp.com/download");
//        Download flower.png file
        driver.findElement(By.linkText("flower.jpeg")).click();

//        Then verify if the file downloaded successfully

        //We must put hard wait since file download take a little bit time
        //Implicit or explicit wait cannot fix the problem, because download folder is windows based application

        Thread.sleep(1000);

        //Getting the PATH of the HOME directory with JAVA
        String homePath = System.getProperty("user.home");// /Users/guler

        //This will be the file name that is downloaded
        String pathOfFLower = homePath+"\\Downloads\\flower.jpeg";//This will

       boolean isDownloaded = Files.exists(Paths.get(pathOfFLower));

        Assert.assertTrue(isDownloaded);

    }

}
