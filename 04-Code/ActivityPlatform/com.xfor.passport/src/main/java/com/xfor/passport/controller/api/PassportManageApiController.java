package com.xfor.passport.controller.api;

import com.xfor.infrastructure.service.ServiceContext;
import com.xfor.passport.model.*;
import com.xfor.passport.service.PassportManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PassportManageApiController {

    @Autowired
    private PassportManageService passportManageService;

    public PassportManageApiController() {
    }

    public PassportManageApiController(PassportManageService passportManageService) {
        this.passportManageService = passportManageService;
    }

//    @RequestMapping("/login")
//    public String login() {
//        return "login ok";
//    }

    @RequestMapping(value = "/isLoginTokenValid/{loginToken}",method = RequestMethod.POST)
    public boolean isLoginTokenValid(String loginToken) {
        return this.passportManageService.isLoginTokenValid(loginToken);
    }

    @RequestMapping(value = "/verifyLoginToken/{loginToken}",method = RequestMethod.POST)
    public void verifyLoginToken(String loginToken)
            throws PassportException {
        this.passportManageService.verifyLoginToken(loginToken);
    }

    @RequestMapping(value = "/clearLoginTokens/{durationLimit}",method = RequestMethod.POST)
    public void clearLoginTokens(int durationLimit) {
        this.passportManageService.clearLoginTokens(durationLimit);
    }

    @RequestMapping(value = "/loginByCredAndPwd/{credential}/{password}",method = RequestMethod.POST)
    public PassportLoginSession loginByCredAndPwd(String credential, String password)
            throws PassportException {
        return this.passportManageService.loginByCredAndPwd(credential, password);
    }

    @RequestMapping(value = "/loginBySms/{mobile}/{captcha}",method = RequestMethod.POST)
    public PassportLoginSession loginBySms(String mobile, String captcha)
            throws PassportException {
        return this.passportManageService.loginBySms(mobile, captcha);
    }

    @RequestMapping(value = "/logout/{loginToken}",method = RequestMethod.POST)
    public void logout(String loginToken)
            throws PassportException {
        this.passportManageService.logout(loginToken);
    }

    @RequestMapping(value = "/sendSmsCaptchaWithLogin/{mobile}",method = RequestMethod.POST)
    public void sendSmsCaptchaWithLogin(String mobile) {
        this.passportManageService.sendSmsCaptchaWithLogin(mobile);
    }

    @RequestMapping(value = "/registPassport/{passportRegist}",method = RequestMethod.POST)
    public void registPassport(PassportRegist passportRegist)
            throws PassportException {
        this.passportManageService.registPassport(passportRegist);
    }

    @RequestMapping(value = "/resetPasswordWithMobile/{newPwd}/{mobile}/{captcha}",method = RequestMethod.POST)
    public void resetPasswordWithMobile(String newPwd, String mobile, String captcha)
            throws PassportException {
        this.passportManageService.resetPasswordWithMobile(newPwd, mobile, captcha);
    }

    @RequestMapping(value = "/resetPasswordWithEmail/{newPwd}/{email}/{captcha}",method = RequestMethod.POST)
    public void resetPasswordWithEmail(String newPwd, String email, String captcha)
            throws PassportException {
        this.passportManageService.resetPasswordWithEmail(newPwd, email, captcha);
    }

    @RequestMapping(value = "/sendSmsCaptchaWithResetPassword/{mobile}",method = RequestMethod.POST)
    public void sendSmsCaptchaWithResetPassword(String mobile) {
        this.passportManageService.sendSmsCaptchaWithResetPassword(mobile);
    }

    @RequestMapping(value = "/sendEmailCaptchaWithResetPassword/{email}",method = RequestMethod.POST)
    public void sendEmailCaptchaWithResetPassword(String email) {
        this.passportManageService.sendEmailCaptchaWithResetPassword(email);
    }

    @RequestMapping(value = "/getPassportByPassportSID/{passportSID}",method = RequestMethod.POST)
    public Passport getPassportByPassportSID(String passportSID) {
        return this.passportManageService.getPassportByPassportSID(passportSID);
    }

    @RequestMapping(value = "/getPassportSIDByLoginToken/{loginToken}",method = RequestMethod.POST)
    public String getPassportSIDByLoginToken(String loginToken) {
        return this.passportManageService.getPassportSIDByLoginToken(loginToken);
    }

    @RequestMapping(value = "/getPassportByLoginToken/{loginToken}",method = RequestMethod.POST)
    public Passport getPassportByLoginToken(String loginToken) {
        return this.passportManageService.getPassportByLoginToken(loginToken);
    }

    @RequestMapping(value = "/setPassportUser/{passportUser}",method = RequestMethod.POST)
    public void setPassportUser(PassportUser passportUser)
            throws PassportException {
        this.passportManageService.setPassportUser(passportUser);
    }

    @RequestMapping(value = "/setUsername/{passportCredential}",method = RequestMethod.POST)
    public void setUsername(PassportCredential passportCredential)
            throws PassportException {
        this.passportManageService.setUsername(passportCredential);
    }

    @RequestMapping(value = "/setMobile/{passportCredential}",method = RequestMethod.POST)
    public void setMobile(PassportCredential passportCredential)
            throws PassportException {
        this.passportManageService.setMobile(passportCredential);
    }

    @RequestMapping(value = "/sendSmsCaptchaWithSetMobile/{mobile}",method = RequestMethod.POST)
    public void sendSmsCaptchaWithSetMobile(String mobile) {
        this.passportManageService.sendSmsCaptchaWithSetMobile(mobile);
    }

    @RequestMapping(value = "/setEmail/{passportCredential}",method = RequestMethod.POST)
    public void setEmail(PassportCredential passportCredential)
            throws PassportException {
        this.passportManageService.setEmail(passportCredential);
    }

    @RequestMapping(value = "/sendEmailCaptchaWithSetEmail/{email}",method = RequestMethod.POST)
    public void sendEmailCaptchaWithSetEmail(String email) {
        this.passportManageService.sendEmailCaptchaWithSetEmail(email);
    }

    @RequestMapping(value = "/setPassword/{passportSID}/{pwdNew}",method = RequestMethod.POST)
    public void setPassword(String passportSID, String pwdNew) {
        this.passportManageService.setPassword(passportSID, pwdNew);
    }
}
