package com.murphscall.enums;

import com.murphscall.domain.Money;
import java.util.Optional;

public enum Badge {
    STAR("별",Money.wons(5_000), Money.wons(10_000)),
    TREE("트리",Money.wons(10_000), Money.wons(20_000)),
    SANTA("산타",Money.wons(20000), null);

    private final String name;
    private final Money min;
    private final Money max;

    Badge(String name , Money min, Money max) {
        this.name = name;
        this.min = min;
        this.max = max;
    }

    public static Optional<Badge> of(Money totalDiscountMoney) {
        for(Badge badge : Badge.values()) {
            boolean min = totalDiscountMoney.isGreaterThanOrEqual(badge.min);
            boolean max = (badge.max == null) ? true : totalDiscountMoney.isLessThan(badge.max);

            if(min && max) return Optional.of(badge);
        }
        return Optional.empty();
    }

    public String getName() {
        return name;
    }
}
