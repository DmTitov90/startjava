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
    private int scoreOne;
    private int scoreTwo;
    private String compareText;

    public GuessNumber(Player playerOne, Player playerTwo) {
        this.playerOne = playerOne;
        this.playerTwo = playerTwo;
    }

    public void start() throws Exception {
        createPlayers(playerOne);
        createPlayers(playerTwo);
        targetNumber = (int) (Math.random() * 100 + 1);
        System.out.println(targetNumber);
        setUpCount(playerOne);
        setUpCount(playerTwo);
        System.out.println("\n" + "Привет! Попробуйте угадать число, которое было загадано программой");
        // Цикл для проверки числа
        int endCicle = 0;
        while (endCicle < 10) {
            endCicle++;
            // Код для первого игрока
            System.out.print("\n" + playerOne.getName() + " вводит число: ");
            playerOne.setNumber(Integer.parseInt(reader.readLine()));
            if (playerOne.getCount() == 10) {
                System.out.println("У " + playerOne.getName() + " Закончились попытки");
                break;
            } else if (compareNumbers(playerOne)) {
                scoreOne++;
                checkLuckLevel(playerOne);
                arrayCopy();
                System.out.println(playerOne.getName() + " " + "Победитель !!!");
                break;
            } else {
                System.out.println(compareText);
            }
            // Код для второго игрока
            System.out.print("\n" + playerTwo.getName() + " вводит число: ");
            playerTwo.setNumber(Integer.parseInt(reader.readLine()));
            if (playerTwo.getCount() == 10) {
                System.out.println("У " + playerTwo.getName() + " Закончились попытки");
                break;
            } else if (compareNumbers(playerTwo)) {
                scoreTwo++;
                checkLuckLevel(playerTwo);
                arrayCopy();
                System.out.println(playerTwo.getName() + " " + "Победитель !!!");
                break;
            } else {
                System.out.println(compareText);
            }

            if (playerTwo.getCount() == 10) {

                arrayCopy();
            }
        }
        // Объявление счета в игре

        System.out.println("\n" + "Счет в игре: " + playerOne.getName() + " " + scoreOne + " - "
                + playerTwo.getName() + " " + scoreTwo + "\n");
        deleteNumbers();
    }
    public void createPlayers(Player player) throws IOException {
        System.out.print("Введите Имя игрока: " + "\n");
        player.setName(reader.readLine());
    }

    public void setUpCount(Player player) {
        player.setCount(0);
    }

    public boolean compareNumbers(Player player) {

        if (player.getNumber() == targetNumber) {
            System.out.println("Каким то образом вы угадали число. Красавчик !");
            return true;
        }
        compareText = player.getNumber() > targetNumber ? "Ты не угадал.Число больше того, которое загадал Всемогущий" :
                "Ты не угадал.Число меньше того, которое загадал Всемогущий";
        return false;
    }

    //Проверка кол-ва попыток
    public void checkLuckLevel(Player player) {
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

    //Копирует и выводит скопированный Массив на экран через пробел
    public void arrayCopy() {
        int[] arrayPlayerOneCopy = Arrays.copyOf(playerOne.getEnteredNumbers(), playerOne.getCount());
        int[] arrayPlayerTwoCopy = Arrays.copyOf(playerTwo.getEnteredNumbers(), playerTwo.getCount());
        System.out.println("Числа Первого игрока: " + Arrays.toString(arrayPlayerOneCopy));
        System.out.println("Числа Второго игрока: " + Arrays.toString(arrayPlayerTwoCopy));
    }

    public void deleteNumbers() {
        Arrays.fill(playerOne.fillingNumbers(), 0, playerOne.getCount(), 0);
        Arrays.fill(playerTwo.fillingNumbers(), 0, playerOne.getCount(), 0);
    }
}