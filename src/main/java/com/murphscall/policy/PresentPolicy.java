package com.murphscall.policy;

import com.murphscall.enums.DiscountType;
import com.murphscall.enums.Menu;
import com.murphscall.policy.condition.DiscountCondition;
import com.murphscall.domain.Money;
import com.murphscall.domain.Order;

public class PresentPolicy extends DiscountPolicy {

    private final Menu presentMenu;

    public PresentPolicy(Menu presentMenu, DiscountCondition... conditions) {
        super("증정 이벤트", DiscountType.GIFT, conditions);
        this.presentMenu = presentMenu;
    }

    @Override
    protected Money getDiscountAmount(Order order) {

        return presentMenu.getWons();
    }
}
