package com.telran.contacts.tests;

import com.telran.contacts.tests.TestBase;
import org.openqa.selenium.By;
import org.testng.annotations.Test;


public class HeaderTests extends TestBase {

    @Test
    public void clickOnTheButtonHome() {
        //click on home tab
        app.getHeader().click(By.xpath("//a[contains(text(),'HOME')]"));
    }

    @Test
    public void clickOnTheButtonAbout() {
        //click on about tab
        app.getHeader().click(By.xpath("//a[contains(text(),'ABOUT')]"));
    }
}
