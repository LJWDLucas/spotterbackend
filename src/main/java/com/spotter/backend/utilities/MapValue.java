package com.spotter.backend.utilities;

public class MapValue {
    private String string;
    private int integer;

    public MapValue(String string) {
        this.string = string;
    }

    public MapValue(int integer) {
        this.integer = integer;
    }

    public String getString() {
        return string;
    }

    public int getInteger() {
        return integer;
    }
}
