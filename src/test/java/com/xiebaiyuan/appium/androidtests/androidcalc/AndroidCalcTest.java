package com.xiebaiyuan.appium.androidtests.androidcalc;

import com.xiebaiyuan.appium.utils.DriverHelper;
import com.xiebaiyuan.appium.base.IAppiumTestCase;
import com.xiebaiyuan.appium.utils.ActionUtil;
import com.xiebaiyuan.appium.utils.ScreenCaptureUtil;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;

import io.appium.java_client.AppiumDriver;

import static org.junit.Assert.assertEquals;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class AndroidCalcTest implements IAppiumTestCase {
//    @Test
//    public void addition_isCorrect() throws Exception {
//        assertEquals(4, 2 + 2);
//    }

    private AppiumDriver mDriver = null;

    @Override
    public DesiredCapabilities initCapabilities() {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(CapabilityType.BROWSER_NAME, "");//这句不是必须的
        capabilities.setCapability("deviceName", "Android Emulator");
        capabilities.setCapability("platformVersion", "7.0");
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("appPackage", "com.android.calculator2");
        capabilities.setCapability("appActivity", ".Calculator");
        return capabilities;
    }

    @Override
    public WebDriver getMyDriver() throws MalformedURLException {
        if (mDriver == null) {
            mDriver = DriverHelper.getAndroidDriver(initCapabilities());
        }
        return mDriver;
    }

    @Test
    public void testForAppium() throws Exception {
        //指定当前的模拟器为测试目标,指定测试应用是  "com.android.calculator2" 计算器
        getMyDriver();
        // 7 + 8
        //点击id 是digit_7的视图
        ActionUtil.clickAnElement(mDriver, "digit_7");
        //点击+
        ActionUtil.clickAnElement(mDriver, "op_add");
        //点击8
        ActionUtil.clickAnElement(mDriver, "digit_8");
        //点击=
        ActionUtil.clickAnElement(mDriver, "eq");


        // WebElement result = ActionUtil.getWebElement(driver);

        //获取结果
        String result = ActionUtil.getWebElementText(mDriver, "result");

        //打个log看下-->当然无所谓,不打也ok
        System.out.println("result: " + result);

        //断言我操作的结果应该是
        assertEquals(result, String.valueOf(7 + 8));//断言这个结果 是 7+8=15

        //截个图
        ScreenCaptureUtil.screenShotDefault(mDriver, "haha");


    }

    /**
     * 尝试下longpress
     * @throws Exception
     */
    @Test
    public void testCopyResult() throws Exception {
        getMyDriver();
        testForAppium();

        ActionUtil.longPressElement(mDriver, "result");
    }
    /**
     * 尝试下longpress
     * @throws Exception
     */
    @Test
    public void testSwip() throws Exception {
        getMyDriver();
        //从扩展功能的位置滑动到4的位置.
        ActionUtil.swipToTarget(mDriver,"pad_advanced","digit_4");
    }

}