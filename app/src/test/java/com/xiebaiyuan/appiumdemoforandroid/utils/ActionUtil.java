package com.xiebaiyuan.appiumdemoforandroid.utils;

import org.openqa.selenium.WebElement;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;

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
     * @param elementId
     *
     * @return
     */
    public static WebElement getWebElement(AppiumDriver driver,String elementId) {
        return driver.findElementById(elementId);
    }

    /**
     * 获取某个视图上的text
     *
     * @param driver
     * @return
     */
    public static String getWebElementText(AppiumDriver driver,String elementId) {
        return getWebElement(driver,elementId).getText();
    }

    /**
     * 长按
     * @param driver
     */
    public static void longPressElement(AppiumDriver driver,String elementId){
        new TouchAction(driver).longPress(getWebElement(driver,elementId)).perform();
    }

}
