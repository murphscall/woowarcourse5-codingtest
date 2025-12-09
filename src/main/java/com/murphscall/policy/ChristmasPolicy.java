package com.murphscall.policy;

import com.murphscall.policy.condition.DiscountCondition;
import com.murphscall.Money;
import com.murphscall.Order;
import java.time.LocalDate;

public class ChristmasPolicy extends DiscountPolicy {

    private static final int BASE_DISCOUNT = 1_000;
    private static final int DAILY_INCREMENT = 100;

    public ChristmasPolicy(DiscountCondition... conditions) {
        super("크리스마스 할인",conditions);
    }

    @Override
    protected Money getDiscountAmount(Order order) {
        LocalDate date = order.getOrderedAt();
        int day = date.getDayOfMonth();

        int amount = BASE_DISCOUNT + (day - 1) * DAILY_INCREMENT;

        return Money.wons(amount);
    }

}
