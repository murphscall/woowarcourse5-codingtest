package com.murphscall.view;


import com.murphscall.domain.Money;
import com.murphscall.domain.OrderLine;
import com.murphscall.dto.DiscountResult;
import com.murphscall.dto.OrderResponse;
import com.murphscall.enums.Badge;
import java.util.List;
import java.util.Optional;

public class OutputView {

    public static void printResult(OrderResponse orderResponse) {
        printOrderMenus(orderResponse.getLines());
        printBeforeDiscountTotalPrice(orderResponse.getNoDiscountTotalPrice());
        printPresentMenu(orderResponse.isGift());
        printDiscountResults(orderResponse.getDiscountResults());
        printDiscountMoney(orderResponse.getTotalDiscountPrice());
        printTotalPaymentPrice(orderResponse.getTotalPaymentPrice());
        printEventBadge(orderResponse);

    }

    public static void printOrderMenus(List<OrderLine> orderLines){
        System.out.println("\n<주문 메뉴>");
        for(OrderLine orderLine : orderLines){
            System.out.println(orderLine.toString());
        }
    }

    public static void printBeforeDiscountTotalPrice(Money money){
        System.out.println("\n<할인 전 총주문 금액>");
        System.out.println(money.toString());
    }

    public static void printPresentMenu(boolean isGift){
        System.out.println("\n<증정 메뉴>");
        String result = isGift ? "샴페인 1개" : "없음";
        System.out.println(result);
    }

    public static void printDiscountResults(List<DiscountResult> discountResults){
        System.out.println("\n<혜택 내역>");
        for (DiscountResult discountResult : discountResults) {
            System.out.println(discountResult.toString());
        }
    }

    public static void printDiscountMoney(Money money){
        System.out.println("\n<총혜택 금액>");
        System.out.println(money.toString());
    }

    public static void printTotalPaymentPrice(Money money){
        System.out.println("\n<할인 후 예상 결제 금액>");
        System.out.println(money);
    }

    public static void printEventBadge(OrderResponse orderResponse){
        System.out.println("\n<12월 이벤트 배지>");
        Optional<Badge> badge = orderResponse.getBadge();
        badge.ifPresentOrElse(eventBadge -> System.out.println(eventBadge.getName()), () -> System.out.println("없음"));
    }

}
