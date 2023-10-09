package com.example.btlappmuasambe.consts;

public enum SortType {
    NEW ("NEW"),
    HOT_SELLING("HOT SELLING"),
    PRICE_ASC("PRICE ASC"),
    PRICE_DESC("PRICE DESC");


    private final String value;

    SortType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
