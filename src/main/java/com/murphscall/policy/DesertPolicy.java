package com.murphscall.policy;

import com.murphscall.policy.condition.DiscountCondition;
import com.murphscall.FoodType;
import com.murphscall.Money;
import com.murphscall.Order;
import com.murphscall.OrderLine;

public class DesertPolicy extends DiscountPolicy {

    private static final Money DISCOUNT_PER_DESSERT = Money.wons(2_023);

    public DesertPolicy(DiscountCondition... conditions) {
        super("평일할인", conditions);
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
