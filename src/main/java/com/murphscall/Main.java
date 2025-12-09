package com.murphscall;


import com.murphscall.policy.DiscountPolicy;
import com.murphscall.policy.condition.ChristmasCondition;
import com.murphscall.policy.ChristmasPolicy;
import com.murphscall.policy.condition.DesertCondition;
import com.murphscall.policy.DesertPolicy;
import com.murphscall.policy.condition.PresentCondition;
import com.murphscall.policy.PresentPolicy;

public class Main {
    public static void main(String[] args) {
        DiscountPolicy presentPolicy = new PresentPolicy(new PresentCondition());
        DiscountPolicy christmasPolicy = new ChristmasPolicy(new ChristmasCondition());
        DiscountPolicy desertPolicy = new DesertPolicy(new DesertCondition());

        PosCounter posCounter = new PosCounter(christmasPolicy, desertPolicy, presentPolicy);

        OrderService orderService = new OrderService(posCounter);
        OrderController orderController = new OrderController(orderService);
        orderController.run();
    }
}