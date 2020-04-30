package com.xfor.passport.repository.mybatis;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xfor.passport.model.Passport;

/**
 *
 */
public interface IPassportMyBatisDAO extends BaseMapper<Passport> {

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

    void deleteBySID(String sid);
}
