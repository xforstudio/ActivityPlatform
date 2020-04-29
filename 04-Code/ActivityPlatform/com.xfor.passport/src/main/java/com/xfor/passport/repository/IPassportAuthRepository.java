package com.xfor.passport.repository;

import com.xfor.infrastructure.service.ServiceContext;
import org.springframework.stereotype.Component;

/**
 *
 */
@Component
public interface IPassportAuthRepository {

    String getLoginTokenByPassportAuthCode(ServiceContext sctx, String passportAuthCode, String categoryID);

    String getPassportAuthCodeByLoginToken(ServiceContext sctx, String loginToken, String categoryID);
}
