package com.demoex.try2.Entity;

import lombok.RequiredArgsConstructor;

public enum Role {
    USER("ПОЛЬЗОВАТЕЛЬ"),
    ADMIN("АДМИНИСТРАТОР");

    private final String name;

    Role(String name){
        this.name = name;
    }
}
