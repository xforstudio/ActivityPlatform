package com.xfor.payment.service;

import com.xfor.infrastructure.service.BaseService;
import com.xfor.payment.repository.IPaymentHandleRepository;
import com.xfor.payment.repository.IPaymentMethodRepository;
import com.xfor.payment.repository.IPaymentOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentManageService extends BaseService {

    @Autowired
    private IPaymentOrderRepository paymentOrderRepository;
    @Autowired
    private IPaymentMethodRepository paymentMethodRepository;
    @Autowired
    private IPaymentHandleRepository paymentHandleRepository;

    public PaymentManageService() {
        super();
    }
}


