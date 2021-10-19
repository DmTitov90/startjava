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

    //Перенос игроков в игру
    public GuessNumber(Player playerOne, Player playerTwo) {
        this.playerOne = playerOne;
        this.playerTwo = playerTwo;
    }

    public void start() throws IOException {
        targetNumber = (int) (Math.random() * 100 + 1);
        setUpCount(playerOne);
        setUpCount(playerTwo);
        System.out.println("\n" + "Привет! Попробуйте угадать число, которое было загадано программой");
        // Цикл игры, в котором игроки вводят числа и идет их проверка
        int quantityAttempt = 0;
        while (quantityAttempt < 10) {
            quantityAttempt++;
            if (!makeMove(playerOne)) {
                printAttemptNumbers();
                break;
            }
            if (!makeMove(playerTwo)) {
                printAttemptNumbers();
                break;
            }
        }
        if (playerTwo.getCount() == 10) {
            printAttemptNumbers();
        }

        // Объявление счета в игре
        System.out.println("\n" + "Счет в игре: " + playerOne.getName() + " " + playerOne.getScore() + " - "
                + playerTwo.getName() + " " + playerTwo.getScore() + "\n");

        playerOne.deleteNumbers();
        playerTwo.deleteNumbers();
    }

    //Обнуление счетчика попыток
    private void setUpCount(Player player) {
        player.setCount(0);
    }

    // Ввод игроком чисел, их проверка, счетчик счета и попыток для отдельного игрока
    private boolean makeMove(Player player) throws IOException {
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
        }
        return true;
    }

    //Сравнение числа с загаданным игрой
    private boolean compareNumbers(Player player) {
        if (player.getLastNumber() == targetNumber) {
            System.out.println("Каким то образом вы угадали число. Красавчик !");
            return true;
        }
        compareText = player.getLastNumber() > targetNumber ? "больше" : "меньше";
        System.out.println("Ты не угадал.Число " + compareText + " того, которое загадал Всемогущий");
        return false;

    }

    //Проверка кол-ва попыток
    private void checkLuckLevel(Player player) {
        String underThreeAttempts = "Срочно иди в казино или на ТВ программу " +
                "\"Кто хочет стать экстрасенсом?\"!!!Колличество попыток: " + player.getCount() + "  Отлично.";
        String underSixAttempts = "А ты хорош! Колличество попыток: " + player.getCount();
        String underNineAttempts = "Нужно тренироваться. Ты угадали числа за: " + player.getCount() + " попыток, не плохо";
        switch (player.getCount()) {
            case (1) -> System.out.println(underThreeAttempts);
            case (2) -> System.out.println(underThreeAttempts);
            case (3) -> System.out.println(underThreeAttempts);
            case (4) -> System.out.println(underSixAttempts);
            case (5) -> System.out.println(underSixAttempts);
            case (6) -> System.out.println(underSixAttempts);
            case (7) -> System.out.println(underNineAttempts);
            case (8) -> System.out.println(underNineAttempts);
            case (9) -> System.out.println(underNineAttempts);
            default -> System.out.println("Угадывать это не твое. Ты угадали числа за: " + player.getCount() + " попыток.");
        }
        ;
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