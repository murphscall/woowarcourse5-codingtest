package com.murphscall.policy;

import com.murphscall.domain.Money;
import com.murphscall.domain.Order;
import com.murphscall.domain.OrderLine;
import com.murphscall.enums.DiscountType;
import com.murphscall.enums.FoodType;
import com.murphscall.policy.condition.DiscountCondition;

public class HolidayPolicy extends DiscountPolicy{

    private final Money discountHoliday;

    public HolidayPolicy(String name, int discountHoliday, DiscountCondition... conditions) {
        super(name, DiscountType.DISCOUNT, conditions);
        this.discountHoliday = Money.wons(discountHoliday);
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

        return discountHoliday.times(holidayCount);
    }
}
