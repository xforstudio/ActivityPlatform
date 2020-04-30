package com.xfor.passport.repository.mybatis;

import com.xfor.passport.repository.IPassportAuthCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 */
public class MyBatisPassportAuthCategoryRepository implements IPassportAuthCategoryRepository {

    @Autowired
    private IPassportAuthCategoryMyBatisDAO passportAuthCategoryMyBatisDAO;

    public MyBatisPassportAuthCategoryRepository() {
    }
}
