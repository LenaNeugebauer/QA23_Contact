package com.telran.contacts.fw;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePageHelper extends HelperBase {

    public HomePageHelper(WebDriver driver) {
        super(driver);
    }

    public void isHomeComponentPresent() {
        isElementPresent2(By.cssSelector("div:nth-child(2) > div > div"));
    }
}