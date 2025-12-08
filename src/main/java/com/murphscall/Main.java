package com.murphscall;


import com.murphscall.policy.ChristmasCondition;
import com.murphscall.policy.ChristmasPolicy;
import com.murphscall.policy.DesertCondition;
import com.murphscall.policy.DesertPolicy;

public class Main {
    public static void main(String[] args) {
        DiscountPolicy christmasPolicy = new ChristmasPolicy(new ChristmasCondition());
        DiscountPolicy desertPolicy = new DesertPolicy(new DesertCondition());

        PosCounter posCounter = new PosCounter(christmasPolicy,desertPolicy);

        OrderService orderService = new OrderService(posCounter);
        OrderController orderController = new OrderController(orderService);
        orderController.run();
    }
}