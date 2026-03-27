package com.ems.exceptions;

public class DuplicateEntry extends RuntimeException {
    public DuplicateEntry(String message) {
        super(message);
    }
}
