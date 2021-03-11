package com.demo.condominiumapp.service.impl;

import com.demo.condominiumapp.domain.Group;
import com.demo.condominiumapp.domain.GroupCondominium;
import com.demo.condominiumapp.enumerator.FileContentTypeEnum;
import com.demo.condominiumapp.factory.GroupFactory;
import com.demo.condominiumapp.service.FileService;
import com.demo.condominiumapp.service.GroupRegistryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

@Service
public class GroupRegistryServiceImpl implements GroupRegistryService {

    private FileService fileService;

    @Autowired
    public GroupRegistryServiceImpl(FileService fileService) {
        this.fileService = fileService;
    }

    @Override
    public Optional<List<Group>> getRegistriesByGroupCondominium(List<GroupCondominium> groupCondominiumList) {
        List<Group> groups = new ArrayList<>();
        groupCondominiumList.forEach(groupCondominium -> {
            try {
                Stream<String> contents = fileService.getContentByType(FileContentTypeEnum.GROUP);
                Optional<Group> group = getRegistryByTypeAndCondominium(
                        contents,
                        groupCondominium.getGroupType(),
                        groupCondominium.getCondominiumId());

                if (group.isPresent()) {
                    groups.add(group.get());
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        if (groups.isEmpty()) {
            return Optional.empty();
        }
        return Optional.of(groups);
    }

    @Override
    public Optional<Group> getRegistryByTypeAndCondominium(Stream<String> contents, String groupType, Long condominiumId) {
        return contents
                .filter(content -> content.contains(groupType) && content.contains(String.valueOf(condominiumId)))
                .findFirst()
                .map(content -> GroupFactory.buildFrom(content));
    }
}
