package com.xfor.passport.repository.jpa;

import com.xfor.infrastructure.service.ServiceContext;
import com.xfor.passport.model.Passport;
import com.xfor.passport.repository.IPassportRepository;

public class JPAPassportRepository implements IPassportRepository {

    public Passport getPassportBySID(ServiceContext sctx, String sid) {
        throw new UnsupportedOperationException();
    }

    public Passport getPassportBySN(ServiceContext sctx, String sn) {
        throw new UnsupportedOperationException();
    }

    public Passport getPassportByUsername(ServiceContext sctx, String username) {
        throw new UnsupportedOperationException();
    }

    public Passport getPassportByMobile(ServiceContext sctx, String mobile) {
        throw new UnsupportedOperationException();
    }

    public Passport getPassportByEmail(ServiceContext sctx, String email) {
        throw new UnsupportedOperationException();
    }

    public Passport getPassportByCredential(ServiceContext sctx, String credential) {
        throw new UnsupportedOperationException();
    }

    public Passport getPassportByLoginToken(ServiceContext sctx, String loginToken) {
        throw new UnsupportedOperationException();
    }

    public boolean existsLoginToken(ServiceContext sctx, String loginToken) {
        throw new UnsupportedOperationException();
    }

    public boolean existsUsername(ServiceContext sctx, String username) {
        throw new UnsupportedOperationException();
    }

    public boolean existsMobile(ServiceContext sctx, String mobile) {
        throw new UnsupportedOperationException();
    }

    public boolean existsEmail(ServiceContext sctx, String email) {
        throw new UnsupportedOperationException();
    }

    public void savePassport(ServiceContext sctx, Passport passport) {
        throw new UnsupportedOperationException();
    }

    public void deletePassportBySID(ServiceContext sctx, String sid) {
        throw new UnsupportedOperationException();
    }
}
