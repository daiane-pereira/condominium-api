package com.demo.condominiumapp.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class UserPermission {

    private Long condominiumId;
    private List<FunctionalityPermission> functionalityPermissionList;
}
