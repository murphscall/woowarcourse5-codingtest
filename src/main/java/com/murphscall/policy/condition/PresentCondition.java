package com.murphscall.policy.condition;

import com.murphscall.domain.Money;
import com.murphscall.domain.Order;

public class PresentCondition implements DiscountCondition {

    private final Money presentPrice;

    public PresentCondition(Money presentPrice) {
        this.presentPrice = presentPrice;
    }

    @Override
    public boolean isSatisfiedBy(Order order) {
        Money totalPrice = order.getTotalAmount();
        return totalPrice.isGreaterThanOrEqual(presentPrice);
    }
}
