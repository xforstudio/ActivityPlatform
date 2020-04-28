package com.xfor.infrastructure.service;

/**
 * 邮件服务
 */
public interface IEmailService {
    void send(String email, String content);
}
