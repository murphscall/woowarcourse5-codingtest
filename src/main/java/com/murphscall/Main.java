package com.murphscall;

public class Main {
    public static void main(String[] args) {
        PosCounter posCounter = new PosCounter();
        OrderService orderService = new OrderService(posCounter);
        OrderController orderController = new OrderController(orderService);
        orderController.run();
    }
}