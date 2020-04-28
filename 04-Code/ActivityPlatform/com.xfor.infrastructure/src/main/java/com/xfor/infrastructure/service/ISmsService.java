package com.xfor.infrastructure.service;

/**
 * 短信服务
 */
public interface ISmsService {
    void send(String mobileNO, String content);
}
