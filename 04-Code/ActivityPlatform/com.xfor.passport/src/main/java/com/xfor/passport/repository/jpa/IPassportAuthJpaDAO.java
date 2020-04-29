package com.xfor.passport.repository.jpa;

import com.xfor.infrastructure.service.ServiceContext;
import com.xfor.passport.model.PassportAuth;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface IPassportAuthJpaDAO extends JpaRepository<PassportAuth, String> {

//    //@Query("")
//    String findLoginTokenByPassportAuthCodeAndCategoryID(String passportAuthCode, String categoryID);
//
//    //@Query("")
//    String findPassportAuthCodeByLoginTokenAndCategoryID(String loginToken, String categoryID);
}
