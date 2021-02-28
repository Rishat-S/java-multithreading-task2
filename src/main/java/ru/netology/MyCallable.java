package ru.netology;

import java.util.concurrent.Callable;

public class MyCallable implements Callable<Integer> {

    public static final int DELAY_FOR_IMITATION_WORKS = 2500;
    public static final int COUNT_EXEC = 3;

    public Integer countMassages = 0;

    @Override
    public Integer call() {
        try {
            for (int i = 0; i < COUNT_EXEC; i++) {
                Thread.sleep(DELAY_FOR_IMITATION_WORKS);
                System.out.println("I am Thread " + Thread.currentThread().getName()
                        + ". Hello everyone!");
                countMassages++;
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            System.out.println("Thread " + Thread.currentThread().getName() + " interrupted.");
        }
        return countMassages;
    }
}
