package com.telran.contacts.fw;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class HeaderHelper extends HelperBase {

    public HeaderHelper(WebDriver driver) {
        super(driver);
    }

    public boolean isSignOutButtonPresent() {
        Assert.assertTrue(isElementPresent(By.xpath("//button[contains(.,'Sign Out')]")));
        return false;
    }

    public boolean isSignOutBtnPresent() {
        return isElementPresent(By.xpath("//button[contains(.,'Sign Out')]"));
    }

    public void clickOnSignOutButton() {
        click(By.xpath("//button[contains(.,'Sign Out')]"));
    }

    public boolean isLoginTabPresent() {
        return isElementPresent(By.xpath("//a[contains(.,'LOGIN')]"));
    }



    public boolean isContactTabPresent() {
        return isElementPresent(By.xpath("//a[contains(.,'CONTACTS')]"));
    }
}