package com.android.scientificcalci;

public class Factorial {


    public static long factorial(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Factorial is not defined for negative numbers");
        }
        if (n == 0 || n == 1) {
            return 1;
        }
        long result = 1;
        for (int i = 2; i <= n; i++) {
            result *= i;
        }
        return result;
    }

    public static String calculateFactorials(String expression) {
        StringBuilder result = new StringBuilder();
        String[] parts = expression.split("(?=[+-])"); // Split using lookahead to preserve the sign
        for (String part : parts) {
            if (part.contains("!")) {
                int number = Integer.parseInt(part.replaceAll("[^0-9-]", ""));
                long factorialResult = factorial(number);
                expression = expression.replace(part, Long.toString(factorialResult));
            }
        }
        return expression;
    }


}


