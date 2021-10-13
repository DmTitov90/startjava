package com.startjava.lesson_2_3_4.game;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class GuessNumber {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private int targetNumber;
    private Player playerOne;
    private Player playerTwo;
    private String compareText;

    public GuessNumber(Player playerOne, Player playerTwo) {
        this.playerOne = playerOne;
        this.playerTwo = playerTwo;
    }

    public void start() throws Exception {

        targetNumber = (int) (Math.random() * 100 + 1);
        System.out.println(targetNumber);
        setUpCount(playerOne);
        setUpCount(playerTwo);
        System.out.println("\n" + "Привет! Попробуйте угадать число, которое было загадано программой");
        // Цикл для проверки числа
        int endCicle = 0;
        while (endCicle < 10) {
            endCicle++;
            if (!inputAndCheckPlayer(playerOne)) {
                printAttemptNumbers();
                break;
            }
            if (!inputAndCheckPlayer(playerTwo)) {
                printAttemptNumbers();
                break;
            }
            if (playerTwo.getCount() == 10) {
                printAttemptNumbers();
            }
        }
        // Объявление счета в игре

        System.out.println("\n" + "Счет в игре: " + playerOne.getName() + " " + playerOne.getScore() + " - "
                + playerTwo.getName() + " " + playerTwo.getScore() + "\n");

        deleteNumbers(playerOne);
        deleteNumbers(playerTwo);
    }

    private boolean inputAndCheckPlayer(Player player) throws IOException {
        System.out.print("\n" + player.getName() + " вводит число: ");
        player.setNumber(Integer.parseInt(reader.readLine()));
        if (player.getCount() == 10) {
            System.out.println("У " + player.getName() + " Закончились попытки");
            return true;
        } else if (compareNumbers(player)) {
            player.setScore(player.getScore() + 1);
            checkLuckLevel(player);
            System.out.println(player.getName() + " " + "Победитель !!!");
            return false;
        } else {
            System.out.println(compareText);
            return true;
        }
    }

    private void printAttemptNumbers() {
        outputArray(playerOne);
        outputArray(playerTwo);
    }

    private void outputArray(Player player) {
        int[] arrayPlayerOneCopy = Arrays.copyOf(player.getEnteredNumbers(), player.getCount());
        System.out.print("Числа игрока " + player.getName() + ": ");
        for (int asd : arrayPlayerOneCopy) {
            System.out.print(asd + " ");
        }
        System.out.println();
    }

    private void setUpCount(Player player) {
        player.setCount(0);
    }

    private boolean compareNumbers(Player player) {

        if (player.getEnteredNumbers()[player.getCount() - 1] == targetNumber) {
            System.out.println("Каким то образом вы угадали число. Красавчик !");
            return true;
        }
        compareText = player.getEnteredNumbers()[player.getCount() - 1] > targetNumber ?
                "Ты не угадал.Число больше того, которое загадал Всемогущий" :
                "Ты не угадал.Число меньше того, которое загадал Всемогущий";
        return false;
    }

    //Проверка кол-ва попыток
    private void checkLuckLevel(Player player) {
        if (player.getCount() <= 3) {
            System.out.println("Срочно иди в казино или на ТВ программу " +
                    "\"Кто хочет стать экстрасенсом?\"!!!Колличество попыток: " + player.getCount() + "  Отлично.");
        } else if (player.getCount() <= 6) {
            System.out.println("А ты хорош! Колличество попыток: " + player.getCount());
        } else if (player.getCount() <= 9) {
            System.out.println("Нужно тренироваться. Ты угадали числа за: " + player.getCount() + " попыток, не плохо");
        } else {
            System.out.println("Угадывать это не твое. Ты угадали числа за: " + player.getCount() + " попыток.");
        }
    }

    private void deleteNumbers(Player player) {
        Arrays.fill(player.getEnteredNumbers(), 0, player.getCount(), 0);
    }
}