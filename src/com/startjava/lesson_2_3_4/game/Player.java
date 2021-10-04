package com.startjava.lesson_2_3_4.game;

public class Player {
    private String name;
    private int number;
    private int[] arrayNumber = new int[10];
    private int count;
    private int index;

    public Player(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getNumber() {
        return number;
    }

    public int[] getArrayNumber() {
        return arrayNumber;
    }

    public void setNumber(int number) {
        this.number = number;
        this.arrayNumber[index] = number;
        index++;
        count++;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public int[] clearNumbers() {
        return arrayNumber;
    }
}