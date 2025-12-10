package com.murphscall.dto;

import com.murphscall.domain.Money;
import com.murphscall.domain.OrderLine;
import com.murphscall.enums.Badge;
import java.util.List;
import java.util.Optional;

public class OrderResponse {
    private List<OrderLine> lines;
    private Money noDiscountTotalPrice;
    private List<DiscountResult> discountResults;
    private Money totalDiscountPrice;
    private Money totalPaymentPrice;
    private Badge badge;

    private OrderResponse(List<OrderLine> lines,
                          Money noDiscountTotalPrice,
                          List<DiscountResult> discountResults,
                          Money totalDiscountPrice,
                          Money totalPaymentPrice
    ) {
        this.lines = lines;
        this.noDiscountTotalPrice = noDiscountTotalPrice;
        this.discountResults = discountResults;
        this.totalDiscountPrice = totalDiscountPrice;
        this.totalPaymentPrice = totalPaymentPrice;
        this.badge = Badge.of(totalDiscountPrice).orElse(null);
    }

    public static OrderResponse of(
            List<OrderLine> lines,
            Money totalPrice,
            List<DiscountResult> discountResults,
            Money totalDiscountPrice,
            Money totalPaymentPrice
    ) {
        return new OrderResponse(lines, totalPrice, discountResults, totalDiscountPrice, totalPaymentPrice);
    }

    public Optional<Badge> getBadge() {
        return Optional.ofNullable(badge);
    }

    public List<OrderLine> getLines() {
        return lines;
    }

    public Money getNoDiscountTotalPrice() {
        return noDiscountTotalPrice;
    }

    public List<DiscountResult> getDiscountResults() {
        return discountResults;
    }

    public Money getTotalDiscountPrice() {
        return totalDiscountPrice;
    }

    public Money getTotalPaymentPrice() {
        return totalPaymentPrice;
    }
}
