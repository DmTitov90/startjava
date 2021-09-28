package com.startjava.lesson_2_3_4.animal;

public class Wolf {

    private String gender;
    private String name;
    private float weight;
    private float age;
    private String color;

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public float getAge() {
        return age;
    }

    public void setAge(float age) {
        if (age < 0 || age > 8) {
            System.out.println("Некорректный возраст" + "\n");
        } else {
            this.age = age;
        }
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void walk() {
        System.out.println("Walk.");
    }

    public void sit() {
        System.out.println("Sit.");
    }

    public void run() {
        System.out.println("Run.");
    }

    public void howl() {
        System.out.println("Howl.");
    }

    public void hunt() {
        System.out.println("Hunt.");
    }
}