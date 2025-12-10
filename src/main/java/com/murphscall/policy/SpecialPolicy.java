package com.murphscall.policy;

import com.murphscall.domain.Money;
import com.murphscall.domain.Order;
import com.murphscall.enums.DiscountType;
import com.murphscall.policy.condition.DiscountCondition;

public class SpecialPolicy extends DiscountPolicy{

    private final Money specialDiscount;

    public SpecialPolicy(String name, int specialDiscount, DiscountCondition... conditions) {
        super(name, DiscountType.DISCOUNT, conditions);
        this.specialDiscount = Money.wons(specialDiscount);
    }

    @Override
    protected Money getDiscountAmount(Order order) {
        return specialDiscount;
    }
}
