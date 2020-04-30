package com.xfor.passport.repository.mybatis;

import com.xfor.infrastructure.service.ServiceContext;
import com.xfor.passport.repository.IPassportAuthRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 */
@Component
public class MyBatisPassportAuthRepository implements IPassportAuthRepository {

    @Autowired
    private IPassportAuthMyBatisDAO passportAuthMyBatisDAO;

    public MyBatisPassportAuthRepository() {
    }

    public String getLoginTokenByPassportAuthCode(
            ServiceContext sctx,
            String passportAuthCode,
            String categoryID) {
        throw new UnsupportedOperationException();
//        String loginToken = this.passportAuthJpaDAO.findLoginTokenByPassportAuthCodeAndCategoryID(
//                passportAuthCode,
//                categoryID);
//        return loginToken;
    }

    public String getPassportAuthCodeByLoginToken(
            ServiceContext sctx,
            String loginToken,
            String categoryID) {
        throw new UnsupportedOperationException();
//        String passportAuthCode = this.passportAuthJpaDAO.findPassportAuthCodeByLoginTokenAndCategoryID(
//                loginToken,
//                categoryID);
//        return passportAuthCode;
    }
}
