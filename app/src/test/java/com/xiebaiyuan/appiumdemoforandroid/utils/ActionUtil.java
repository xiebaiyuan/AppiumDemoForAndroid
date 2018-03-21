package com.xiebaiyuan.appiumdemoforandroid.utils;

import org.openqa.selenium.WebElement;

import io.appium.java_client.AppiumDriver;

/**
 * Created by xiebaiyuan on 2018/3/22.
 */

public class ActionUtil {
    /**
     * 点击某个视图
     *
     * @param driver
     * @param elementId
     */
    public static void clickAnElement(AppiumDriver driver, String elementId) {
        WebElement element = driver.findElementById(elementId);
        element.click();
    }

    /**
     * 获取某个视图
     *
     * @param driver
     * @return
     */
    public static WebElement getWebElement(AppiumDriver driver) {
        return driver.findElementById("result");
    }

    /**
     * 获取某个视图上的text
     *
     * @param driver
     * @return
     */
    public static String getWebElementText(AppiumDriver driver) {
        return getWebElement(driver).getText();
    }
}
