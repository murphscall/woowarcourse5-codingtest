package com.murphscall.enums;

public enum FoodType {
    APPETIZER("애피타이저"),
    MAIN("메인"),
    DESSERT("디저트"),
    DRINK("음료");

    private final String displayName;

    FoodType(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}
