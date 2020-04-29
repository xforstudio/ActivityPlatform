package com.xfor.infrastructure.service.impl.stub;

import com.xfor.infrastructure.service.ITextCaptchaLogService;

public class StubTextCaptchaLogService implements ITextCaptchaLogService {

    @Override
    public void setCaptcha(String category, String key, String captcha) {
        throw new UnsupportedOperationException();
    }

    @Override
    public String pickCaptcha(String category, String key) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void initCaptchas() {
        throw new UnsupportedOperationException();
    }

    @Override
    public void clearCaptchas() {
        throw new UnsupportedOperationException();
    }
}
