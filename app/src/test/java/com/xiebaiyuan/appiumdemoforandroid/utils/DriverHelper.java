package com.xiebaiyuan.appiumdemoforandroid.utils;

import android.support.annotation.NonNull;

import com.xiebaiyuan.appiumdemoforandroid.Config;

import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;

/**
 * Created by xiebaiyuan on 2018/3/22.
 */

public class DriverHelper {

    @NonNull
    public static AppiumDriver getAndroidDriver(DesiredCapabilities capabilities) throws MalformedURLException {
        return new AndroidDriver(new URL(Config.DEFAULT_URL), capabilities);
    }
}
