package com.startjava.lesson_2_3_4.calculator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CalculatorTest {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Calculator calculator = new Calculator();
        String stopWord = " ";
        while (!"no".equals(stopWord)) {
            System.out.println("\n" + "Рад тебя видеть, друг! Начнем вычисления!"  + "\n");
            System.out.println("""
                    Знаки для вычисления представлены ниже:
                     "+" - для сложения,
                     "-" - для вычитания,
                     "*" - для умножения,
                     "/" - для деления,
                     "^" - для возведения числа в степень (после этого знака вводите степень в которую нужно возвести),
                     "%" - для того чтобы узнать остаток от деления.\s""" + "\n");
            System.out.print("Введите математическое выражение: ");

            calculator.split(reader.readLine());
            while (!calculator.testSign()) {//Присвоение знака и его знака
                System.out.print("Введите корректный знак из представленных выше: ");
                calculator.setSign(reader.readLine());
            }

            System.out.println("\n" + "Результат твоих вычислений: " + calculator.calculate() + "\n");
            do {
                System.out.print("Хотите продолжить вычисления? [yes/no]: ");
                stopWord = reader.readLine();
            } while (!"no".equals(stopWord) && !"yes".equals(stopWord));
        }
    }
}

