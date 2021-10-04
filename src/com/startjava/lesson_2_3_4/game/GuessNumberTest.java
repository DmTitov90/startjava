package com.startjava.lesson_2_3_4.game;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * Creator Dmitrii Titov
 * Date 5.10.2021 Version 1.0.0
 */
public class GuessNumberTest {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("У каждого игрока по 10 попыток!" + "\n");
        System.out.print("Введите Имя первого игрока: " + "\n");
        Player playerOne = new Player(reader.readLine());
        System.out.print("Введите Имя второго игрока: " + "\n");
        Player playerTwo = new Player(reader.readLine());
        GuessNumber game = new GuessNumber(playerOne, playerTwo);
        String answer = " ";

        while (!"no".equals(answer)) {
            game.start();
            do {
                System.out.print("\n" + "Хотите продолжить игру? [yes/no]:");
                answer = reader.readLine();
            } while (!"no".equals(answer) && !"yes".equals(answer));
        }
    }
}