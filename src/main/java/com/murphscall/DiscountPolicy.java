package com.murphscall;

import java.util.Arrays;
import java.util.List;

public abstract class DiscountPolicy {

    private final List<DiscountCondition> conditions;

    protected DiscountPolicy(DiscountCondition... conditions) {
        this.conditions = Arrays.asList(conditions);
    }


    public Money calculateDiscountAmount(Order order) {
        for(DiscountCondition condition : conditions){
            if(condition.isSatisfiedBy(order)){
                return getDiscountAmount(order);
            }
        }
        return Money.ZERO;
    }

    protected abstract Money getDiscountAmount(Order order);

}
