package com.xfor.passport.model;

import com.xfor.infrastructure.model.SexEnum;

/**
 * 通行证用户信息
 */
public class PassportUser {

    private String passportSID;
    private String name;
    private SexEnum sex;

    public PassportUser() {
    }

    public String getPassportSID() {
        return passportSID;
    }

    public void setPassportSID(String passportSID) {
        this.passportSID = passportSID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public SexEnum getSex() {
        return sex;
    }

    public void setSex(SexEnum sex) {
        this.sex = sex;
    }
}
