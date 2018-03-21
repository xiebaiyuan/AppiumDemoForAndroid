package com.xiebaiyuan.appiumdemoforandroid.utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.Augmenter;

import java.io.File;

import io.appium.java_client.AppiumDriver;

/**
 * Created by xiebaiyuan on 2018/3/22.
 */

public class ScreenCaptureUtil {
    static String MY_CAP_PATH = "/Users/xiebaiyuan/AndroidStudioProjects/AppiumDemoForAndroid/screenCap/";

    public static void screenShot2(AppiumDriver driver, String desfilepath) {
        // final String desfilepath = "/Users/zhoutu/Desktop/zyj/aaa.png";
        // make screenshot and get is as base64
        final WebDriver augmentedDriver = new Augmenter().augment(driver);
        ((TakesScreenshot) augmentedDriver).getScreenshotAs(OutputType.BASE64);
        // make screenshot and save it to the local filesystem
        final File srcfile = ((TakesScreenshot) augmentedDriver)
                .getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(srcfile, FileUtils.getFile(desfilepath), true);
        } catch (final Exception e) {
            System.out.println(e.toString() + "\n");
        }

    }


    public static void screenShotDefault(AppiumDriver driver, String filename) {
        screenShot2(driver, MY_CAP_PATH + DateUtils.getSDFTimeYMdHm() + "_" + filename + ".png");
    }

}
