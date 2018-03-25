package com.xiebaiyuan.appium.base;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;

import java.net.MalformedURLException;

/**
 * Created by xiebaiyuan on 2018/3/22.
 */

public interface IAppiumTestCase {
    Capabilities initCapabilities();
    WebDriver getMyDriver() throws MalformedURLException;
}
