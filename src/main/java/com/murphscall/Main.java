package com.murphscall;


import com.murphscall.controller.OrderController;
import com.murphscall.enums.Menu;
import com.murphscall.policy.DiscountPolicy;
import com.murphscall.policy.HolidayPolicy;
import com.murphscall.policy.SpecialPolicy;
import com.murphscall.policy.condition.ChristmasCondition;
import com.murphscall.policy.ChristmasPolicy;
import com.murphscall.policy.condition.DesertCondition;
import com.murphscall.policy.DesertPolicy;
import com.murphscall.policy.condition.HolidayCondition;
import com.murphscall.policy.condition.PresentCondition;
import com.murphscall.policy.PresentPolicy;
import com.murphscall.policy.condition.SpecialCondition;
import com.murphscall.service.OrderService;
import com.murphscall.service.PosCounter;

public class Main {
    public static void main(String[] args) {

        DiscountPolicy specialPolicy = new SpecialPolicy(new SpecialCondition());
        DiscountPolicy holidayPolicy = new HolidayPolicy(new HolidayCondition());
        DiscountPolicy presentPolicy = new PresentPolicy(Menu.CHAMPAGNE, new PresentCondition());
        DiscountPolicy christmasPolicy = new ChristmasPolicy(new ChristmasCondition());
        DiscountPolicy desertPolicy = new DesertPolicy(new DesertCondition());

        PosCounter posCounter = new PosCounter(
                christmasPolicy, desertPolicy, presentPolicy, holidayPolicy, specialPolicy
        );

        OrderService orderService = new OrderService(posCounter);
        OrderController orderController = new OrderController(orderService);
        orderController.run();
    }
}