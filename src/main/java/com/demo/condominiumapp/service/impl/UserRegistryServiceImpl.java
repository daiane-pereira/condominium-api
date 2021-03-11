package com.demo.condominiumapp.service.impl;

import com.demo.condominiumapp.domain.User;
import com.demo.condominiumapp.enumerator.FileContentTypeEnum;
import com.demo.condominiumapp.factory.UserFactory;
import com.demo.condominiumapp.service.FileService;
import com.demo.condominiumapp.service.UserRegistryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Optional;
import java.util.stream.Stream;

@Service
public class UserRegistryServiceImpl implements UserRegistryService {

    private FileService fileService;

    @Autowired
    public UserRegistryServiceImpl(FileService fileService) {
        this.fileService = fileService;
    }

    @Override
    public Optional<User> getRegistryByEmail(String email) {
        Optional<User> user = Optional.empty();
        try {
            Stream<String> contents = fileService.getContentByType(FileContentTypeEnum.USER);
            user = contents
                    .filter(content -> content.contains(email))
                    .findFirst()
                    .map(content -> UserFactory.buildFrom(content));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return user;
    }
}
