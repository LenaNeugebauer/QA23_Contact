package com.telran.contacts.fw;

import com.google.common.io.Files;
import org.monte.media.Format;
import org.monte.media.FormatKeys;
import org.monte.media.math.Rational;
import org.monte.screenrecorder.ScreenRecorder;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.*;
import java.io.File;
import java.io.IOException;

import static org.monte.media.FormatKeys.*;
import static org.monte.media.VideoFormatKeys.*;

public class HelperBase {
    //  static WebDriver driver;
    WebDriver driver;

    public HelperBase(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isElementPresent(By locator) {
        return driver.findElements(locator).size() > 0;
    }

    public boolean isElementPresent2(By by) {
        try {
            driver.findElement(by);
            return true;
        } catch (NoSuchElementException ex) {
            return false;
        }
    }

    public void type(By locator, String text) {
        if (text != null) {
            driver.findElement(locator).click();
            driver.findElement(locator).clear();
            driver.findElement(locator).sendKeys(text);
        }
    }

    public void click(By locator) {
        driver.findElement(locator).click();
    }

    public boolean isAlertPresent() {
        Alert alert = new WebDriverWait(driver, 20).until(ExpectedConditions.alertIsPresent());
        if (alert == null) {
            return false;
        } else {
            driver.switchTo().alert();
            alert.accept();
            return true;
        }
    }

    public void jumpToFooter(By locator) {
        driver.findElement(locator).sendKeys(Keys.CONTROL, Keys.END);
    }

    public void clickWithActions(By save) {

        Actions actions = new Actions(driver);
        WebElement element = driver.findElement(save);

        actions.moveToElement(element).build().perform();
        element.click();
    }

    public void isElementVisible(By locator, int time) {
        new WebDriverWait(driver, time).until(ExpectedConditions.visibilityOf(driver.findElement(locator)));
    }

    public boolean isTextContainsInElement(By locator, int time, String text) {
        return new WebDriverWait(driver, time).until(ExpectedConditions.textToBePresentInElement(driver.findElement(locator), text));
    }

    public void pause(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public String takeScreenshot() {

        File tmp = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

        File screenshot = new File("screenshots/screen-" + System.currentTimeMillis() + ".png");
        try {
            Files.copy(tmp, screenshot);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return screenshot.getAbsolutePath();
    }

    private ScreenRecorder screenRecorder;

    public void startRecording() throws IOException, AWTException {

        File file = new File("record");

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

        int width = screenSize.width;
        int height = screenSize.height;

        Rectangle captureSize = new Rectangle(0, 0, width, height);

        GraphicsConfiguration gc = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().getDefaultConfiguration();

        screenRecorder = new Recorder(gc, captureSize, new Format(MediaTypeKey, FormatKeys.MediaType.FILE, MimeTypeKey, MIME_AVI),
                new Format(MediaTypeKey, MediaType.VIDEO, EncodingKey, ENCODING_AVI_MJPG, CompressorNameKey, ENCODING_AVI_MJPG, DepthKey, 24, FrameRateKey,
                        Rational.valueOf(15), QualityKey, 1.0f, KeyFrameIntervalKey, 15 * 60),
                new Format(MediaTypeKey, MediaType.VIDEO, EncodingKey, "black", FrameRateKey, Rational.valueOf(30)), null, file, "MyVideo");
        screenRecorder.start();
    }

    public void stopRecording() throws IOException {
        screenRecorder.stop();
    }

    public void deleteScreenCast(String path) {
        File directory = new File(path);
        File[] files = directory.listFiles();
        for (File f: files) {
            f.delete();
        }
    }
}