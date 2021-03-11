package com.demo.condominiumapp.factory;

import com.demo.condominiumapp.domain.FunctionalityPermission;

import java.util.List;

public final class OutputFactory {

    private static String pattern = "[),]$";

    public static String buildFrom(Long condominiumId, List<FunctionalityPermission> functionalityPermissions) {
        String functionalityPermission = "";

        for (FunctionalityPermission fp: functionalityPermissions) {
            functionalityPermission = functionalityPermission
                    .concat("(")
                    .concat(fp.getFunctionality())
                    .concat(",")
                    .concat(fp.getPermission())
                    .concat("),");
        }

        return String.valueOf(condominiumId)
                .concat(";[")
                .concat(functionalityPermission.replaceAll(pattern, ""))
                .concat("]");
    }
}
