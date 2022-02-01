package com.telran.contacts;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTests extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() {
        if (!isElementPresent(By.xpath(".login_login_3EHKB"))) {
            driver.findElement(By.xpath("//button[contains(.,'Sign Out')]"));
        }
    }

    @Test
        public void loginRegisteredUserPositiveTest() {
            //click on Login tab
            click(By.xpath("//a[contains(.,'LOGIN')]"));
            //fill login form
            fillRegistrationLoginForm("karl+1@gmail.com","Ka1234567$");
            //click on Login button
            click(By.xpath("//button[contains(.,'Login')]"));
            //Assert: User logged in
            Assert.assertTrue(isElementPresent(By.xpath("//a[contains(.,'Contacts')]")));

    }

}

