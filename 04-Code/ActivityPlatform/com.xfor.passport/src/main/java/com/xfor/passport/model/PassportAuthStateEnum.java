package com.xfor.passport.model;

/**
 * 通行证授权状态
 */
public enum PassportAuthStateEnum {
    None(0),
    Normal(1),
    Invalid(2);

    private final int value;

    PassportAuthStateEnum(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
