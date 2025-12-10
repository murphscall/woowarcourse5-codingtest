package com.murphscall.dto;

import com.murphscall.domain.Money;
import com.murphscall.enums.DiscountType;

public record DiscountResult(String policyName, Money discountAmount, DiscountType discountType) {
    @Override
    public String toString() {
        return policyName + ": -" + discountAmount.toString();
    }
}
