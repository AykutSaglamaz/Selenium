package com.techproed.tests;

import com.techproed.utilities.TestBase;
import org.junit.Test;
import org.openqa.selenium.Cookie;

import java.util.Set;

/*
Class: Day09_Cookies
Method: handleCookies
-Go to amazon  and automate the tasks
1. Find the total number of cookies
2. Print all the cookies
3. Get the cookies by their name
4. Add new cookie
5. Delete cookie by name
6. Delete all of the cookies
 */
public class Day09_C2_Cookies extends TestBase {

    @Test
    public void handleCookies(){
//        -Go to amazon  and automate the tasks
        driver.get("https://www.amazon.com");
//        1. Find the total number of cookies
        // getCookies() returns all of the cookies in the browser
      Set<Cookie> allCookies = driver.manage().getCookies();
      int numOfCookies = allCookies.size();
        System.out.println("Number of Cookies => "+ numOfCookies);

//        2. Print all the cookies
        for (Cookie eachCookie : allCookies){
            System.out.println("Cookie Names => "+eachCookie.getName());
            System.out.println("Cookie Value => "+ eachCookie.getValue());
        }

//        3. Get the cookies by their name
        System.out.println("Cookie name i18n-prefs => "+driver.manage().getCookieNamed("i18n-prefs"));
//        4. Add new cookie

        Cookie myCookie = new Cookie("My favorite Cookie", "Cookie Monster 1");
        driver.manage().addCookie(myCookie);

        //getting all cookies
        allCookies = driver.manage().getCookies();
        //printing the total number of cookies
        System.out.println("Number of Cookies "+ allCookies.size());//9

//        5. Delete cookie by name
        driver.manage().deleteCookieNamed("session-token");
        allCookies = driver.manage().getCookies();
        System.out.println("Number Of Cookie => "+allCookies.size());//8


//        6. Delete all of the cookies
        driver.manage().deleteAllCookies();
        allCookies = driver.manage().getCookies();
        System.out.println("Number Of Cookie => "+allCookies.size());//0

    }
}
