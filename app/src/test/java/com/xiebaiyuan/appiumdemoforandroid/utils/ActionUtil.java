package com.xiebaiyuan.appiumdemoforandroid.utils;

import org.openqa.selenium.WebElement;

import io.appium.java_client.AppiumDriver;

/**
 * Created by xiebaiyuan on 2018/3/22.
 */

public class ActionUtil {
    public static void clickAnElement(AppiumDriver driver,String elementId) {
        WebElement digit_7 = driver.findElementById(elementId);
        digit_7.click();
    }
}
