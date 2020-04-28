package com.xfor.infrastructure.model;

import com.xfor.infrastructure.util.RandomUtil;

import java.util.Random;

/**
 * 字符串验证码
 */
public class TextCaptcha {

    public static String _newNumCode(int length) {
        Random rand = new Random();
        int value = RandomUtil._nextInt((int)Math.pow(10, length-1), (int)Math.pow(10, length) - 1);
        return Integer.toString(value);
    }

    public static String _newNumCode() {
        return _newNumCode(6);
    }
}
