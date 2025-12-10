package com.murphscall.service;


import com.murphscall.enums.DiscountType;
import com.murphscall.enums.Menu;
import com.murphscall.domain.Money;
import com.murphscall.domain.Order;
import com.murphscall.domain.OrderLine;
import com.murphscall.dto.DiscountResult;
import com.murphscall.dto.OrderResponse;
import com.murphscall.policy.DiscountPolicy;
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
        // 증정 여부
        boolean isGift = discountResults.stream().anyMatch(result -> result.policyName().equals("증정 이벤트"));
        // 총 혜택 금액
        Money totalBenefitAmount = discountResults.stream()
                .map(DiscountResult::discountAmount)
                .reduce(Money.ZERO, Money::plus);
        // 실제 할인 금액
        Money actualDiscountAmount = discountResults.stream()
                .filter(result -> result.discountType() == DiscountType.DISCOUNT)
                .map(DiscountResult::discountAmount)
                .reduce(Money.ZERO, Money::plus);

        // 예상 결제 금액
        Money paymentPrice = totalPrice.minus(actualDiscountAmount);

        return OrderResponse.of(orderLines, totalPrice, discountResults, isGift , totalBenefitAmount, paymentPrice);
    }

    private List<DiscountResult> calculateTotalDiscount(Order order) {

        List<DiscountResult> result = new ArrayList<>();

        for(DiscountPolicy policy : discountPolicies){
            Money discount = policy.calculateDiscountAmount(order);
            if (!Money.ZERO.equals(discount)) {
                result.add(new DiscountResult(policy.getName(), discount , policy.getDiscountType()));
            }
        }
        return result;
    }

}
