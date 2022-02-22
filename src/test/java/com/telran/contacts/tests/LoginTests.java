package com.telran.contacts.tests;

import com.telran.contacts.model.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.awt.*;
import java.io.IOException;


public class LoginTests extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() {
        //click on Login tab
        app.getUser().clickOnLoginTab();
        if (!app.getUser().isRegistrationLoginFormPresent()) {
            app.getHeader().clickOnSignOutButton();
        }
    }

    @Test(priority = 1)
    public void loginRegisteredUserPositiveTest() {
        //fill login form
        app.getUser().fillRegistrationLoginForm(new User().setEmail("karl+1@gmail.com").setPassword("Ka1234567$"));
        //click on Login button
        app.getUser().clickOnLoginButton();
        //Assert: User logged in
        Assert.assertTrue(app.getHeader().isContactTabPresent());
    }

    @Test(enabled = false)
    public void loginRegisteredUserPositiveTestWithScreenCast() throws IOException, AWTException {
        app.getUser().deleteScreenCast("record");
        app.getUser().startRecording();
        app.getUser().fillRegistrationLoginForm(new User().setEmail("karl+1@gmail.com").setPassword("Ka1234567$"));

        app.getUser().clickOnLoginButton();
        app.getUser().pause(4000);
        app.getUser().stopRecording();
    }

    @Test(priority = 2)
    public void loginRegisteredUserNegativeTest() {
        //   click(By.xpath("//a[contains(.,'LOGIN')]"));
        app.getUser().fillRegistrationLoginForm(new User().setEmail("karl+1@gmail.com").setPassword("Ka1234567"));
        app.getUser().clickOnLoginButton();
        Assert.assertTrue(app.getUser().isAlertPresent());
        //assert 'Login Failed with code 400' displayed
    }


}