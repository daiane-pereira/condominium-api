package com.demo.condominiumapp.factory;

import com.demo.condominiumapp.domain.FunctionalityPermission;
import com.demo.condominiumapp.domain.Group;
import com.demo.condominiumapp.enumerator.StringPatternEnum;
import com.demo.condominiumapp.utils.StringUtils;

import java.util.ArrayList;
import java.util.List;

public final class GroupFactory {

    public static Group buildFrom(String groupLine) {
        List<FunctionalityPermission> functionalityPermissions = new ArrayList<>();

        List<String> columns = StringUtils.split(groupLine, StringPatternEnum.COLUMN_PATTERN.getValue());
        List<String> pairList = StringUtils.split(columns.get(3), StringPatternEnum.PAIR_LIST_PATTERN.getValue());
        pairList.forEach(p -> {
            List<String> pair = StringUtils.split(p, StringPatternEnum.PAIR_PATTERN.getValue());
            functionalityPermissions.add(FunctionalityPermissionFactory.buildFrom(pair.get(0), pair.get(1)));
        });

        return Group.builder()
                .groupType(columns.get(1))
                .condominiumId(Long.parseLong(columns.get(2)))
                .functionalityPermissionList(functionalityPermissions)
                .build();
    }
}
