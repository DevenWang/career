package com.wangpengcheng.career.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by wpc on 2017/5/19.
 */
public class MyUtil {
    /**
     * @return String
     * @discription 获取一个时间串
     */
    public static String getStringID() {
        String id = null;
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssSSS");
        id = sdf.format(date);
        return id;
    }

    public static String getDate(Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日");
        return sdf.format(date);
    }

}
