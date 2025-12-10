package com.murphscall;


import static com.murphscall.EventConfig.CHRISTMAS_BASE_DISCOUNT;
import static com.murphscall.EventConfig.CHRISTMAS_DAILY_INCREMENT;
import static com.murphscall.EventConfig.CHRISTMAS_POLICY_NAME;
import static com.murphscall.EventConfig.EVENT_END_DATE;
import static com.murphscall.EventConfig.EVENT_START_DATE;
import static com.murphscall.EventConfig.PRESENT_MIN_PRICE_CONDITION;
import static com.murphscall.EventConfig.PRESENT_POLICY_NAME;
import static com.murphscall.EventConfig.SPECIAL_DISCOUNT_AMOUNT;
import static com.murphscall.EventConfig.SPECIAL_POLICY_NAME;
import static com.murphscall.EventConfig.WEEKDAY_POLICY_NAME;
import static com.murphscall.EventConfig.WEEKEND_DISCOUNT_AMOUNT;
import static com.murphscall.EventConfig.WEEKEND_POLICY_NAME;

import com.murphscall.controller.OrderController;
import com.murphscall.enums.Menu;
import com.murphscall.policy.DiscountPolicy;
import com.murphscall.policy.HolidayPolicy;
import com.murphscall.policy.SpecialPolicy;
import com.murphscall.policy.condition.ChristmasCondition;
import com.murphscall.policy.ChristmasPolicy;
import com.murphscall.policy.condition.DesertCondition;
import com.murphscall.policy.DesertPolicy;
import com.murphscall.policy.condition.DiscountCondition;
import com.murphscall.policy.condition.HolidayCondition;
import com.murphscall.policy.condition.PresentCondition;
import com.murphscall.policy.PresentPolicy;
import com.murphscall.policy.condition.SpecialCondition;
import com.murphscall.service.OrderService;
import com.murphscall.service.PosCounter;

public class Main {
    public static void main(String[] args) {

        DiscountCondition christmasCondition = new ChristmasCondition(EVENT_START_DATE, EVENT_END_DATE);
        DiscountCondition specialCondition = new SpecialCondition();
        DiscountCondition holidayCondition = new HolidayCondition();
        DiscountCondition presentCondition = new PresentCondition(PRESENT_MIN_PRICE_CONDITION);
        DiscountCondition desertCondition = new DesertCondition();

        DiscountPolicy specialPolicy = new SpecialPolicy(SPECIAL_POLICY_NAME, SPECIAL_DISCOUNT_AMOUNT, specialCondition);
        DiscountPolicy holidayPolicy = new HolidayPolicy(WEEKEND_POLICY_NAME, WEEKEND_DISCOUNT_AMOUNT, holidayCondition);
        DiscountPolicy presentPolicy = new PresentPolicy(Menu.CHAMPAGNE, PRESENT_POLICY_NAME, presentCondition);
        DiscountPolicy christmasPolicy = new ChristmasPolicy(CHRISTMAS_POLICY_NAME,CHRISTMAS_BASE_DISCOUNT, CHRISTMAS_DAILY_INCREMENT, christmasCondition);
        DiscountPolicy desertPolicy = new DesertPolicy(WEEKDAY_POLICY_NAME, desertCondition);

        PosCounter posCounter = new PosCounter(
                christmasPolicy, desertPolicy, presentPolicy, holidayPolicy, specialPolicy
        );

        OrderService orderService = new OrderService(posCounter);
        OrderController orderController = new OrderController(orderService);
        orderController.run();
    }
}