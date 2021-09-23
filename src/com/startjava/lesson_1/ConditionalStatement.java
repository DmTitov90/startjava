package com.startjava.lesson_1;

public class ConditionalStatement {
    public static void main(String[] args) {
        byte age = 31;
        if(age > 20) {
            System.out.println("Ваш возраст больше 20 лет");
        }

        char sex = 'M';
        if(sex == 'M') {
            System.out.println("Ваш пол мужской");
        } else if (sex != 'M') {
            System.out.println("Ваш пол женский");
        }

        float weight = 2.02f;
        if (weight < 1.80) {
            System.out.println("Ваш рост < 1.80");
        } else {
            System.out.println("Ваш рост > 1.80");
        }

        char firstLetterName = 'M';
        if (firstLetterName == 'M') {
            System.out.println("Первая буква вашего имени \"M\"");
        } else if (firstLetterName == 'I') {
            System.out.println("Первая буква вашего имени \"I\"");
        } else {
            System.out.println("Ваша первая буква в имени отсутствует в нашем алфавите");
        }
    }
}