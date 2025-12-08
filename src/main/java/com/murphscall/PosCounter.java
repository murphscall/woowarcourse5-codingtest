package com.murphscall;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PosCounter {

    private final List<DiscountPolicy> discountPolicies;

    public PosCounter(DiscountPolicy... discountPolicies) {
        this.discountPolicies = Arrays.asList(discountPolicies);
    }

    public OrderResponse processOrder(Order order) {

        // 주문 메뉴
        List<OrderLine> orderLines = order.getOrderLines();
        // 할인전 총 주문 금액
        Money totalPrice = order.getTotalAmount();
        // 혜택 내역
        List<DiscountResult> discountResults = calculateTotalDiscount(order);


        return OrderResponse.of(orderLines, totalPrice, discountResults);
    }

    private List<DiscountResult> calculateTotalDiscount(Order order) {

        List<DiscountResult> result = new ArrayList<>();

        for(DiscountPolicy policy : discountPolicies){
            Money discount = policy.calculateDiscountAmount(order);
            result.add(new DiscountResult(policy.getName(), discount));
        }
        return result;
    }



}
