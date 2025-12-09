package com.murphscall;

public record DiscountResult(String policyName, Money discountAmount) {
    @Override
    public String toString() {
        return policyName + ": -" + discountAmount.toString();
    }
}
