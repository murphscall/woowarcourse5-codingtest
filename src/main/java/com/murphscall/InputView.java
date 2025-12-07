package com.murphscall;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public static String visitDateInput(){
        System.out.println("날짜를 입력하세요");
        return Console.readLine();
    }

    public static String orderMenuInput(){
        System.out.println("음식과 수량을 입력하세요");
        return Console.readLine();
    }

}
