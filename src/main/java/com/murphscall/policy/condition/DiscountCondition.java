package com.murphscall.policy.condition;

import com.murphscall.domain.Order;

public interface DiscountCondition {
    boolean isSatisfiedBy(Order order);
}
