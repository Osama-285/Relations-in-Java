package com.example.dbExample.util;

public enum Authority {
    READ,
    WRITE,
    UPDATE,
    USER, // Can update delete self object, read anything
    ADMIN
}
