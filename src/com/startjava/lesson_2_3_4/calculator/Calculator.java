package com.startjava.lesson_2_3_4.calculator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Calculator {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private double firstNumber;
    private String sign;
    private double secondNumber;

    public void calculate() throws IOException {
        int pos = 0;
        String splitter = reader.readLine();
        String[] mathSplit = splitter.split(" ");
        for (String mathSplits : mathSplit) {
            mathSplit[pos++] = mathSplits;
        }
        firstNumber = Integer.parseInt(mathSplit[0]);
        sign = mathSplit[1];
        while (true) {
            if ("+".equals(sign) || "-".equals(sign) || "*".equals(sign) ||
                    "/".equals(sign) || "^".equals(sign) || "%".equals(sign)) {
                break;
            } else {
                System.out.print("Введите корректный знак из представленных выше: ");
                sign = reader.readLine();
            }
        }
        secondNumber = Integer.parseInt(mathSplit[2]);

        double result = switch (sign) {
            case "+" -> firstNumber + secondNumber;
            case "-" -> firstNumber - secondNumber;
            case "*" -> firstNumber * secondNumber;
            case "/" -> firstNumber / secondNumber;
            case "^" -> Math.pow(firstNumber, secondNumber);
            case "%" -> Math.IEEEremainder(firstNumber, secondNumber);
            default -> 0.0;
        };
        System.out.println("\n" + "Результат твоих вычислений: " + result + "\n");
    }
}
