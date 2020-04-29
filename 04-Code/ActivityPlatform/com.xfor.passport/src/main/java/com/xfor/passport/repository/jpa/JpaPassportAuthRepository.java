package com.xfor.passport.repository.jpa;

import com.xfor.infrastructure.service.ServiceContext;
import com.xfor.passport.repository.IPassportAuthRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class JpaPassportAuthRepository implements IPassportAuthRepository {

    @Autowired
    private IPassportAuthJpaDAO passportAuthJpaDAO;

    public JpaPassportAuthRepository(IPassportAuthJpaDAO passportAuthJpaDAO) {
        this.passportAuthJpaDAO = passportAuthJpaDAO;
    }

    public String getLoginTokenByPassportAuthCode(
            ServiceContext sctx,
            String passportAuthCode,
            String categoryID) {
        //throw new UnsupportedOperationException();
        String loginToken = this.passportAuthJpaDAO.findLoginTokenByPassportAuthCodeAndCategoryID(
                passportAuthCode,
                categoryID);
        return loginToken;
    }

    public String getPassportAuthCodeByLoginToken(
            ServiceContext sctx,
            String loginToken,
            String categoryID) {
        //throw new UnsupportedOperationException();
        String passportAuthCode = this.passportAuthJpaDAO.findPassportAuthCodeByLoginTokenAndCategoryID(
                loginToken,
                categoryID);
        return passportAuthCode;
    }
}
