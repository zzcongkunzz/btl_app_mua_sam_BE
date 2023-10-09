package com.example.btlappmuasambe.consts;

public enum GenderType {
    Nam ("Nam"),

    Nu("Nữ");

    private final String value;

    GenderType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
