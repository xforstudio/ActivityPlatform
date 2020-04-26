package com.xfor.activityplatform.portal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude= {DataSourceAutoConfiguration.class})
public class XforActivityPortalApplication {

    public static void main(String[] args) {
        SpringApplication.run(XforActivityPortalApplication.class, args);
    }

}
