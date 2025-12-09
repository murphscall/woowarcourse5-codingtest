package com.murphscall.policy.condition;

import com.murphscall.Order;
import java.time.LocalDate;

public class ChristmasCondition implements DiscountCondition {
    @Override
    public boolean isSatisfiedBy(Order order) {

        LocalDate date = order.getOrderedAt();
        LocalDate startDate = LocalDate.of(2023, 12, 1);
        LocalDate endDate = LocalDate.of(2023, 12, 25);

        return !date.isBefore(startDate) && !date.isAfter(endDate);
    }
}
