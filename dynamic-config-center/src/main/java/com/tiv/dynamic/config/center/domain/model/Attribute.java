package com.tiv.dynamic.config.center.domain.model;

public class Attribute {

    private String attribute;

    private String value;

    public Attribute() {
    }

    public Attribute(String attribute, String value) {
        this.attribute = attribute;
        this.value = value;
    }

    public String getAttribute() {
        return attribute;
    }

    public void setAttribute(String attribute) {
        this.attribute = attribute;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Attribute{" +
                "attribute='" + attribute + '\'' +
                ", value='" + value + '\'' +
                '}';
    }

}
