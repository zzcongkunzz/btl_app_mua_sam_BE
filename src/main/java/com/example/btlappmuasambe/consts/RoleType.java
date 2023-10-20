package com.example.btlappmuasambe.consts;

public enum RoleType {
    NHAN_VIEN ("Nhân Viên"),
    Admin("Admin"),
    KHACH_HANG("Khách Hàng");


    private final String value;

    RoleType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
