package com.xfor.passport.model;

import com.xfor.infrastructure.model.IDTypeNOEnum;
import com.xfor.infrastructure.model.IDateTimeProvider;
import com.xfor.infrastructure.model.SexEnum;
import com.xfor.infrastructure.model.Token;
import com.xfor.infrastructure.util.RandomUtil;
import com.xfor.infrastructure.util.StringUtil;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 通行证
 */
public class Passport {

    public static void _validatePassword(String password) {
        return;
    }

    public static String _newSN() {
        String timeText = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
        int seq = RandomUtil._nextInt(1, 999999);
        String seqText = String.format("%06d", seq);
        return timeText + seqText;
    }

    private String sid;  //唯一标识
    private String sn;  //编号
    private String name;  //姓名
    private SexEnum sex;  //性别
    private IDTypeNOEnum idTypeNO;  //首选证件类型编号
    private String idCode;  //首选证件号
    private String mobile;  //手机号码
    private PassportCheckStateEnum mobileCheckState;  //手机号验证状态
    private Date mobileCheckTime;  //手机号验证时间
    private String email;  //电子邮件
    private PassportCheckStateEnum emailCheckState;  //电子邮件验证状态
    private Date emailCheckTime;  //电子邮件验证时间
    private String username;
    private String password;
    private Date createTime;
    private Date modifyTime;
    private String loginToken;
    private Date loginTime;

    public Passport() {
    }

    public Passport(String sid) {
        this.setSID(sid);
    }

    public void validatePassword() {
        _validatePassword(this.getPassword());
    }

    public PassportUser getPassportUser() {
        PassportUser passportUser = new PassportUser();
        passportUser.setPassportSID(this.getSID());
        passportUser.setName(this.getName());
        passportUser.setSex(this.getSex());
        return passportUser;
    }

    public void setPassportUser(PassportUser passportUser, IDateTimeProvider dateTimeProvider) {
        this.setName(passportUser.getName());
        this.setSex(passportUser.getSex());
    }

    public void setUsername(String username, IDateTimeProvider dateTimeProvider) {
        this.setUsername(username);
        this.setModifyTime(dateTimeProvider.getNow());
    }

    public void setMobile(String mobile, PassportCheckStateEnum checkState, IDateTimeProvider dateTimeProvider) {
        this.setMobile(mobile);
        this.setMobileCheckState(checkState);
        this.setMobileCheckTime(dateTimeProvider.getNow());
        this.setModifyTime(this.getMobileCheckTime());
    }

    public void setEmail(String email, PassportCheckStateEnum checkState, IDateTimeProvider dateTimeProvider) {
        this.setEmail(email);
        this.setEmailCheckState(checkState);
        this.setEmailCheckTime(dateTimeProvider.getNow());
        this.setModifyTime(this.getEmailCheckTime());
    }

    public void setPassword(String password, IDateTimeProvider dateTimeProvider) {
        _validatePassword(password);
        this.setPassword(password);
        this.setModifyTime(dateTimeProvider.getNow());
    }

    public PassportID getPassportID() {
        PassportID passportID = new PassportID();
        passportID.setPassportSID(this.getSID());
        passportID.setIDTypeNO(this.getIDTypeNO());
        passportID.setIDCode(this.getIDCode());
        passportID.setPrimary(true);
        return passportID;
    }

    public void setPassportSID(PassportID passportID) {
        this.setIDTypeNO(passportID.getIDTypeNO());
        this.setIDCode(passportID.getIDCode());
    }

    public PassportLoginSession createLoginSession() {
        PassportLoginSession loginSession = new PassportLoginSession();
        loginSession.setLoginToken(this.getLoginToken());
        loginSession.setLoginTime(this.getLoginTime());
        return loginSession;
    }

    public PassportLoginSession login(IDateTimeProvider dateTimeProvider) {
        this.setLoginToken(Token._newToken());
        this.setLoginTime(dateTimeProvider.getNow());
        return this.createLoginSession();
    }

    public void logout(String loginToken) {
        this.setLoginToken(null);
        this.setLoginTime(null);
    }

    public boolean MatchPassword(String password) {
        return StringUtil._equals(this.getPassword(), password);
    }

    public String getSID() {
        return sid;
    }

    public void setSID(String sid) {
        this.sid = sid;
    }

    public String getSN() {
        return sn;
    }

    public void setSN(String sn) {
        this.sn = sn;
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

    public PassportCheckStateEnum getMobileCheckState() {
        return mobileCheckState;
    }

    public void setMobileCheckState(PassportCheckStateEnum mobileCheckState) {
        this.mobileCheckState = mobileCheckState;
    }

    public Date getMobileCheckTime() {
        return mobileCheckTime;
    }

    public void setMobileCheckTime(Date mobileCheckTime) {
        this.mobileCheckTime = mobileCheckTime;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public PassportCheckStateEnum getEmailCheckState() {
        return emailCheckState;
    }

    public void setEmailCheckState(PassportCheckStateEnum emailCheckState) {
        this.emailCheckState = emailCheckState;
    }

    public Date getEmailCheckTime() {
        return emailCheckTime;
    }

    public void setEmailCheckTime(Date emailCheckTime) {
        this.emailCheckTime = emailCheckTime;
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

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

    public String getLoginToken() {
        return loginToken;
    }

    public void setLoginToken(String loginToken) {
        this.loginToken = loginToken;
    }

    public Date getLoginTime() {
        return loginTime;
    }

    public void setLoginTime(Date loginTime) {
        this.loginTime = loginTime;
    }
}
