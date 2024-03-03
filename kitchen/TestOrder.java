package com.javarush.task.task27.task2712.kitchen;

import com.javarush.task.task27.task2712.Tablet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class TestOrder extends Order {
    public TestOrder(Tablet tablet) throws IOException {
        super(tablet);
    }

    @Override
    protected void initDishes() {
        int dishesCreateCount = new Random().nextInt(11);
        dishes = new ArrayList<>();
        for (int i = 0; i < dishesCreateCount; i++) {
            int dishIndex = new Random().nextInt(Dish.values().length);
            dishes.add(Dish.values()[dishIndex]);
        }
    }
}
