package com.startjava.lesson_2_3_4.calculator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Calculator {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public void calculate() throws IOException {
        int pos = 0;
        String spliter = reader.readLine();
        String[] mathSplit = spliter.split(" ");
        for (String mathSplits : mathSplit) {
            mathSplit[pos++] = mathSplits;
        }
        double firstNumber = Integer.parseInt(mathSplit[0]);
        String sign = mathSplit[1];
        while (true)
            if ("+".equals(sign) || "-".equals(sign) || "*".equals(sign) ||
                    "/".equals(sign) || "^".equals(sign) || "%".equals(sign)) {
                sign = sign;
                break;
            } else {
                System.out.print("Введите корректный знак из представленных выше: ");
                sign = reader.readLine();
            }
        double secondNumber = Integer.parseInt(mathSplit[2]);

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
