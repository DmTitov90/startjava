package com.startjava.lesson_2_3.calculator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CalculatorTest {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Calculator calculator = new Calculator();
        String stopWord = " ";
        while (!"no".equals(stopWord)) {
            System.out.println("Рад тебя видеть, друг! Начнем вычисления!"  + "\n");
            System.out.print("Введи первое число: ");
            // Присвоение 1 числа
            calculator.setFirstNumber(Integer.parseInt(reader.readLine()));

            System.out.println("\n" + """
                    Знаки для вычисления представлены ниже:
                     "+" - для сложения,
                     "-" - для вычитания,
                     "*" - для умножения,
                     "/" - для деления,
                     "^" - для возведения числа в степень,
                     "%" - для того чтобы узнать остаток от деления.\s""" + "\n");
            System.out.print("Введите знак математической операции: ");
            //Присвоение знака и его знака
            while (!calculator.setSign(reader.readLine())) {
                System.out.print("Введите корректный знак из представленных выше: ");
            }

            System.out.print("\n" + "Введи второе число, если ты выбрал возведение в степень, то напиши степень, " +
                    "в которую нужно возвести число: ");
            // Присвоение 2 числа
            calculator.setSecondNumber(Integer.parseInt(reader.readLine()));
            System.out.println("\n" + "Результат твоих вычислений: " + calculator.calculate() + "\n");
            do {
                System.out.print("Хотите продолжить вычисления? [yes/no]: ");
                stopWord = reader.readLine();
            } while (!"no".equals(stopWord) && !"yes".equals(stopWord));
        }
    }
}

