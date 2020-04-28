package com.xfor.passport.repository.jpa;

import com.xfor.infrastructure.service.ServiceContext;
import com.xfor.passport.model.PassportAuth;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface IPassportAuthJpaDAO extends JpaRepository<PassportAuth, String> {

    @Query("")
    String findLoginTokenByPassportAuthCodeAndCategoryID(String passportAuthCode, String categoryID);

    @Query("")
    String findPassportAuthCodeByLoginTokenAndCategoryID(String loginToken, String categoryID);
}
