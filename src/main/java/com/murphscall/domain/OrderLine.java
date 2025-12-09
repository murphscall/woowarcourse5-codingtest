package com.murphscall.domain;


import com.murphscall.enums.FoodType;
import com.murphscall.enums.Menu;

public class OrderLine {
    private final Menu menu;
    private final int quantity;
    private final Money lineAmount;

    public OrderLine(Menu menu, int quantity) {
        this.menu = menu;
        this.quantity = quantity;
        this.lineAmount = calculateLineAmount();
    }

    private Money calculateLineAmount() {
        return menu.getWons().times(quantity);
    }


    public Money getLineAmount() {
        return lineAmount;
    }

    public boolean isSameType(FoodType type){
        return this.menu.getFoodType().equals(type);
    }

    public int getQuantity() {
        return quantity;
    }

    public Menu getMenu() {
        return menu;
    }

    @Override
    public String toString() {
        return menu.getDisplayName() + " " + quantity + "개";
    }
}
