package com.xfor.passport.repository.mybatis;

import com.xfor.infrastructure.service.ServiceContext;
import com.xfor.passport.model.Passport;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.Assert;

import javax.annotation.security.RunAs;

@SpringBootTest
public class MyBatisPassportRepositoryTests {

    @Autowired
    private MyBatisPassportRepository passportRepository;

    protected ServiceContext doGetServiceContext() {
        return ServiceContext._empty();
    }

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void getPassportBySID() {
        String passportSID = "A338C963A662411C9DE8602473618929";
        Passport passport = this.passportRepository.getPassportBySID(this.doGetServiceContext(), passportSID);
        Assert.notNull(passport, "");
    }

    @Test
    void getPassportBySN() {
    }

    @Test
    void getPassportByUsername() {
    }

    @Test
    void getPassportByMobile() {
    }

    @Test
    void getPassportByEmail() {
    }

    @Test
    void getPassportByCredential() {
    }

    @Test
    void getPassportByLoginToken() {
    }

    @Test
    void existsLoginToken() {
    }

    @Test
    void existsUsername() {
    }

    @Test
    void existsMobile() {
    }

    @Test
    void existsEmail() {
    }

    @Test
    void savePassport() {
    }

    @Test
    void deletePassportBySID() {
    }
}
