package com.dio.apiperson2.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum PhoneType {

    HOME("Home"),MOBILE("Mobile"),COMMERCIAL("Commercial");

    private final String description;
}
