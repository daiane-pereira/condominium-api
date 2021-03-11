package com.demo.condominiumapp.service;

import com.demo.condominiumapp.domain.Group;
import com.demo.condominiumapp.domain.GroupCondominium;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public interface GroupRegistryService {

    Optional<List<Group>> getRegistriesByGroupCondominium(List<GroupCondominium> groupCondominiumList);

    Optional<Group> getRegistryByTypeAndCondominium(Stream<String> contents, String groupType, Long condominiumId);
}
