package com.murphscall;


import java.util.List;

public class OutputView {

    public static void printResult(OrderResponse orderResponse) {
        printOrderMenus(orderResponse.getLines());
        System.out.println();
        printBeforeDiscountTotalPrice(orderResponse.getNoDiscountTotalPrice());
        System.out.println();
        printPresentMenu(orderResponse.getDiscountResults());
        System.out.println();
        printDiscountResults(orderResponse.getDiscountResults());
        System.out.println();
        System.out.println("<총혜택 금액>");
        System.out.println(orderResponse.getTotalDiscountPrice());
        System.out.println();
        System.out.println("<할인 후 예상 결제 금액>");
        System.out.println(orderResponse.getTotalPaymentPrice());


    }

    public static void printOrderMenus(List<OrderLine> orderLines){
        System.out.println("주문 메뉴>");
        for(OrderLine orderLine : orderLines){
            System.out.println(orderLine.toString());
        }
    }

    public static void printBeforeDiscountTotalPrice(Money money){
        System.out.println("<할인 전 총주문 금액>");
        System.out.println(money.toString());
    }

    public static void printPresentMenu(List<DiscountResult> discountResults){
        System.out.println("<증정 메뉴>");
        boolean isGift = discountResults.stream().anyMatch(result -> result.policyName().equals("증정 이벤트"));
        String result = isGift ? "샴페인 1개" : "없음";
        System.out.println(result);
    }

    public static void printDiscountResults(List<DiscountResult> discountResults){
        System.out.println("<혜택 내역>");
        for (DiscountResult discountResult : discountResults) {
            System.out.println(discountResult.toString());
        }
    }

}
