package com.demo.condominiumapp.enumerator;

import lombok.Getter;

@Getter
public enum UserTypeEnum {

    RESIDENT("Morador"),
    SYNDIC("Sindico");

    private String value;

    UserTypeEnum(String value) {
        this.value = value;
    }
}
