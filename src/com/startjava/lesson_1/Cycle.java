package com.startjava.lesson_1;

public class Cycle {
    public static void main(String[] args) {
        System.out.println("Выведите на консоль с помощью цикла for все числа от [0, 20]");
        for (int i = 0; i <= 20; i++) {
            System.out.println(i);
        }
        System.out.println("");

        System.out.println("Выведите на консоль с помощью цикла while все числа от [6, -6] (с шагом итерации 2)");
        int counter = 6;
        while (counter >= -6) {
            System.out.println(counter);
            counter = counter - 2;
        }
        System.out.println("");

        System.out.println("Подсчитайте с помощью цикла do-while сумму нечетных чисел от [10, 20]. Выведите ее на консоль");
        counter = 10;
        int sumOdd = 0;
        do {
            if (counter % 2 != 0) {
                sumOdd += counter;
            }
            counter++;
        } while (counter <= 20);
        System.out.println(sumOdd);
    }
}