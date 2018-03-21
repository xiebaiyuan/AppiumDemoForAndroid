package com.xiebaiyuan.appiumdemoforandroid.utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;

import java.io.File;
import java.io.IOException;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;

/**
 * Created by xiebaiyuan on 2018/3/22.
 */

public class ScreenCaptureUtil {
    static String MYCAP_PATH = "~/AndroidStudioProjects/AppiumDemoForAndroid/screenCap";

    public static void screenShot(AppiumDriver driver, String sFilePath) {
        File file = new File(sFilePath);
        // 如果截图存在先删除
        try {
            if (file.exists()) {
                file.delete();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        // 截图
        File newFile = driver.getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(newFile, file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void screenShotDefault(AppiumDriver driver) {
        screenShot(driver,MYCAP_PATH);
    }

}
