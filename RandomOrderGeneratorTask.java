package com.javarush.task.task27.task2712;

import java.util.List;

public class RandomOrderGeneratorTask implements Runnable {
    private List<Tablet> tablets;
    private int createOrderInterval;

    public RandomOrderGeneratorTask(List<Tablet> tablets, int createOrderInterval) {
        this.tablets = tablets;
        this.createOrderInterval = createOrderInterval;
    }

    @Override
    public void run() {
        try {
            while (true) {
                int k = (int) (Math.random() * tablets.size());
                Tablet expected = tablets.get(k);
                expected.createTestOrder();
                Thread.sleep(createOrderInterval);
            }
        } catch (InterruptedException e) {
        }
    }
}
