package com.startjava.lesson_2_3_4.game;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * Creator Dmitrii Titov
 * Date 6.10.2021 Version 1.0.2
 */
public class GuessNumberTest {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("У каждого игрока по 10 попыток!" + "\n");
        Player playerOne = new Player();
        Player playerTwo = new Player();
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