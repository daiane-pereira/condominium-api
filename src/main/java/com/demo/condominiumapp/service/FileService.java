package com.demo.condominiumapp.service;

import com.demo.condominiumapp.enumerator.FileContentTypeEnum;

import java.io.IOException;
import java.util.stream.Stream;

public interface FileService {

    Stream<String> getContentByType(FileContentTypeEnum fileContentType) throws IOException;
}
