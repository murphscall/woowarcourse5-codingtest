package com.murphscall.policy;

import com.murphscall.DiscountCondition;
import com.murphscall.Order;
import java.time.DayOfWeek;
import java.time.LocalDate;

public class DesertCondition implements DiscountCondition {
    @Override
    public boolean isSatisfiedBy(Order order) {

        LocalDate date = order.getOrderedAt();
        DayOfWeek dayOfWeek = date.getDayOfWeek();

        return dayOfWeek == DayOfWeek.SUNDAY
                || dayOfWeek == DayOfWeek.MONDAY
                || dayOfWeek == DayOfWeek.TUESDAY
                || dayOfWeek == DayOfWeek.WEDNESDAY
                || dayOfWeek == DayOfWeek.THURSDAY;
    }
}
