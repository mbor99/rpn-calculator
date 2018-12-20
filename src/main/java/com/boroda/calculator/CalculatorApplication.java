package com.boroda.calculator;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

@SpringBootApplication
public class CalculatorApplication {


    public static void main(String[] args) {
        Stack<String> stack = new Stack<>();
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String inputString;

        for (; ; ) {
            try {
                inputString = in.readLine();

                if (inputString == null || inputString.equals("q")) break;

                rpnCalc(stack, inputString);

            } catch (Exception e) {
                System.out.println("Something goes wrong. Resetting stack");
            }
        }
    }

    public static Stack<String> rpnCalc(Stack<String> stack, String s) {
        stack.addAll(Arrays.asList(s.trim().split("[ \t]+")));
        if (s.trim().split("[ \t]+").length == 1 && isNumeric(s)) {
            System.out.println(stack.peek());
        }

        if (stack.size() > 2 && isOperation(stack.peek())) {
            stack.push(calc(stack.pop(), stack.pop(), stack.pop()));
            System.out.println(stack.peek());
        }
        return stack;
    }


    private static String calc(String operation, String last, String beforeLast) {
        switch (operation) {
            case "+":
                return String.valueOf(Double.parseDouble(last) + Double.parseDouble(beforeLast));
            case "-":
                return String.valueOf(Double.parseDouble(beforeLast) - Double.parseDouble(last));
            case "*":
                return String.valueOf(Double.parseDouble(last) * Double.parseDouble(beforeLast));
            case "/":
                return String.valueOf(Double.parseDouble(beforeLast) / Double.parseDouble(last));
        }
        return null;
    }

    private static boolean isNumeric(String str) {
        try {
            Double.parseDouble(str);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }

    private static boolean isOperation(String str) {
        try {
            if (str.equals("+") || str.equals("-") || str.equals("*") || str.equals("/")) {
                return true;
            }
        } catch (Exception e) {
            return false;
        }
        return false;
    }
}