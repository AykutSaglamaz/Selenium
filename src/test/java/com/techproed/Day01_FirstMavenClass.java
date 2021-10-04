package com.techproed;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Day01_FirstMavenClass {
    public static void main(String[] args) {
        //No longer System.setPropert("webdriver.chrome.driver","path of driver)

        //1. Set up the chrome driver
        WebDriverManager.chromedriver().setup();

        //2. Create driver
        WebDriver driver=new ChromeDriver();

        //3. Write your automation script
        driver.manage().window().maximize();

        driver.get("https://www.amazon.com");
        driver.close();

    }

}
