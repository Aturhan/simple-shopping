package com.abdullahturhan.shopping.shopping.enumType;

public enum Category {
    ELECTRONIC("Electronic"),
    MODA("Moda"),
    HOME("Home"),
    COSMETIC("Cosmetic"),
    ;

    private final String value;

    Category(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
