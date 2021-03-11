package com.demo.condominiumapp.factory;

import com.demo.condominiumapp.domain.GroupCondominium;

public final class GroupCondominiumFactory {

    public static GroupCondominium buildFrom(String groupType, Long condominiumId) {
        return GroupCondominium.builder()
                .groupType(groupType)
                .condominiumId(condominiumId)
                .build();
    }
}
