package com.murphscall;

import java.util.Arrays;
import java.util.List;

public abstract class DiscountPolicy {
    private final String name;
    private final List<DiscountCondition> conditions;

    protected DiscountPolicy(String name, DiscountCondition... conditions) {
        this.name = name;
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

    public String getName() {
        return name;
    }

    protected abstract Money getDiscountAmount(Order order);

}
