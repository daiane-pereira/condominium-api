package com.demo.condominiumapp.factory;

import com.demo.condominiumapp.domain.FunctionalityPermission;

public final class FunctionalityPermissionFactory {

    public static FunctionalityPermission buildFrom(String functionality, String permission) {
        return FunctionalityPermission.builder()
                .functionality(functionality)
                .permission(permission)
                .build();
    }
}
