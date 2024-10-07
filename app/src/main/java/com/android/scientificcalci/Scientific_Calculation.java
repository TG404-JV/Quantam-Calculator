package com.android.scientificcalci;

import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;
import net.objecthunter.exp4j.function.Function;

import java.util.InputMismatchException;

public class Scientific_Calculation {

    public static double expression(String input) {
        try {
            // Replace special characters
            String input_1 = input.replace("×", "*");
            String input_2 = input_1.replace("÷", "/");
            String input_3 = input_2.replace("√", "sqrt");
            String input_4 = input_3.replace("cube", "cbrt");

            // Replace factorial (!) with factorial function
            input_4 = input_4.replaceAll("(\\d+)!", "factorial($1)");

            // Build expression
            Expression exp = new ExpressionBuilder(input_4)
                    .function(new Function("factorial", 1) {
                        @Override
                        public double apply(double... args) {
                            if (args[0] < 0 || args[0] != Math.floor(args[0])) {
                                throw new InputMismatchException("Factorial is only defined for non-negative integers");
                            }
                            int n = (int) args[0];
                            int result = 1;
                            for (int i = 2; i <= n; i++) {
                                result *= i;
                            }
                            return (double) result;
                        }
                    })
                    .build();

            // Evaluate the expression
            return exp.evaluate();
        } catch (IllegalArgumentException | InputMismatchException e) {
            // Handle invalid input expression
            System.err.println("Invalid input expression: " + e.getMessage());
            return Double.NaN; // or throw an exception, return a default value, etc.
        } catch (ArithmeticException e) {
            // Handle division by zero exception
            System.err.println("Division by zero error: " + e.getMessage());
            return Double.NaN; // or throw an exception, return a default value, etc.
        }
    }
}
