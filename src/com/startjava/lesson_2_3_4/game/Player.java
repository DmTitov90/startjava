package com.startjava.lesson_2_3_4.game;

import java.util.Arrays;

public class Player {
    private String name;
    private int number;
    private int[] enteredNumbers = new int[10];
    private int count;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumber() {
        return number;
    }

    public int[] getEnteredNumbers() {
        int[] copyEnteredNumbers = Arrays.copyOf(enteredNumbers, enteredNumbers.length);
        return copyEnteredNumbers;
    }

    public void setNumber(int number) {
        this.number = number;
        this.enteredNumbers[count] = number;
        count++;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int[] fillingNumbers(){
        return enteredNumbers;
    }
}