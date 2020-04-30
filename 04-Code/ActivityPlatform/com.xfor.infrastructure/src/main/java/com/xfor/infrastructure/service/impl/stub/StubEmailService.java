package com.xfor.infrastructure.service.impl.stub;

import com.xfor.infrastructure.service.IEmailService;
import org.springframework.stereotype.Component;

/**
 *
 */
@Component
public class StubEmailService implements IEmailService {

    @Override
    public void send(String email, String content) {

    }
}
