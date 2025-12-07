package com.murphscall;

public enum Menu {
    // 애피타이저
    MUSHROOM_SOUP("양송이수프", FoodType.APPETIZER, Money.wons(6_000)),
    TAPAS("타파스", FoodType.APPETIZER, Money.wons(5_500)),
    CAESAR_SALAD("시저샐러드", FoodType.APPETIZER, Money.wons(8_000)),

    // 메인
    T_BONE_STEAK("티본스테이크", FoodType.MAIN, Money.wons(55_000)),
    BARBECUE_RIB("바비큐립", FoodType.MAIN, Money.wons(54_000)),
    SEAFOOD_PASTA("해산물파스타", FoodType.MAIN, Money.wons(35_000)),
    CHRISTMAS_PASTA("크리스마스파스타", FoodType.MAIN, Money.wons(25_000)),

    // 디저트
    CHOCOLATE_CAKE("초코케이크", FoodType.DESSERT, Money.wons(15_000)),
    ICE_CREAM("아이스크림", FoodType.DESSERT, Money.wons(5_000)),

    // 음료
    ZERO_COLA("제로콜라", FoodType.DRINK, Money.wons(3_000)),
    RED_WINE("레드와인", FoodType.DRINK, Money.wons(60_000)),
    CHAMPAGNE("샴페인", FoodType.DRINK, Money.wons(25_000));

    private final String displayName;
    private final FoodType foodType;
    private final Money wons;

    Menu(String displayName, FoodType foodType, Money wons) {
        this.displayName = displayName;
        this.foodType = foodType;
        this.wons = wons;
    }


    public String getDisplayName() {
        return displayName;
    }

    public FoodType getFoodType() {
        return foodType;
    }

    public Money getWons() {
        return wons;
    }

    public boolean isCategory(FoodType category) {
        return this.foodType == category;
    }

    public boolean isDessert() {
        return this.foodType == FoodType.DESSERT;
    }

    // 입력 문자열 → MenuItem 찾기용 헬퍼
    public static Menu fromDisplayName(String name) {
        for (Menu item : values()) {
            if (item.displayName.equals(name)) {
                return item;
            }
        }
        throw new IllegalArgumentException("존재하지 않는 메뉴입니다: " + name);
    }
}
