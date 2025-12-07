package com.murphscall;



public class OrderController {
    private OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    public void run(){
        String visitDate = InputView.visitDateInput();
        String orderMenu = InputView.orderMenuInput();

        orderService.createOrder(visitDate, orderMenu);

    }

}
