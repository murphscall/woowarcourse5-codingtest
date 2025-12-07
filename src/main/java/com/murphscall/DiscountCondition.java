package com.murphscall;

public interface DiscountCondition {
    boolean isSatisfiedBy(Order order);
}
