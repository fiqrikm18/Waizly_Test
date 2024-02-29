package com.fiqrikm18.implemetation_test_1.domain.security.user;

public enum UserRole {
    ADMIN("ADMIN"), SUPER_ADMIN("SUPER_ADMIN");

    private String val;
    UserRole(String val) {
        this.val = val;
    }

    public String getVal() {
        return val;
    }

    public void setVal(String val) {
        this.val = val;
    }
}
