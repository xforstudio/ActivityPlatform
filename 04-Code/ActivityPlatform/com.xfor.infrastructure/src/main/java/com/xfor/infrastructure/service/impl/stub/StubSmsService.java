package com.xfor.infrastructure.service.impl.stub;

import com.xfor.infrastructure.service.ISmsService;
import org.springframework.stereotype.Service;

@Service
public class StubSmsService implements ISmsService {

    @Override
    public void send(String mobileNO, String content) {
        throw new UnsupportedOperationException();
    }
}
