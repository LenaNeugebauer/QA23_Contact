package com.telran.contacts.tests;

import com.telran.contacts.fw.ApplicationManager;
import org.openqa.selenium.remote.BrowserType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.lang.reflect.Method;
import java.util.Arrays;

public class TestBase {

    protected static ApplicationManager app = new ApplicationManager(System.getProperty("browser", BrowserType.CHROME));

    Logger logger = LoggerFactory.getLogger(TestBase.class);

    // @BeforeSuite
    @BeforeMethod
    public void setUp() {
        app.init();
    }

    @BeforeMethod
    public void startTest(Method m, Object[] p) {

        logger.info("Start test " + m.getName() + " with data: " + Arrays.asList(p));
    }

    @AfterMethod(alwaysRun = false)
    public void stopTest(ITestResult result) {
        if (result.isSuccess()) {
            logger.info("PASSED: test method  " + result.getMethod().getMethodName());
        } else {
            logger.error("FAILED: Test method " + result.getMethod().getMethodName() + "Screenshot: " + app.getUser().takeScreenshot());
        }
        logger.info("*******************************************************");
    }

    //  @AfterSuite(enabled = false)
    @AfterMethod
    public void tearDown() {
        app.stop();
    }

}
