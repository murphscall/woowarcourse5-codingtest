package com.murphscall;



public class Main {
    public static void main(String[] args) {
        DiscountCondition discountCondition = new ChristmasCondition();
        DiscountPolicy discountPolicy = new ChristmasPolicy(discountCondition);

        PosCounter posCounter = new PosCounter(discountPolicy);

        OrderService orderService = new OrderService(posCounter);
        OrderController orderController = new OrderController(orderService);
        orderController.run();
    }
}