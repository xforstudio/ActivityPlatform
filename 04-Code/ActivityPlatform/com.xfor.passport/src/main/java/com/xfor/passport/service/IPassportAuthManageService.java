package com.xfor.passport.service;

/**
 * 通行证授权管理服务接口
 */
public interface IPassportAuthManageService {

    String GetLoginTokenByPassportAuthCode(String passportAuthCode, String categoryID);

    String GetPassportAuthCodeByLoginToken(String loginToken, String categoryID);
}
