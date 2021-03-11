package com.demo.condominiumapp.enumerator;

import lombok.Getter;

@Getter
public enum StringPatternEnum {

    COLUMN_PATTERN(";"),
    PAIR_LIST_PATTERN("\\[\\(|\\),?\\(|\\)]"),
    PAIR_PATTERN(",");

    private String value;

    StringPatternEnum(String value) {
        this.value = value;
    }
}
