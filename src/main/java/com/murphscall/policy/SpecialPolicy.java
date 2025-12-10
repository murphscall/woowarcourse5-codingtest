package com.murphscall.policy;

import com.murphscall.domain.Money;
import com.murphscall.domain.Order;
import com.murphscall.enums.DiscountType;
import com.murphscall.policy.condition.DiscountCondition;

public class SpecialPolicy extends DiscountPolicy{

    private static final Money SPECIAL_PER = Money.wons(1_000);

    public SpecialPolicy(DiscountCondition... conditions) {
        super("특별 할인", DiscountType.DISCOUNT, conditions);
    }

    @Override
    protected Money getDiscountAmount(Order order) {
        return SPECIAL_PER;
    }
}
