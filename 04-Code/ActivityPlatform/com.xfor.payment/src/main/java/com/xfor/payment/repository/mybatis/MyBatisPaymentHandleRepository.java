package com.xfor.payment.repository.mybatis;

import com.xfor.payment.repository.IPaymentHandleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MyBatisPaymentHandleRepository implements IPaymentHandleRepository {

    @Autowired
    private IPaymentHandleMyBatisDAO paymentHandleMyBatisDAO;

    public MyBatisPaymentHandleRepository(){

    }
}
