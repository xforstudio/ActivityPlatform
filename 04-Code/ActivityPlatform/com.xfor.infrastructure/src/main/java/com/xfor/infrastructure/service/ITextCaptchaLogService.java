package com.xfor.infrastructure.service;

/**
 * 文本验证码
 */
public interface ITextCaptchaLogService {

    void setCaptcha(String category, String key, String captcha);

    String pickCaptcha(String category, String key);

    void initCaptchas();

    void clearCaptchas();
}
