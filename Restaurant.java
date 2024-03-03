package com.javarush.task.task27.task2712;

import com.javarush.task.task27.task2712.kitchen.Cook;
import com.javarush.task.task27.task2712.kitchen.Order;
import com.javarush.task.task27.task2712.kitchen.Waiter;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;

public class Restaurant {
    private static final int ORDER_CREATING_INTERVAL = 100;
    private static final LinkedBlockingQueue<Order> ORDER_QUEUE = new LinkedBlockingQueue<>();

    public static void main(String[] args) throws InterruptedException {
        Tablet tablet1 = new Tablet(1);
        Tablet tablet2 = new Tablet(2);
        Tablet tablet3 = new Tablet(3);
        Tablet tablet4 = new Tablet(4);
        Tablet tablet5 = new Tablet(5);

        Cook cook1 = new Cook("Profeto");
        Cook cook2 = new Cook("Sania");

        cook1.setQueue(ORDER_QUEUE);
        cook2.setQueue(ORDER_QUEUE);
        tablet1.setQueue(ORDER_QUEUE);
        tablet2.setQueue(ORDER_QUEUE);
        tablet3.setQueue(ORDER_QUEUE);
        tablet4.setQueue(ORDER_QUEUE);
        tablet5.setQueue(ORDER_QUEUE);

        Thread cookThread1 = new Thread(cook1);
        Thread cookThread2 = new Thread(cook2);
        cookThread1.start();
        cookThread2.start();

        Waiter waiter = new Waiter();

        cook1.addObserver(waiter);
        cook2.addObserver(waiter);

        List<Tablet> tablets = Arrays.asList(tablet1, tablet2, tablet3, tablet3, tablet4, tablet5);

        Thread orderGeneratingThread = new Thread(new RandomOrderGeneratorTask(tablets, ORDER_CREATING_INTERVAL));
        orderGeneratingThread.start();
        Thread.sleep(1000);
        orderGeneratingThread.interrupt();
        cookThread1.interrupt();
        cookThread2.interrupt();

        System.out.println();

        DirectorTablet directorTablet = new DirectorTablet();
        directorTablet.printAdvertisementProfit();
        System.out.println();

        directorTablet.printCookWorkloading();
        System.out.println();

        directorTablet.printActiveVideoSet();
        System.out.println();

        directorTablet.printArchivedVideoSet();
    }
}
