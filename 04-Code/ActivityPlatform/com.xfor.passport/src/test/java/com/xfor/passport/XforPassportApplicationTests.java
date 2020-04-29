package com.xfor.passport;

import org.junit.jupiter.api.Test;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.test.context.SpringBootTest;

@EntityScan("com.xfor.passport.model.PassportAuth")
@SpringBootTest
class XforPassportApplicationTests {

    @Test
    void contextLoads() {
    }

}
