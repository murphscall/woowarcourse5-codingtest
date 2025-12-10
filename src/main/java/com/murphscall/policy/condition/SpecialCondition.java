package com.murphscall.policy.condition;

import com.murphscall.domain.Order;
import java.time.LocalDate;
import java.util.List;

public class SpecialCondition implements DiscountCondition{

    private static final List<Integer> STAR_DATE = List.of(3,10,17,24,25,31);

    @Override
    public boolean isSatisfiedBy(Order order) {

        LocalDate date = order.getOrderedAt();



        return STAR_DATE.contains(date.getDayOfMonth());
    }
}
