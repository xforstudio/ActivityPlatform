package com.xfor.infrastructure.model;

/**
 * 性别
 */
public class Sex {

    public static String _format(SexEnum sex) {
        switch (sex) {
            case None: return "-";
            case Male: return "男";
            case Female: return "女";
            default: return null;
        }
    }
}
