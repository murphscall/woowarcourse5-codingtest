package com.murphscall;

import com.murphscall.domain.Money;
import com.murphscall.enums.Menu;
import java.time.LocalDate;

public class EventConfig {
    private static final int EVENT_YEAR = 2023;
    private static final int EVENT_MONTH = 12;

    public static final LocalDate EVENT_START_DATE = LocalDate.of(EVENT_YEAR, EVENT_MONTH, 1);
    public static final LocalDate EVENT_END_DATE = LocalDate.of(EVENT_YEAR, EVENT_MONTH, 31);
    public static final LocalDate CHRISTMAS_D_DAY = LocalDate.of(EVENT_YEAR, EVENT_MONTH, 25);


    public static final String CHRISTMAS_POLICY_NAME = "크리스마스 디데이 할인";
    public static final String WEEKDAY_POLICY_NAME = "평일 할인";
    public static final String WEEKEND_POLICY_NAME = "주말 할인";
    public static final String SPECIAL_POLICY_NAME = "특별 할인";
    public static final String PRESENT_POLICY_NAME = "증정 이벤트";


    public static final Menu PRESENT_MENU = Menu.CHAMPAGNE;
    public static final Money PRESENT_MIN_PRICE_CONDITION = Money.wons(120_000);
    public static final String PRESENT_MENU_NAME = "샴페인";

    public static final int CHRISTMAS_BASE_DISCOUNT = 1_000;
    public static final int CHRISTMAS_DAILY_INCREMENT = 100;
    public static final int WEEKDAY_DISCOUNT_AMOUNT = 2_023;
    public static final int WEEKEND_DISCOUNT_AMOUNT = 2_023;
    public static final int SPECIAL_DISCOUNT_AMOUNT = 1_000;

    private EventConfig() {}
}