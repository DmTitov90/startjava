package com.startjava.lesson_2_3_4.animal;

public class WolfTest {

    public static void main(String[] args) {
        Wolf wolf = new Wolf();
        wolf.setGender("Male");
        wolf.setName("WolfGuard");
        wolf.setWeight(45.5f);
        wolf.setAge(5.5f);
        wolf.setColor("Grey");

        System.out.println("Wolf gender is: " + wolf.getGender());
        System.out.println("Wolf name is: " + wolf.getName());
        System.out.println("Wolf weight is: " + wolf.getWeight() + " kg.");
        if (wolf.getAge() == 0) {
            System.out.println("The age of the wolf is entered incorrectly");
        } else {
            System.out.println("Wolf age is: " + wolf.getAge() + " years.");
        }
        System.out.println("Wolf color is: " + wolf.getColor() + "\n");

        wolf.walk();
        wolf.sit();
        wolf.run();
        wolf.howl();
        wolf.hunt();
    }
}
