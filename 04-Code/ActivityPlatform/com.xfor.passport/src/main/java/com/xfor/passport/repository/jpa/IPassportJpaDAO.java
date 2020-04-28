package com.xfor.passport.repository.jpa;

import com.xfor.infrastructure.service.ServiceContext;
import com.xfor.passport.model.Passport;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 */
public interface IPassportJpaDAO extends JpaRepository<Passport, String> {

    Passport findFirstBySID(String sid);

    Passport findFirstBySN(String sn);

    Passport findFirstByUsername(String username);

    Passport findFirstByMobile(String mobile);

    Passport findFirstByEmail(String email);

    Passport findFirstByUsernameOrMobileOrEmail(String username, String mobile, String email);

    Passport findFirstByLoginToken(String loginToken);

    boolean existsByLoginToken(String loginToken);

    boolean existsByUsername(String username);

    boolean existsByMobile(String mobile);

    boolean existsByEmail(String email);

    void deleteBySid(String sid);
}
