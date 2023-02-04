package com.Mortgage.Console;

import java.util.Scanner;

public class Console {
    private static  Scanner userInput = new Scanner(System.in);
    public static double readNumber(String prompt){
        return userInput.nextDouble();
    }
    public static double readNumber(String prompt, double min, double max){
        double value;
        while (true) {
            System.out.println(prompt);
            value = userInput.nextDouble();
            if (value >= min && value <= max)
                break;
            System.out.println("Please enter a number within the range of ( greater than " + min +" - "+max+" )");
        }
        return value;
    }
}
