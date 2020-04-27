package com.xfor.passport.model;

/**
 * 通行证授权
 */
public class PassportAuth {

    private String sid;
    private String passportSID;  //通行证唯一标识
    private String categoryID;  //授权类别标识
    private PassportAuthStateEnum state = PassportAuthStateEnum.None;  //授权状态
    private String code;  //授权码

    public PassportAuth() {
    }

    public String getSID() {
        return sid;
    }

    public void setSID(String sid) {
        this.sid = sid;
    }

    public String getPassportSID() {
        return passportSID;
    }

    public void setPassportSID(String passportSID) {
        this.passportSID = passportSID;
    }

    public String getCategoryID() {
        return categoryID;
    }

    public void setCategoryID(String categoryID) {
        this.categoryID = categoryID;
    }

    public PassportAuthStateEnum getState() {
        return state;
    }

    public void setState(PassportAuthStateEnum state) {
        this.state = state;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
