package com.murphscall.policy.condition;

import com.murphscall.Money;
import com.murphscall.Order;

public class PresentCondition implements DiscountCondition {

    private static final Money PRESENT_PRICE_CONDITION = Money.wons(120_000);

    @Override
    public boolean isSatisfiedBy(Order order) {
        Money totalPrice = order.getTotalAmount();
        return totalPrice.isGreaterThanOrEqual(PRESENT_PRICE_CONDITION);
    }
}
