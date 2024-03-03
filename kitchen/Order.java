package com.javarush.task.task27.task2712.kitchen;

import com.javarush.task.task27.task2712.ConsoleHelper;
import com.javarush.task.task27.task2712.Tablet;

import java.io.IOException;
import java.util.List;

public class Order {

    private final Tablet tablet;
    protected List<Dish> dishes;

    public Order(Tablet tablet) throws IOException {
        this.tablet = tablet;
        initDishes();
    }

    protected void initDishes() throws IOException {
        dishes = ConsoleHelper.getAllDishesForOrder();
    }

    public Tablet getTablet() {
        return tablet;
    }

    public boolean isEmpty() {
        return dishes.isEmpty();
    }

    @Override
    public String toString() {
        String res = "";
        if (!dishes.isEmpty()) {
            res = "Your order: [";
            for (Dish dish : dishes) {
                if (res.endsWith("[")) {
                    res += dish;
                } else {
                    res += ", " + dish;
                }
            }
            res += "] of " + tablet.toString() + ", cooking time " + getTotalCookingTime() + "min";
        }
        return res;
    }

    public int getTotalCookingTime() {
        int totalCookingTime = 0;
        if (dishes == null) {
            return totalCookingTime;
        }

        for (Dish dish : dishes) {
            totalCookingTime += dish.getDuration();
        }
        return totalCookingTime;
    }

    public List<Dish> getDishes() {
        return dishes;
    }
}
