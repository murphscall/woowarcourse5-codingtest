package com.murphscall.policy.condition;

import com.murphscall.Order;

public interface DiscountCondition {
    boolean isSatisfiedBy(Order order);
}
