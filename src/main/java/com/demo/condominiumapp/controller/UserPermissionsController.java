package com.demo.condominiumapp.controller;

import com.demo.condominiumapp.domain.Group;
import com.demo.condominiumapp.domain.User;
import com.demo.condominiumapp.service.GroupRegistryService;
import com.demo.condominiumapp.service.UserPermissionsService;
import com.demo.condominiumapp.service.UserRegistryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping(value = "/user-permissions")
public class UserPermissionsController {

    private UserRegistryService userRegistryService;
    private GroupRegistryService groupRegistryService;
    private UserPermissionsService userPermissionsService;

    @Autowired
    public UserPermissionsController(UserRegistryService userRegistryService,
                                     GroupRegistryService groupRegistryService,
                                     UserPermissionsService userPermissionsService) {
        this.userRegistryService = userRegistryService;
        this.groupRegistryService = groupRegistryService;
        this.userPermissionsService = userPermissionsService;
    }

    @GetMapping(value = "/email/{email}")
    public ResponseEntity<List<String>> getUserPermissions(@PathVariable(value = "email") String email) {
        Optional<User> user = userRegistryService.getRegistryByEmail(email);
        if (!user.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        Optional<List<Group>> groups = groupRegistryService.getRegistriesByGroupCondominium(
                user.get().getGroupCondominiumList());
        if (!groups.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        List<String> userPermissions = userPermissionsService.formatUserPermissions(groups.get());
        return new ResponseEntity<>(userPermissions, HttpStatus.OK);
    }
}
