package com.telran.contacts;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;


public class HeaderTests extends TestBase{

    @Test
    public void clickOnTheButtonHome() {
        //click on home tab
        click(By.xpath("//a[contains(text(),'HOME')]"));
    }

    @Test
    public void clickOnTheButtonAbout() {
        //click on about tab
        click(By.xpath("//a[contains(text(),'ABOUT')]"));
    }
}
