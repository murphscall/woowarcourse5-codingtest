package com.murphscall.policy;

import com.murphscall.enums.Menu;
import com.murphscall.policy.condition.DiscountCondition;
import com.murphscall.domain.Money;
import com.murphscall.domain.Order;

public class PresentPolicy extends DiscountPolicy {

    private static final Menu PRESENT_MENU = Menu.fromDisplayName("샴페인");

    public PresentPolicy(DiscountCondition... conditions) {
        super("증정 이벤트", conditions);
    }

    @Override
    protected Money getDiscountAmount(Order order) {

        return PRESENT_MENU.getWons();
    }
}
