package com.wangpengcheng.career.util;

import org.apache.commons.codec.digest.DigestUtils;

/**
 * Created by wpc on 2017/5/19.
 */
public class TokenUtil {

    /**
     * 自己生成token
     *
     * @param sid
     * @return
     */
    public static String genToken(String sid) {
        return DigestUtils.md5Hex(sid + System.currentTimeMillis());
    }

}
