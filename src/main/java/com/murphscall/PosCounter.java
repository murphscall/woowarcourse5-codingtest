package com.murphscall;


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
        // 총 혜택 금액
        Money totalDiscountMoney =  discountResults.stream()
                .map(DiscountResult::discountAmount)
                .reduce(Money.ZERO, Money::plus);
        // 실제 할인 금액
        Money totalDiscountMoney2 = totalDiscountMoney.minus(Menu.fromDisplayName("샴페인").getWons());

        // 예상 결제 금액
        Money paymentPrice = totalPrice.minus(totalDiscountMoney2);

        return OrderResponse.of(orderLines, totalPrice, discountResults, totalDiscountMoney, paymentPrice);
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
