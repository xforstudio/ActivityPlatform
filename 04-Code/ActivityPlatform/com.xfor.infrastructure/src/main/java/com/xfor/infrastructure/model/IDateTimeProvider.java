package com.xfor.infrastructure.model;

import org.springframework.stereotype.Component;

import java.util.Date;

/**
 *
 */
@Component
public interface IDateTimeProvider {
    Date getNow();
}
