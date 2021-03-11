package com.demo.condominiumapp.factory;

import com.demo.condominiumapp.domain.GroupCondominium;
import com.demo.condominiumapp.domain.User;
import com.demo.condominiumapp.enumerator.StringPatternEnum;
import com.demo.condominiumapp.utils.StringUtils;

import java.util.ArrayList;
import java.util.List;

public final class UserFactory {

    public static User buildFrom(String userLine) {
        List<GroupCondominium> groupCondominiums = new ArrayList<>();

        List<String> columns = StringUtils.split(userLine, StringPatternEnum.COLUMN_PATTERN.getValue());
        List<String> pairList = StringUtils.split(columns.get(2), StringPatternEnum.PAIR_LIST_PATTERN.getValue());
        pairList.forEach(p -> {
            List<String> pair = StringUtils.split(p, StringPatternEnum.PAIR_PATTERN.getValue());
            groupCondominiums.add(GroupCondominiumFactory.buildFrom(pair.get(0), Long.parseLong(pair.get(1))));
        });

        return User.builder()
                .email(columns.get(1))
                .groupCondominiumList(groupCondominiums)
                .build();
    }
}
