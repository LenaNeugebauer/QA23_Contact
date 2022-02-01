package com.telran.contacts;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class OpenHomePageTests extends TestBase {

    @Test
    public void  openHomePageTest(){
        System.out.println("opened home page");
        //check to displayed Home Component form
        //driver.findElement(By.cssSelector("div:nth-child(2) > div > div"));
        isElementPresent2(By.cssSelector("div:nth-child(2) > div > div"));
        System.out.println("Home Component: " + isElementPresent2(By.cssSelector("div:nth-child(2) > div > div")));
    }

    public boolean isHomeComponentPresent(){
        return isElementPresent(By.cssSelector("div:nth-child(2) > div > div"));
    }

    // css: div:nth-child(2) > div > div   xPath: //div[@id='root']/div[2]/div/div

    public boolean isHomeComponentPresent2() {
        return isElementPresent2(By.cssSelector("div:nth-child(2) > div >div"));
    }

}

