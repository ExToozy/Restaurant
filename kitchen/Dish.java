package com.javarush.task.task27.task2712.kitchen;

public enum Dish {
    FISH(25),
    STEAK(30),
    SOUP(15),
    JUICE(5),
    WATER(3);
    private int duration;

    Dish(int duration) {
        this.duration = duration;
    }

    public static String allDishesToString() {
        String dishes = "";
        for (Dish dish : Dish.values()) {
            if (dishes.isEmpty()) {
                dishes += dish;
            } else {
                dishes = dishes + ", " + dish;
            }

        }
        return dishes.toString();
    }

    public int getDuration() {
        return duration;
    }
}
