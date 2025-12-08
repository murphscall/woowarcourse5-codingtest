package com.murphscall;

import java.util.List;
import java.util.Map;

public class OrderResponse {
    private List<OrderLine> lines;
    private Money totalPrice;
    private Money totalDiscountPrice;
    private boolean gift;
    private List<DiscountResult> discountResults;

    private OrderResponse(List<OrderLine> lines, Money totalPrice, List<DiscountResult> discountResults) {
        this.lines = lines;
        this.totalPrice = totalPrice;
        this.discountResults = discountResults;
        this.gift = isGift(totalPrice);
        this.totalDiscountPrice = calculateTotalDiscount(discountResults);
    }

    public static OrderResponse of(List<OrderLine> lines, Money totalPrice, List<DiscountResult> discountResults) {
        return new OrderResponse(lines, totalPrice, discountResults);
    }

    private boolean isGift(Money totalPrice){
        if(totalPrice.isGreaterThanOrEqual(Money.wons(120_000))){
            return true;
        }
        return false;
    }

    private Money calculateTotalDiscount(List<DiscountResult> discountResults){
        return discountResults.stream().map(DiscountResult::discountAmount).reduce(Money.ZERO, Money::plus);
    }

    public List<OrderLine> getLines() {
        return lines;
    }

    public Money getTotalPrice() {
        return totalPrice;
    }

    public Money getTotalDiscountPrice() {
        return totalDiscountPrice;
    }

    public boolean isGift() {
        return gift;
    }

    public List<DiscountResult> getDiscountResults() {
        return discountResults;
    }
}
