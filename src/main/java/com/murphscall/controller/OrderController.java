package com.murphscall.controller;


import com.murphscall.dto.OrderResponse;
import com.murphscall.service.OrderService;
import com.murphscall.view.InputView;
import com.murphscall.view.OutputView;

public class OrderController {
    private OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    public void run(){
        String visitDate = InputView.visitDateInput();
        String orderMenu = InputView.orderMenuInput();

        OrderResponse orderResponse = orderService.createOrder(visitDate, orderMenu);
        OutputView.printResult(orderResponse);

    }

}
