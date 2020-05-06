package com.xfor.passport.repository.mybatis;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xfor.passport.model.PassportAuth;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

/**
 *
 */
@Mapper
public interface IPassportAuthMyBatisDAO extends BaseMapper<PassportAuth> {

    @Select("")
    String findLoginTokenByPassportAuthCodeAndCategoryID(String passportAuthCode, String categoryID);

    @Select("")
    String findPassportAuthCodeByLoginTokenAndCategoryID(String loginToken, String categoryID);
}
