package com.xfor.payment.repository.mybatis;

import com.xfor.payment.repository.IPaymentMethodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MyBatisPaymentMethodRepository implements IPaymentMethodRepository {

    @Autowired
    private IPaymentMethodMyBatisDAO paymentMethodMyBatisDAO;

    public MyBatisPaymentMethodRepository(){

    }
}
