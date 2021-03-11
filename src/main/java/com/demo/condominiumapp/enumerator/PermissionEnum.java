package com.demo.condominiumapp.enumerator;

import lombok.Getter;

@Getter
public enum PermissionEnum {

    WRITING("Escrita"),
    READING("Leitura"),
    NONE("Nenhuma");

    private String value;

    PermissionEnum(String value) {
        this.value = value;
    }
}
