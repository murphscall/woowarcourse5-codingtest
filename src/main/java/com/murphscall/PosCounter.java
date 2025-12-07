package com.murphscall;


import java.util.Arrays;
import java.util.List;

public class PosCounter {

    private final List<DiscountPolicy> discountPolicies;

    public PosCounter(DiscountPolicy... discountPolicies) {
        this.discountPolicies = Arrays.asList(discountPolicies);
    }

    public void processOrder(Order order) {

        // 할인전 가격
        Money totalPrice = order.getTotalAmount();
        // 할인 가격을 계산하라
        Money money = calculateTotalDiscount(order);
        // 할인된 가격을 계산하라
        Money finalAmount = totalPrice.minus(money);

        System.out.println("할인 전 가격: " + order.getTotalAmount());
        System.out.println("할인 가격 : " + money);
        System.out.println("할인된 가격 : " + totalPrice);
    }

    private Money calculateTotalDiscount(Order order) {
        Money sum = Money.ZERO;
        for(DiscountPolicy policy : discountPolicies){
            Money discount = policy.calculateDiscountAmount(order);
            sum = sum.plus(discount);
        }
        return sum;
    }



}
