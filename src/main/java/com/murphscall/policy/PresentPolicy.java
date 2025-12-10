package com.murphscall.policy;

import com.murphscall.enums.DiscountType;
import com.murphscall.enums.Menu;
import com.murphscall.policy.condition.DiscountCondition;
import com.murphscall.domain.Money;
import com.murphscall.domain.Order;

public class PresentPolicy extends DiscountPolicy {

    private final Menu presentMenu;

    public PresentPolicy(Menu presentMenu, String name, DiscountCondition... conditions) {
        super(name, DiscountType.GIFT, conditions);
        this.presentMenu = presentMenu;
    }

    @Override
    protected Money getDiscountAmount(Order order) {

        return presentMenu.getWons();
    }
}
