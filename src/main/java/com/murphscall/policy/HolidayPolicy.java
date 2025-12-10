package com.murphscall.policy;

import com.murphscall.domain.Money;
import com.murphscall.domain.Order;
import com.murphscall.domain.OrderLine;
import com.murphscall.enums.DiscountType;
import com.murphscall.enums.FoodType;
import com.murphscall.policy.condition.DiscountCondition;

public class HolidayPolicy extends DiscountPolicy{

    private static final Money DISCOUNT_PER_HOLIDAY = Money.wons(2_023);

    public HolidayPolicy(DiscountCondition... conditions) {
        super("주말 할인", DiscountType.DISCOUNT, conditions);
    }

    @Override
    protected Money getDiscountAmount(Order order) {

        long holidayCount = order.getOrderLines().stream()
                .filter(line -> line.isSameType(FoodType.MAIN))
                .mapToLong(OrderLine::getQuantity)
                .sum();

        if(holidayCount == 0){
            return Money.ZERO;
        }

        return DISCOUNT_PER_HOLIDAY.times(holidayCount);
    }
}
