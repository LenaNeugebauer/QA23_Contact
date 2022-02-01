package com.telran.contacts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

public class TestBase {
    WebDriver driver;

    @BeforeMethod
    public void setUp(){
        driver = new ChromeDriver();
        driver.get("https://contacts-app.tobbymarshall815.vercel.app");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @AfterMethod(enabled = false)
    public void tearDown(){
        driver.quit();
    }

    public boolean isElementPresent(By locator){
        return driver.findElements((locator)).size()>0;
    }

    public boolean isElementPresent2(By by) {
        try {
            driver.findElement(by);
            return true;
        }catch (NoSuchElementException ex){
            return false;
        }
    }

    public void isSignOutButtonPresent() {
        Assert.assertTrue(isElementPresent(By.xpath("//button[contains(.,'Sign Out')]")));
    }

    public void isRegistrationFormPresent() {
        Assert.assertTrue(isElementPresent2(By.cssSelector(".login_login__3EHKB")));
    }

    public void type(By locator, String text) {
        driver.findElement(locator).click();
        driver.findElement(locator).clear();
        driver.findElement(locator).sendKeys(text);
    }

    public void click(By locator){
            driver.findElement(locator).click();
        }

    public void fillRegistrationLoginForm(String email, String password) {
        type(By.cssSelector("[placeholder='Email']"), email);
        type(By.cssSelector("[placeholder='Password']"), password);
    }
}
