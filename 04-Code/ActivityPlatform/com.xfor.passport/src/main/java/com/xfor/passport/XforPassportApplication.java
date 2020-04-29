package com.xfor.passport;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@EntityScan("com.xfor.passport.model.PassportAuth")
@SpringBootApplication
public class XforPassportApplication {

    public static void main(String[] args) {
        SpringApplication.run(XforPassportApplication.class, args);
    }

}
