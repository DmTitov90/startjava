package com.startjava.lesson_1.game;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MyFirstGame {
    public static void main(String[] args) throws IOException {
        int targetNumber = (int) (Math.random() * 100 + 1);
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Привет! Попробуй угадать число, которое было загадано твоей программой");
        int count = 0;
        while (true) {
            count++;
            int playerNumber = Integer.parseInt(reader.readLine());
            if (playerNumber == targetNumber) {
                System.out.println("Каким то образом вы угадали число. Красавчик !");
                break;
            } else if (playerNumber > targetNumber) {
                System.out.println("Ты не угадал.Число больше того, которое загадал Всемогущий");
            } else {
                System.out.println("Ты не угадал.Число меньше того которое загадал Всемогущий");
            }
            System.out.println("Попробуйте еще раз.");
        }
        
        if (count <= 3) {
            System.out.println("Срочно иди в казино или на ТВ программу " +
                    "\"Кто хочет стать экстрасенсом?\"!!!Колличество попыток: " + count + "  Отлично.");
        } else if (count <= 10) {
            System.out.println("А ты хорош! Колличество попыток: " + count + " попыток.");
        } else if (count <= 15) {
            System.out.println("Нужно тренироваться. Ты угадали числа за: " + count + " попыток, не плохо");
        } else
            System.out.println("Угадывать это не твое. Ты угадали числа за: " + count + " попыток.");
    }
}