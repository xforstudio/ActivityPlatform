package com.xfor.passport.model;

/**
 *
 */
public enum PassportCheckStateEnum {
    None(0),
    NotCheck(1),
    Checked(2);

    private final int value;

    PassportCheckStateEnum(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
