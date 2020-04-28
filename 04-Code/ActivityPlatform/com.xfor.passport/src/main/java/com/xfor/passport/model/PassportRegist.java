package com.xfor.passport.model;

import com.xfor.infrastructure.model.IDTypeNOEnum;
import com.xfor.infrastructure.model.IDateTimeProvider;
import com.xfor.infrastructure.model.SexEnum;
import com.xfor.infrastructure.util.DateTimeUtil;
import com.xfor.infrastructure.util.StringUtil;

/**
 * 通行证注册
 */
public class PassportRegist {

    private String name;  //姓名
    private SexEnum sex = SexEnum.None;  //性别
    private IDTypeNOEnum idTypeNO = IDTypeNOEnum.None;  //首选证件类型编号
    private String idCode;  //首选证件号
    private String mobile;  //手机号码
    private String email;  //电子邮件
    private String username;  //用户名
    private String password;  //密码

    public PassportRegist() {
    }

    public void validate() throws PassportException {
        if (StringUtil._isNullOrWhiteSpace(this.getName())) {
            throw new PassportException("Name");
        }
        if (StringUtil._isNullOrWhiteSpace(this.getUsername())) {
            throw new PassportException("Username");
        }
        if (StringUtil._isNullOrWhiteSpace(this.getPassword())) {
            throw new PassportException("Password");
        }
    }

    public boolean isMobileSet() {
        return !StringUtil._isNullOrWhiteSpace(this.getMobile());
    }

    public boolean isEmailSet() {
        return !StringUtil._isNullOrWhiteSpace(this.getEmail());
    }

    public Passport createPassport(IDateTimeProvider dateTimeProvider) {
        Passport passport = new Passport();
        passport.setSID(Passport._newSID());
        passport.setSN(Passport._newSN());
        passport.setName(this.getName());
        passport.setSex(this.getSex());
        passport.setIDTypeNO(this.getIDTypeNO());
        passport.setIDCode(this.getIDCode());
        passport.setMobile(this.getMobile());
        passport.setMobileCheckState(PassportCheckStateEnum.NotCheck);
        passport.setEmail(this.getEmail());
        passport.setEmailCheckState(PassportCheckStateEnum.NotCheck);
        passport.setUsername(this.getUsername());
        passport.setPassword(this.getPassword());
        passport.setCreateTime(DateTimeUtil._now());
        passport.setModifyTime(DateTimeUtil._now());
        return passport;
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

    public IDTypeNOEnum getIDTypeNO() {
        return idTypeNO;
    }

    public void setIDTypeNO(IDTypeNOEnum idTypeNO) {
        this.idTypeNO = idTypeNO;
    }

    public String getIDCode() {
        return idCode;
    }

    public void setIDCode(String idCode) {
        this.idCode = idCode;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
