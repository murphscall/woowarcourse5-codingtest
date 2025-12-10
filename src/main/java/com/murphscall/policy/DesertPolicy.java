package com.murphscall.policy;

import com.murphscall.enums.DiscountType;
import com.murphscall.policy.condition.DiscountCondition;
import com.murphscall.enums.FoodType;
import com.murphscall.domain.Money;
import com.murphscall.domain.Order;
import com.murphscall.domain.OrderLine;

public class DesertPolicy extends DiscountPolicy {

    private static final Money DISCOUNT_PER_DESSERT = Money.wons(2_023);

    public DesertPolicy(String name, DiscountCondition... conditions) {
        super(name, DiscountType.DISCOUNT, conditions);
    }

    @Override
    protected Money getDiscountAmount(Order order) {

        long dessertCount = order.getOrderLines().stream()
                .filter(line -> line.isSameType(FoodType.DESSERT))
                .mapToLong(OrderLine::getQuantity)
                .sum();

        if(dessertCount == 0){
            return Money.ZERO;
        }

        return DISCOUNT_PER_DESSERT.times(dessertCount);
    }
}
