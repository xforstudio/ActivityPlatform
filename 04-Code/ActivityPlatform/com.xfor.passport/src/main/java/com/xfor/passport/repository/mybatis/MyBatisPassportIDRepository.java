package com.xfor.passport.repository.mybatis;

import com.xfor.passport.repository.IPassportIDRepository;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 */
public class MyBatisPassportIDRepository implements IPassportIDRepository {

    @Autowired
    private IPassportIDMyBatisDAO passportIDMyBatisDAO;

    public MyBatisPassportIDRepository() {
    }
}
