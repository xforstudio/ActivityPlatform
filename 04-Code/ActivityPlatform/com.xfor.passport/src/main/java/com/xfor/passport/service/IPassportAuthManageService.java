package com.xfor.passport.service;

/**
 * 通行证授权管理服务接口
 */
public interface IPassportAuthManageService {

    String getLoginTokenByPassportAuthCode(String passportAuthCode, String categoryID);

    String getPassportAuthCodeByLoginToken(String loginToken, String categoryID);
}
