package com.murphscall;

import java.util.List;

public class OutputView {

    public static void printResult(OrderResponse orderResponse) {
        printOrderMenu(orderResponse.getLines());
        printOriginalAmount(orderResponse.getTotalPrice());
        printGifts(orderResponse);
        printBenefitDetails(orderResponse.getDiscountResults(), orderResponse.isGift());
        printTotals(orderResponse);
    }

    private static void printOrderMenu(List<OrderLine> lines) {
        System.out.println("<주문 메뉴>");
        if (lines == null || lines.isEmpty()) {
            System.out.println("없음");
        } else {
            for (OrderLine line : lines) {
                System.out.printf("%s %d개%n",
                        line.getMenu().getDisplayName(),
                        line.getQuantity());
            }
        }
        System.out.println();
    }

    private static void printOriginalAmount(Money original) {
        System.out.println("<할인 전 총주문 금액>");
        System.out.println(formatMoney(original));
        System.out.println();
    }

    private static void printGifts(OrderResponse orderResponse) {
        System.out.println("<증정 메뉴>");
        if (orderResponse.isGift()) {
            // OrderResponse 에 샴페인 정보가 따로 있으면 그 정보를 사용하도록 변경 가능
            System.out.println("샴페인 1개");
        } else {
            System.out.println("없음");
        }
        System.out.println();
    }

    private static void printBenefitDetails(List<DiscountResult> discountResults, boolean hasGift) {
        System.out.println("<혜택 내역>");

        if (discountResults == null || discountResults.isEmpty()) {
            System.out.println("없음");
        } else {
            for (DiscountResult result : discountResults) {
                // DiscountResult이 public 필드가 아니라면 getter 사용 (예: result.getPolicyName(), result.getDiscountAmount())
                System.out.printf("%s: -%s%n",
                        result.policyName(),
                        formatMoney(result.discountAmount()));
            }
        }

        if (hasGift) {
            // 증정은 결제 차감 항목이 아니므로 출력만 추가
            System.out.printf("증정 이벤트: %s%n", "-" + formatMoney(Money.wons(25_000)));
        }

        System.out.println();
    }

    private static void printTotals(OrderResponse orderResponse) {
        System.out.println("<총혜택 금액>");

        Money totalDiscount = orderResponse.getTotalDiscountPrice(); // 결제 차감되는 할인 합계
        Money displayedTotal = totalDiscount;

        if (orderResponse.isGift()) {
            // 표시용 총혜택에는 증정의 가치도 포함
            displayedTotal = displayedTotal.plus(Money.wons(25_000));
        }

        System.out.println(formatMoney(displayedTotal));
        System.out.println();

        System.out.println("<할인 후 예상 결제 금액>");
        Money finalPayment = orderResponse.getTotalPrice().minus(totalDiscount);
        System.out.println(formatMoney(finalPayment));
        System.out.println();
    }

    // 현재 Money 클래스의 toString()이 포맷을 제공하지 않으면 여기서 포맷을 구현하세요.
    private static String formatMoney(Money money) {
        return money.toString();
    }
}
