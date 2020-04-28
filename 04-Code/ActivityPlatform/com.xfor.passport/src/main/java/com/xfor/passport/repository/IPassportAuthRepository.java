package com.xfor.passport.repository;

import com.xfor.infrastructure.service.ServiceContext;
import com.xfor.passport.model.PassportAuth;

/**
 *
 */
public interface IPassportAuthRepository {

    String getLoginTokenByPassportAuthCode(ServiceContext sctx, String passportAuthCode, String categoryID);

    String getPassportAuthCodeByLoginToken(ServiceContext sctx, String loginToken, String categoryID);
}
