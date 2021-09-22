package com.startjava.lesson_1.calculator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Calculator {
    public static void main(String[] args) throws IOException {
        double result = 0;
        while (true) {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Рад тебя видеть, друг! Начнем вычисления!" + "\n");
            System.out.println("Введи первое число:");
            double firstNumber = Integer.parseInt(reader.readLine());
            System.out.println("""
                    Введи Знак:
                     "+" - для сложения,
                     "-" - для вычитания,
                     "*" - для умножения,
                     "/" - для деления,
                     "^" - для возведения числа в степень,
                     "%" - для того чтобы узнать остаток от деления.\s""");
            String sign = reader.readLine();
            System.out.println("Введи второе число, если ты выбрал возведение в степень, то напиши степень, " +
                    "в которую нужно возвести число: ");
            double secondNumber = Integer.parseInt(reader.readLine());

            result = switch (sign) {
                case "+" -> firstNumber + secondNumber;
                case "-" -> firstNumber - secondNumber;
                case "*" -> firstNumber * secondNumber;
                case "/" -> firstNumber / secondNumber;
                case "^" -> {
                    for (int i = 1; i <= secondNumber; i++) {
                        result *= firstNumber;
                    }
                    yield result;
                }
                case "%" -> firstNumber % secondNumber;
                default -> 0.0;
            };
            System.out.println("Результат твоих вычислений: " + result + "\n");
            System.out.println("Если хочешь продолжить вычисления, введи любой символ, ну или введи \"stop\", " +
                    "если закончил вычисления.");
            String stopWord = reader.readLine();
            if ("stop".equals(stopWord)) {
                break;
            }
        }
    }
}