package com.xfor.infrastructure.service;

/**
 * 服务基类
 */
public class BaseService {

    public BaseService() {
    }

    protected ServiceContext doGetServiceContext() {
        return ServiceContext._empty();
    }
}
