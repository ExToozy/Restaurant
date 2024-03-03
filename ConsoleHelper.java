package com.javarush.task.task27.task2712;

import com.javarush.task.task27.task2712.kitchen.Dish;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class ConsoleHelper {
    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static List<Dish> getAllDishesForOrder() throws IOException {
        List<Dish> dishesOrder = new ArrayList<>();
        String line;
        writeMessage("Введите название блюд которые хотите заказать, чтобы закончить выбор введите 'exit'");
        writeMessage(Dish.allDishesToString());
        while (!(line = readString()).equals("exit")) {
            try {
                dishesOrder.add(Dish.valueOf(line.toUpperCase()));
            } catch (IllegalArgumentException e) {
                writeMessage("Такого блюда нет в меню!");
            }
        }
        return dishesOrder;
    }

    public static void writeMessage(String message) {
        System.out.println(message);
    }

    public static String readString() throws IOException {
        return reader.readLine();
    }
}
