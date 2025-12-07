package com.murphscall;

import java.util.ArrayList;
import java.util.List;

public class OrderInputParser {
    public static List<OrderLine> parseOrderLine(String line) {
        List<OrderLine> orderLines = new ArrayList<>();

        String[] parts = line.split(",");
        for (String part : parts) {
            String[] partParts = part.split("-");
            String foodName = partParts[0];
            String quantity = partParts[1];
            Menu menu = Menu.fromDisplayName(foodName);
            orderLines.add(new OrderLine(menu, Integer.parseInt(quantity)));
        }

        return orderLines;
    }
}
