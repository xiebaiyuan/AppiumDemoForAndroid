package com.xiebaiyuan.appiumdemo;


import org.openqa.selenium.By;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.AndroidKeyCode;

/**
 * Created by WANGQINGBIN on 2017/2/10.
 */

public class AppiumUtils {

    /**
     * 判断一个元素是否存在
     *
     * @param driver
     * @param by
     * @return boolean
     */
    public static boolean isElememtExist(AndroidDriver<AndroidElement> driver, By by) {
        try {
            driver.findElement(by);
            return true;
        } catch (Exception e) {
            // TODO: handle exception
            return false;
        }
    }

    /**
     * 获取输入框的text文本
     * 将光标置于输入框的最后
     * 根据文本长度循环调用物理键盘删除操作，逐个字符进行删除; 对于密码输入框无效
     *
     * @param driver
     * @param ele
     * @throws Exception
     * @throws Exception
     */
    public static void clear(AndroidDriver<AndroidElement> driver, AndroidElement ele) throws Exception {
        ele.click();
        String text = ele.getText();
        //将光标置于最后
        driver.pressKeyCode(AndroidKeyCode.KEYCODE_MOVE_END);
        for (int i = 0; i < text.length(); i++) {
            Thread.sleep(200);
            driver.pressKeyCode(AndroidKeyCode.BACKSPACE);
        }
    }

    /**
     * 清除并输入
     *
     * @param driver
     * @param by
     * @param value
     * @throws Exception
     */
    public static void clearAndSendkeys(AndroidDriver<AndroidElement> driver, By by, String value) throws Exception {
        AndroidElement ele = driver.findElement(by);
        ele.click();
        String text = ele.getText();
        //将光标置于最后
        driver.pressKeyCode(AndroidKeyCode.KEYCODE_MOVE_END);
        for (int i = 0; i < text.length(); i++) {
            Thread.sleep(200);
            driver.pressKeyCode(AndroidKeyCode.BACKSPACE);
        }
        ele.sendKeys(value);
    }

    /**
     * 针对密码输入框clear不干净时使用
     *
     * @param driver
     * @param ele
     * @throws Exception
     */
    public static void clearWithPwd(AndroidDriver<AndroidElement> driver, AndroidElement ele) throws Exception {
        ele.click();
        //将光标置于最后
        driver.pressKeyCode(AndroidKeyCode.KEYCODE_MOVE_END);
        for (int i = 0; i < 20; i++) {
            Thread.sleep(200);
            driver.pressKeyCode(AndroidKeyCode.BACKSPACE);
        }
    }

    /**
     * 向上滑动
     *
     * @param driver
     * @param duration
     */

    public static void swipeToUp(AndroidDriver<AndroidElement> driver, int duration) {
        int x = driver.manage().window().getSize().getWidth();
        int y = driver.manage().window().getSize().getHeight();
        driver.swipe(x / 2, 8 * y / 10, x / 2, y / 10, duration);
    }

    /**
     * 向下滑动
     *
     * @param driver
     * @param duration
     */
    public static void swipeToDown(AndroidDriver<AndroidElement> driver, int duration) {
        int x = driver.manage().window().getSize().getWidth();
        int y = driver.manage().window().getSize().getHeight();
        driver.swipe(x / 2, y / 10, x / 2, 8 * y / 10, duration);
    }

    /**
     * 向左滑动
     *
     * @param driver
     * @param duration
     */
    public static void swipeToLeft(AndroidDriver<AndroidElement> driver, int duration) {
        int x = driver.manage().window().getSize().getWidth();
        int y = driver.manage().window().getSize().getHeight();
        driver.swipe(8 * x / 10, y / 2, x / 10, y / 2, duration);
    }

    /**
     * 向右滑动
     *
     * @param driver
     * @param duration
     */
    public static void swipeToRight(AndroidDriver<AndroidElement> driver, int duration) {
        int x = driver.manage().window().getSize().getWidth();
        int y = driver.manage().window().getSize().getHeight();
        driver.swipe(x / 10, y / 2, 8 * x / 10, y / 2, duration);
    }

    /**
     * 总的滑动方法
     *
     * @param driver
     * @param direction
     * @param duration
     */

    public static void swipe(AndroidDriver<AndroidElement> driver, String direction, int duration) {
        switch (direction.toLowerCase()) {
            case "up":
                swipeToUp(driver, duration);
                break;
            case "down":
                swipeToDown(driver, duration);
                break;
            case "left":
                swipeToLeft(driver, duration);
                break;
            case "right":
                swipeToRight(driver, duration);
                break;
            default:
                System.out.println("方向参数不对，只能是up、down、left、right");
                break;
        }
    }
}