package com.xfor.payment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.xfor"})
public class XforPaymentApplication {

    public static void main(String[] args) {
        SpringApplication.run(XforPaymentApplication.class, args);
    }

}
