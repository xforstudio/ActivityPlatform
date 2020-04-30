package com.xfor.infrastructure.service.impl.stub;

import com.xfor.infrastructure.service.ISmsService;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 *
 */
@Component
public class StubSmsService implements ISmsService {

    @Override
    public void send(String mobileNO, String content) {
        throw new UnsupportedOperationException();
    }
}
