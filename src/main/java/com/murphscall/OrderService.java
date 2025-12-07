package com.murphscall;

import java.time.LocalDate;
import java.util.List;

public class OrderService {
    private PosCounter posCounter;

    public OrderService(PosCounter posCounter) {
        this.posCounter = posCounter;
    }

    public void createOrder(String visitDate, String menus){

        // 문자열 파싱
        int day = Integer.parseInt(visitDate);
        LocalDate date = LocalDate.of(2023,12, day);
        List<OrderLine> orderLines = OrderInputParser.parseOrderLine(menus);

        // order 만들기
        Order order  = new Order(orderLines, date);

        posCounter.processOrder(order);

    }

}
