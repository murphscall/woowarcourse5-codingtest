package com.murphscall;

import java.time.LocalDate;
import java.util.List;

public class ChristmasPolicy extends DiscountPolicy {

    private static final int BASE_DISCOUNT = 1_000;
    private static final int DAILY_INCREMENT = 100;

    protected ChristmasPolicy(DiscountCondition... conditions) {
        super(conditions);
    }

    @Override
    protected Money getDiscountAmount(Order order) {
        LocalDate date = order.getOrderedAt();
        int day = date.getDayOfMonth();

        int amount = BASE_DISCOUNT + (day - 1) * DAILY_INCREMENT;

        return Money.wons(amount);
    }

}
