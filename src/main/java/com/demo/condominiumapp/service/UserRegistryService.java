package com.demo.condominiumapp.service;

import com.demo.condominiumapp.domain.User;

import java.util.Optional;

public interface UserRegistryService {

    Optional<User> getRegistryByEmail(String email);
}
