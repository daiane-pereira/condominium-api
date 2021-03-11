package com.demo.condominiumapp.service.impl;

import com.demo.condominiumapp.domain.FunctionalityPermission;
import com.demo.condominiumapp.domain.Group;
import com.demo.condominiumapp.domain.UserPermission;
import com.demo.condominiumapp.enumerator.PermissionEnum;
import com.demo.condominiumapp.factory.OutputFactory;
import com.demo.condominiumapp.service.UserPermissionsService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserPermissionsServiceImpl implements UserPermissionsService {

    @Override
    public List<String> formatUserPermissions(List<Group> userGroups) {
        List<UserPermission> userPermissions = new ArrayList<>();
        List<String> userPermissionsOutput = new ArrayList<>();

        userGroups.forEach(group -> {
            Boolean containsCondominium = containsCondominiumInList(userPermissions, group.getCondominiumId());
            if (containsCondominium) {
                UserPermission userPermissionAuxiliary = userPermissions.stream()
                        .filter(up -> up.getCondominiumId() == group.getCondominiumId())
                        .findFirst()
                        .get();

                List<FunctionalityPermission> functionalityPermissionsNew = new ArrayList<>();

                userPermissionAuxiliary.getFunctionalityPermissionList().forEach(functionalityPermission -> {
                    String functionalityAuxiliary = functionalityPermission.getFunctionality();
                    List<String> permissions = new ArrayList<>();
                    permissions.add(functionalityPermission.getPermission());

                    FunctionalityPermission fp = group.getFunctionalityPermissionList().stream()
                            .filter(f -> f.getFunctionality().equals(functionalityAuxiliary))
                            .findFirst()
                            .get();

                    permissions.add(fp.getPermission());
                    String relevancePermission = getPermissionWithMoreRelevance(permissions);
                    functionalityPermissionsNew.add(FunctionalityPermission.builder()
                            .functionality(functionalityAuxiliary)
                            .permission(relevancePermission)
                            .build());
                });

                userPermissions.add(UserPermission.builder()
                        .condominiumId(group.getCondominiumId())
                        .functionalityPermissionList(functionalityPermissionsNew)
                        .build());

            } else {
                userPermissions.add(UserPermission.builder()
                        .condominiumId(group.getCondominiumId())
                        .functionalityPermissionList(group.getFunctionalityPermissionList())
                        .build());
            }
        });

        userPermissions.forEach(userPermission -> {
            userPermissionsOutput.add(OutputFactory.buildFrom(
                    userPermission.getCondominiumId(),
                    userPermission.getFunctionalityPermissionList()));
        });

        return userPermissionsOutput;
    }

    private Boolean containsCondominiumInList(List<UserPermission> userPermissions, Long condominiumId) {
        for (UserPermission permission: userPermissions) {
            if (permission.getCondominiumId() == condominiumId) {
                return true;
            }
        }
        return false;
    }

    private String getPermissionWithMoreRelevance(List<String> permissions) {
        for (String permission: permissions) {
            if (permission.equals(PermissionEnum.WRITING.getValue())) {
                return permission;
            }

            if (permission.equals(PermissionEnum.READING.getValue())) {
                return permission;
            }
        }
        return PermissionEnum.NONE.getValue();
    }
}
