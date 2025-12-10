package com.murphscall.policy;

import com.murphscall.enums.DiscountType;
import com.murphscall.policy.condition.DiscountCondition;
import com.murphscall.domain.Money;
import com.murphscall.domain.Order;
import java.time.LocalDate;

public class ChristmasPolicy extends DiscountPolicy {

    private final int baseDiscount;
    private final int dailyIncrement;

    public ChristmasPolicy(String name,int baseDiscount, int dailyIncrement, DiscountCondition... conditions) {
        super(name, DiscountType.DISCOUNT, conditions);
        this.baseDiscount = baseDiscount;
        this.dailyIncrement = dailyIncrement;
    }

    @Override
    protected Money getDiscountAmount(Order order) {
        LocalDate date = order.getOrderedAt();
        int day = date.getDayOfMonth();

        int amount = baseDiscount + (day - 1) * dailyIncrement;

        return Money.wons(amount);
    }
}
