package com.murphscall.policy.condition;

import com.murphscall.domain.Order;
import java.time.LocalDate;

public class ChristmasCondition implements DiscountCondition {

    private final LocalDate startDate;
    private final LocalDate endDate;

    public ChristmasCondition(final LocalDate startDate, final LocalDate endDate) {
        this.startDate = startDate;
        this.endDate = endDate;
    }

    @Override
    public boolean isSatisfiedBy(Order order) {

        LocalDate date = order.getOrderedAt();

        return !date.isBefore(startDate) && !date.isAfter(endDate);
    }
}
