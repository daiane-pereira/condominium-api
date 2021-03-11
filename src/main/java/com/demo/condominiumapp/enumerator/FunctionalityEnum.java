package com.demo.condominiumapp.enumerator;

import lombok.Getter;

@Getter
public enum FunctionalityEnum {

    RESERVATIONS("Reservas"),
    DELIVERY("Entregas"),
    USERS("Usuarios");

    private String value;

    FunctionalityEnum(String value) {
        this.value = value;
    }
}
