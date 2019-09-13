package com.kino.shop.exception;

public class UserNotFoundException extends RuntimeException {

    private String property;
    private Object value;

    public String getProperty() {
        return property;
    }

    public Object getValue() {
        return value;
    }

    public UserNotFoundException(String property, Object value) {
        super(format(property, value));
        this.property = property;
        this.value = value;
    }

    public UserNotFoundException(Throwable cause, String property, Object value) {
        super(format(property, value), cause);
        this.property = property;
        this.value = value;
    }

    private static String format(String property, Object value) {
        return String.format("User not found by property \"%s\" = %s!", property, value);
    }
}
