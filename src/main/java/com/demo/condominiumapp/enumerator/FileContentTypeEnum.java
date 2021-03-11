package com.demo.condominiumapp.enumerator;

import lombok.Getter;

@Getter
public enum FileContentTypeEnum {

    USER("Usuario"),
    GROUP("Grupo");

    private String value;

    FileContentTypeEnum(String value) {
        this.value = value;
    }
}
