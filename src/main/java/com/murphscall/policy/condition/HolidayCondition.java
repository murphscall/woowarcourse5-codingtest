package com.murphscall.policy.condition;

import com.murphscall.domain.Order;
import java.time.DayOfWeek;
import java.time.LocalDate;

public class HolidayCondition implements DiscountCondition{
    @Override
    public boolean isSatisfiedBy(Order order) {

        LocalDate date = order.getOrderedAt();
        DayOfWeek dayOfWeek = date.getDayOfWeek();

        return dayOfWeek == DayOfWeek.FRIDAY
                || dayOfWeek == DayOfWeek.SATURDAY;

    }
}
