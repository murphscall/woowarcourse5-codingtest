package com.murphscall.service;

import com.murphscall.domain.Order;
import com.murphscall.OrderInputParser;
import com.murphscall.domain.OrderLine;
import com.murphscall.dto.OrderResponse;
import java.time.LocalDate;
import java.util.List;

public class OrderService {
    private final PosCounter posCounter;

    public OrderService(PosCounter posCounter) {
        this.posCounter = posCounter;
    }

    public OrderResponse createOrder(String visitDate, String menus){

        // 문자열 파싱
        int day = Integer.parseInt(visitDate);
        LocalDate date = LocalDate.of(2023,12, day);
        List<OrderLine> orderLines = OrderInputParser.parseOrderLine(menus);

        // order 만들기
        Order order  = new Order(orderLines, date);

        return posCounter.processOrder(order);

    }

}
