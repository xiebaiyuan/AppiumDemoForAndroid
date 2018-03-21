package com.xiebaiyuan.appiumdemoforandroid;

import android.support.annotation.NonNull;

import com.xiebaiyuan.appiumdemoforandroid.utils.ActionUtil;

import org.junit.Test;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import io.appium.java_client.AppiumDriver;

import static org.junit.Assert.assertEquals;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() throws Exception {
        assertEquals(4, 2 + 2);
    }


    @Test
    public void testForAppium() throws Exception {
        //指定当前的模拟器为测试目标,指定测试应用是  "com.android.calculator2" 计算器
        AppiumDriver driver = getAndroidDriver();

        // 7 + 8
        //点击id 是digit_7的视图
        ActionUtil.clickAnElement(driver,"digit_7");
        //点击+
        ActionUtil.clickAnElement(driver,"op_add");
        //点击8
        ActionUtil.clickAnElement(driver,"digit_8");
        //点击=
        ActionUtil.clickAnElement(driver,"eq");


       // WebElement result = ActionUtil.getWebElement(driver);

        //获取结果
        String result = ActionUtil.getWebElementText(driver);

        //打个log看下-->当然无所谓,不打也ok
        System.out.println("result: "+result);

        //断言我操作的结果应该是
        assertEquals(result,String.valueOf(7+8));//断言这个结果 是 7+8=15



    }


    // TODO: 2018/3/22  这个东西放在哪里呢?  容我想想
    @NonNull
    private AppiumDriver getAndroidDriver() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(CapabilityType.BROWSER_NAME, "");//这句不是必须的
        capabilities.setCapability("deviceName", "Android Emulator");
        capabilities.setCapability("platformVersion", "7.0");
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("appPackage", "com.android.calculator2");
        capabilities.setCapability("appActivity", ".Calculator");
        return new AppiumDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
    }
}