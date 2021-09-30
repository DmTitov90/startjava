package com.startjava.lesson_2_3_4.calculator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Calculator {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private double firstNumber;
    private String sign;
    private double secondNumber;

    public Calculator(String mathExpression) throws IOException {
        int pos = 0;
        String[] splitMathExpression = mathExpression.split(" ");
        for (String mathSplits : splitMathExpression) {
            splitMathExpression[pos++] = mathSplits;
        }
        firstNumber = Integer.parseInt(splitMathExpression[0]);
        sign = splitMathExpression[1];
        while (true) {
            if ("+".equals(sign) || "-".equals(sign) || "*".equals(sign) ||
                    "/".equals(sign) || "^".equals(sign) || "%".equals(sign)) {
                break;
            } else {
                System.out.print("Введите корректный знак из представленных выше: ");
                sign = reader.readLine();
            }
        }
        secondNumber = Integer.parseInt(splitMathExpression[2]);
    }

    public double calculate() throws IOException {

        return switch (sign) {
            case "+" -> firstNumber + secondNumber;
            case "-" -> firstNumber - secondNumber;
            case "*" -> firstNumber * secondNumber;
            case "/" -> firstNumber / secondNumber;
            case "^" -> Math.pow(firstNumber, secondNumber);
            case "%" -> Math.IEEEremainder(firstNumber, secondNumber);
            default -> 0.0;
        };
    }
}
