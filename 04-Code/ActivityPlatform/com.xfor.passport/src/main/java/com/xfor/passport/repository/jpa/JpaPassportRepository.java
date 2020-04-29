package com.xfor.passport.repository.jpa;

import com.xfor.infrastructure.service.ServiceContext;
import com.xfor.passport.model.Passport;
import com.xfor.passport.repository.IPassportRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class JpaPassportRepository implements IPassportRepository {

    @Autowired
    private IPassportJpaDAO passportJpaDAO;

    public JpaPassportRepository() {
    }

//    public JpaPassportRepository(IPassportJpaDAO passportJpaDAO) {
//        this.passportJpaDAO = passportJpaDAO;
//    }

    public Passport getPassportBySID(ServiceContext sctx, String sid) {
        //throw new UnsupportedOperationException();
        Passport result = this.passportJpaDAO.findFirstBySID(sid);
        return result;
    }

    public Passport getPassportBySN(ServiceContext sctx, String sn) {
        Passport result = this.passportJpaDAO.findFirstBySN(sn);
        return result;
    }

    public Passport getPassportByUsername(ServiceContext sctx, String username) {
        Passport result = this.passportJpaDAO.findFirstByUsername(username);
        return result;
    }

    public Passport getPassportByMobile(ServiceContext sctx, String mobile) {
        Passport result = this.passportJpaDAO.findFirstByMobile(mobile);
        return result;
    }

    public Passport getPassportByEmail(ServiceContext sctx, String email) {
        Passport result = this.passportJpaDAO.findFirstByEmail(email);
        return result;
    }

    public Passport getPassportByCredential(ServiceContext sctx, String credential) {
        Passport result = this.passportJpaDAO.findFirstByUsernameOrMobileOrEmail(credential, credential, credential);
        return result;
    }

    public Passport getPassportByLoginToken(ServiceContext sctx, String loginToken) {
        Passport result = this.passportJpaDAO.findFirstByLoginToken(loginToken);
        return result;
    }

    public boolean existsLoginToken(ServiceContext sctx, String loginToken) {
        boolean result = this.passportJpaDAO.existsByLoginToken(loginToken);
        return result;
    }

    public boolean existsUsername(ServiceContext sctx, String username) {
        boolean result = this.passportJpaDAO.existsByUsername(username);
        return result;
    }

    public boolean existsMobile(ServiceContext sctx, String mobile) {
        boolean result = this.passportJpaDAO.existsByMobile(mobile);
        return result;
    }

    public boolean existsEmail(ServiceContext sctx, String email) {
        boolean result = this.passportJpaDAO.existsByEmail(email);
        return result;
    }

    public void savePassport(ServiceContext sctx, Passport passport) {
        this.passportJpaDAO.save(passport);
    }

    public void deletePassportBySID(ServiceContext sctx, String sid) {
        this.passportJpaDAO.deleteBySid(sid);
    }
}
