package com.telran.contacts.tests;

import com.telran.contacts.model.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CreateAccountTests extends TestBase{
    //preconditions: user should be logged out
    @BeforeMethod
    public void ensurePreconditions() {
        //Login tab not present
        if (!app.getHeader().isLoginTabPresent()) {
            //click on Log out button
            app.getHeader().clickOnSignOutButton();
        }
    }

    @Test(enabled = false)
    public void registrationPositiveTest() {
        //test: click on login tab
        app.getUser().clickOnLoginTab();
        app.getUser().isRegistrationFormPresent();
        //fill registration form
        app.getUser().fillRegistrationLoginForm(new User().setEmail("karl+1@gmail.com").setPassword("Ka1234567$"));
        //click on Registration button
        app.getUser().clickOnRegistrationButton();
        //check Log out button displayed
        app.getHeader().isSignOutButtonPresent();
    }

    @Test
    public void registrationNegativeWithoutPasswordTest() {
        //test: click on login tab
        app.getUser().clickOnLoginTab();
        app.getUser().isRegistrationFormPresent();
        //fill registration form
        app.getUser().fillRegistrationLoginForm(new User().setEmail("karl+1@gmail.com"));
        //click on Registration button
        app.getUser().clickOnRegistrationButton();
        //check Log out button displayed
        Assert.assertTrue(app.getUser().isAlertPresent());
    }

}
