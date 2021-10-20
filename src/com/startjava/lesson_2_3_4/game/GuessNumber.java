package com.startjava.lesson_2_3_4.game;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class GuessNumber {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private int targetNumber;
    private Player playerOne;
    private Player playerTwo;

    //Передача игроков в игру
    public GuessNumber(Player playerOne, Player playerTwo) {
        this.playerOne = playerOne;
        this.playerTwo = playerTwo;
    }

    public void start() throws IOException {
        targetNumber = (int) (Math.random() * 100 + 1);
        System.out.println("\n" + "Привет! Попробуйте угадать число, которое было загадано программой");
        // Цикл игры, в котором игроки вводят числа и идет их проверка
        while (playerTwo.getCount() < 10) {
            if (makeMove(playerOne) || makeMove(playerTwo)) {
                break;
            }
        }
        if (playerTwo.getCount() == 9) {
            System.out.println("Никто не угадал загаданное число, испытайте удачу в следующей игре!");
            printAttemptNumbers();
        }

        // Объявление счета в игре
        System.out.println("\n" + "Счет в игре: " + playerOne.getName() + " " + playerOne.getScore() + " - "
                + playerTwo.getName() + " " + playerTwo.getScore() + "\n");

        playerOne.clearNumbers();
        playerTwo.clearNumbers();
    }

    // Ввод игроком чисел, их проверка, счетчик счета и попыток для отдельного игрока
    private boolean makeMove(Player player) throws IOException {
        System.out.print("\n" + player.getName() + " вводит число: ");
        player.setNumber(Integer.parseInt(reader.readLine()));
        if (player.getCount() == 10) {
            System.out.println("У " + player.getName() + " Закончились попытки");
            return false;
        } else if (compareNumbers(player)) {
            player.setScore(player.getScore() + 1);
            checkLuckLevel(player);
            System.out.println(player.getName() + " " + "Победитель !!!");
            printAttemptNumbers();
            return true;
        }
        return false;
    }

    //Сравнение числа с загаданным игрой
    private boolean compareNumbers(Player player) {
        if (player.getLastNumber() == targetNumber) {
            System.out.println("Каким то образом ns угадал число. Красавчик !");
            return true;
        }
        String compareText = player.getLastNumber() > targetNumber ? "больше" : "меньше";
        System.out.println("Ты не угадал.Число " + compareText + " того, которое загадал Всемогущий");
        return false;
    }

    //Проверка кол-ва попыток
    private void checkLuckLevel(Player player) {
        switch (player.getCount()) {
            case 1, 2, 3 -> System.out.println("Срочно иди в казино или на ТВ программу " +
                    "\"Кто хочет стать экстрасенсом?\"!!!Колличество попыток: " + player.getCount() + "  Отлично.");
            case 4, 5, 6 -> System.out.println("А ты хорош! Колличество попыток: " + player.getCount());
            case 7, 8, 9 -> System.out.println("Нужно тренироваться. Ты угадали числа за: "
                    + player.getCount() + " попыток, не плохо");
            default -> System.out.println("Угадывать это не твое. Ты угадали числа за: "
                    + player.getCount() + " попыток.");
        };
    }

    //Вывод не верных попыток через пробел для обоих игроков
    private void printAttemptNumbers() {
        outputEnteredNumbers(playerOne);
        outputEnteredNumbers(playerTwo);
    }

    //Создание копии массива с неверными введенными числами и вывод его через пробел
    private void outputEnteredNumbers(Player player) {
        System.out.print("Числа игрока " + player.getName() + ": ");
        for (int number : player.getEnteredNumbers()) {
            System.out.print(number + " ");
        }
        System.out.println();
    }
}