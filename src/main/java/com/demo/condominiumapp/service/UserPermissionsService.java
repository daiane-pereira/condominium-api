package com.demo.condominiumapp.service;

import com.demo.condominiumapp.domain.Group;

import java.util.List;

public interface UserPermissionsService {

    List<String> formatUserPermissions(List<Group> userGroups);
}
