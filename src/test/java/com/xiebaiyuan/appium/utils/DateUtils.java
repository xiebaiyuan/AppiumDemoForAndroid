package com.xiebaiyuan.appium.utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Created by xiebaiyuan on 2018/3/22.
 */

public class DateUtils {
    /**
     * @return yyyy-MM-dd HH:mm    2016-08-12 15:44
     */
    public static String getSDFTimeYMdHm() {
        String format = "yyyy-MM-dd HH:mm";
        SimpleDateFormat sdf = new SimpleDateFormat(format, Locale.CHINA);
        return sdf.format(new Date(System.currentTimeMillis()));
    }

}
