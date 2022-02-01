package com.telran.contacts;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CreateAccountTests extends TestBase{

        //preconditions: user should be logged out
        @BeforeMethod
        public void ensurePreconditions() {
            //Login tab not present
            if (!isElementPresent(By.xpath("//a[contains(.,'LOGIN')]"))) {
                //click on Log out button
                driver.findElement(By.xpath("//button[contains(.,'Sign Out')]"));
            }
        }

        @Test
        public void registrationPositiveTest() {
            //test: click on login tab
            click(By.xpath("//a[contains(.,'LOGIN')]"));
            isRegistrationFormPresent();
            //fill registration form
            fillRegistrationLoginForm("karl+1@gmail.com", "Ka1234567$");
            //click on Registration button
            click(By.xpath("//button[contains(.,' Registration')]"));
            //check Log out button displayed
            isSignOutButtonPresent();
        }

}
