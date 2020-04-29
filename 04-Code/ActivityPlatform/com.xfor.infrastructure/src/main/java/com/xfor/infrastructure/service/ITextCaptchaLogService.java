package com.xfor.infrastructure.service;

import org.springframework.stereotype.Component;

/**
 * 文本验证码
 */
@Component
public interface ITextCaptchaLogService {

    void setCaptcha(String category, String key, String captcha);

    String pickCaptcha(String category, String key);

    void initCaptchas();

    void clearCaptchas();
}
