package com.xfor.infrastructure.model;

/**
 * 性别枚举
 */
public enum SexEnum {
    None(0),
    Male(1),
    Female(2);

    private final int value;

    SexEnum(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
