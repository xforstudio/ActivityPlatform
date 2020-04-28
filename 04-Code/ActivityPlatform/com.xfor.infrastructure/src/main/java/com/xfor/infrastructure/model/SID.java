package com.xfor.infrastructure.model;

import java.util.UUID;

/**
 * 唯一标识
 */
public class SID {

    public static String _newSID() {
        UUID uuid = UUID.randomUUID();
        return uuid.toString().replace("-","").toUpperCase();
    }
}
