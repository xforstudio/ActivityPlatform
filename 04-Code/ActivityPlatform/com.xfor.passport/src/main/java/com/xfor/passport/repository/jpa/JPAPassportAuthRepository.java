package com.xfor.passport.repository.jpa;

import com.xfor.infrastructure.service.ServiceContext;
import com.xfor.passport.repository.IPassportAuthRepository;

public class JPAPassportAuthRepository implements IPassportAuthRepository {

    public String getLoginTokenByPassportAuthCode(
            ServiceContext sctx,
            String passportAuthCode,
            String categoryID) {
        throw new UnsupportedOperationException();
    }

    public String getPassportAuthCodeByLoginToken(
            ServiceContext sctx,
            String loginToken,
            String categoryID) {
        throw new UnsupportedOperationException();
    }
}
