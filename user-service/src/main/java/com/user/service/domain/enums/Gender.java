package com.user.service.domain.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum Gender {

    MALE,
    FEMALE,
    UNSPECIFIED;

    @JsonCreator
    public static Gender fromString(String value) {
        return value == null ? null : Gender.valueOf(value.toUpperCase());
    }

    @JsonValue
    public String toValue() {
        return this.name();
    }
}
