package com.murphscall;

import java.time.LocalDate;
import java.util.List;

public class Order {
    private final List<OrderLine> orderLines;
    private final LocalDate orderedAt;
    private final Money totalAmount;

    public Order(List<OrderLine> orderLines, LocalDate orderedAt) {
        this.orderLines = orderLines;
        this.orderedAt = orderedAt;
        this.totalAmount = calculateTotalAmount();
    }

    private Money calculateTotalAmount(){
        return orderLines.stream()
                .map(OrderLine::getLineAmount)
                .reduce(Money.ZERO, Money::plus);
    }

}
