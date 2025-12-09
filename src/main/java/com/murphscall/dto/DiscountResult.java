package com.murphscall.dto;

import com.murphscall.domain.Money;

public record DiscountResult(String policyName, Money discountAmount) {
    @Override
    public String toString() {
        return policyName + ": -" + discountAmount.toString();
    }
}
