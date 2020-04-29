package com.xfor.infrastructure.service;

import org.springframework.stereotype.Component;

/**
 * 邮件服务
 */
@Component
public interface IEmailService {
    void send(String email, String content);
}
