package com.xfor.passport.service;

import com.xfor.infrastructure.service.BaseService;
import com.xfor.infrastructure.service.ServiceContext;
import com.xfor.passport.repository.IPassportAuthCategoryRepository;
import com.xfor.passport.repository.IPassportAuthRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class PassportAuthManageService extends BaseService implements IPassportAuthManageService {

    @Autowired
    private IPassportAuthRepository passportAuthRepository;
    @Autowired
    private IPassportAuthCategoryRepository passportAuthCategoryRepository;

    public PassportAuthManageService() {
    }

    public PassportAuthManageService(
            IPassportAuthRepository passportAuthRepository,
            IPassportAuthCategoryRepository passportAuthCategoryRepository) {
        this.passportAuthRepository = passportAuthRepository;
        this.passportAuthCategoryRepository = passportAuthCategoryRepository;
    }

    public String getLoginTokenByPassportAuthCode(String passportAuthCode, String categoryID) {
        ServiceContext sctx = this.doGetServiceContext();
        String result = this.passportAuthRepository.getLoginTokenByPassportAuthCode(
                sctx,
                passportAuthCode,
                categoryID);
        return result;
    }

    public String getPassportAuthCodeByLoginToken(String loginToken, String categoryID) {
        ServiceContext sctx = this.doGetServiceContext();
        String result = this.passportAuthRepository.getPassportAuthCodeByLoginToken(
                sctx,
                loginToken,
                categoryID);
        return result;
    }
}
