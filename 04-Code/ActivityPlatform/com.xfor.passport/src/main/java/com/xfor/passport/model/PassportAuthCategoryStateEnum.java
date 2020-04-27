package com.xfor.passport.model;

/**
 * 通行证授权类别状态
 */
public enum PassportAuthCategoryStateEnum {
    None(0),
    Normal(1),
    Invalid(2);

    private final int value;

    PassportAuthCategoryStateEnum(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
