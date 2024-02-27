package com.sfedu.task2;

import com.sfedu.task1.CustomStack;

public class Calc {
    private String expression;

    public Calc(String expression) {
        this.expression = expression;
    }

    public String toPoliz() {
        String[] split = expression.split(" ");
        StringBuilder output = new StringBuilder();
        CustomStack<String> stack = new CustomStack<>();

        for (String s : split) {
            if (isOperator(s)) {
                while (!stack.isEmpty() && isOperator(stack.peek()) && getPriority(stack.peek()) >= getPriority(s)) {
                    output.append(stack.pop()).append(' ');
                }
                stack.push(s);
            } else if ("(".equals(s)) {
                stack.push(s);
            } else if (")".equals(s)) {
                while (!stack.isEmpty() && !"(".equals(stack.peek())) {
                    output.append(stack.pop()).append(' ');
                }
                stack.pop();
                if (!stack.isEmpty() && isOperator(stack.peek())) {
                    output.append(stack.pop()).append(' ');
                }
            } else {
                output.append(s).append(' ');
            }
        }

        while (!stack.isEmpty()) {
            output.append(stack.pop()).append(' ');
        }

        return output.toString().trim();
    }

    public double calculate() {
        String poliz = toPoliz();
        String[] split = poliz.split(" ");
        CustomStack<Double> stack = new CustomStack<>();

        for (String s : split) {
            if (isOperator(s)) {
                double a = stack.pop();
                double b = stack.pop();
                switch (s) {
                    case "+":
                        stack.push(b + a);
                        break;
                    case "-":
                        stack.push(b - a);
                        break;
                    case "*":
                        stack.push(b * a);
                        break;
                    case "/":
                        stack.push(b / a);
                        break;
                }
            } else {
                stack.push(Double.parseDouble(s));
            }
        }

        return stack.pop();
    }

    private boolean isOperator(String s) {
        return "+".equals(s) || "-".equals(s) || "*".equals(s) || "/".equals(s);
    }

    private static int getPriority(String operator) {
        return switch (operator) {
            case "+", "-" -> 1;
            case "*", "/" -> 2;
            default -> -1;
        };
    }
}
