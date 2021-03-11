package com.demo.condominiumapp.service.impl;

import com.demo.condominiumapp.enumerator.FileContentTypeEnum;
import com.demo.condominiumapp.service.FileService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

@Service
public class FileServiceImpl implements FileService {

    @Value("${file-database.path}")
    private String databaseFilePath;

    @Override
    public Stream<String> getContentByType(FileContentTypeEnum fileContentType) throws IOException {
        Path path = Paths.get(databaseFilePath);
        Stream<String> fileLines = Files.lines(path);
        return fileLines.filter(file -> file.startsWith(fileContentType.getValue()));
    }
}
