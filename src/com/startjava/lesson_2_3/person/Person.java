package com.startjava.lesson_2_3.person;

public class Person {

    String sex = "Man";
    String name = "Dmitrii";
    float height = 183.5f;
    float weight = 91.8f;
    int age = 31;

    void walk() {
        System.out.println("Я иду.");
    }

    void sit() {
        System.out.println("Я Сижу.");
    }

    void run() {
        System.out.println("Я Бегу.");
    }

    String talk() {
        return "Я говорю.";
    }

    void learnJava() {
        System.out.println("Я учу Java.");
    }
}