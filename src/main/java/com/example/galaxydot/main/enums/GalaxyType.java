package com.example.galaxydot.main.enums;

public enum GalaxyType {

    ELLIPTICAL("Elliptical"),
    SPIRAL("Spiral"),
    IRREGULAR("Irregular");

    private final String type;

    GalaxyType(final String s) {
        type = s;
    }

    public String toString() {
        return type;
    }

}
