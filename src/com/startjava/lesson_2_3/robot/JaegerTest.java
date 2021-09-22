package com.startjava.lesson_2_3.robot;

public class JaegerTest {
    public static void main(String[] args) {
        Jaeger jaeger1 = new Jaeger();
        Jaeger jaeger2 = new Jaeger();

        jaeger1.setName("Crimson Typhoon");
        jaeger1.setMark("Mark - 4");
        jaeger1.setHeight(250);
        jaeger1.setWeight(1.722f);
        jaeger1.setSpeed(9);
        jaeger1.setStrength(8);
        jaeger1.setArmor(6);
        jaeger1.setWeapon("IB22 Plasmacaster");

        jaeger2.setName("Striker Eureka");
        jaeger2.setMark("Mark - 5");
        jaeger2.setHeight(250);
        jaeger2.setWeight(1.85f);
        jaeger2.setSpeed(10);
        jaeger2.setStrength(10);
        jaeger2.setArmor(10);
        jaeger2.setWeapon("WMB2x90 AKM Chest launcher");

        if (jaeger1.getSpeed() > jaeger2.getSpeed()) {
            System.out.println(jaeger1.getName() + " faster then " + jaeger2.getName());
        } else if (jaeger1.getSpeed() == jaeger2.getSpeed()) {
            System.out.println("The speed of the robots is the same");
        } else {
            System.out.println(jaeger2.getName() + " faster then " + jaeger1.getName());
        }
        jaeger1.useWeapon();
        jaeger2.useWeapon();
    }
}
