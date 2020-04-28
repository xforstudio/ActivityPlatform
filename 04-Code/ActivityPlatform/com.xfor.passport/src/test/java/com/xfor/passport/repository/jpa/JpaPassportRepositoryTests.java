package com.xfor.passport.repository.jpa;

import com.xfor.infrastructure.service.ServiceContext;
import com.xfor.passport.model.Passport;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class JpaPassportRepositoryTests {

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
        String passportSID = "";
        JpaPassportRepository passportRepository = new JpaPassportRepository();
        Passport passport = passportRepository.getPassportBySID(this.doGetServiceContext(), passportSID);
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