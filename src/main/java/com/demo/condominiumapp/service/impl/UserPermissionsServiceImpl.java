package com.demo.condominiumapp.service.impl;

import com.demo.condominiumapp.domain.Group;
import com.demo.condominiumapp.factory.OutputFactory;
import com.demo.condominiumapp.service.UserPermissionsService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserPermissionsServiceImpl implements UserPermissionsService {

    @Override
    public List<String> formatUserPermissions(List<Group> userGroups) {
        List<String> userPermissionsOutput = new ArrayList<>();
        userGroups.forEach(group -> {
            userPermissionsOutput.add(OutputFactory.buildFrom(
                    group.getCondominiumId(),
                    group.getFunctionalityPermissionList()));
        });
        return userPermissionsOutput;
    }
}
