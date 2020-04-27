package com.xfor.infrastructure.model;

/**
 * 证件类型编号
 */
public enum IDTypeNOEnum {
    None(0),
    中华人民共和国居民身份证(1),
    中华人民共和国护照(2);

    private final int value;

    IDTypeNOEnum(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
