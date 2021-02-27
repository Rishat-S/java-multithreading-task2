package ru.netology;

import java.util.concurrent.Callable;

public class MyCollableThread implements Callable<Integer> {

    public static final int DELAY_FOR_IMITATION_WORKS = 2500;
    public static final int COUNT_EXEC = 3;

    public Integer count;

    @Override
    public Integer call() throws Exception {
        try {
            for (int i = 0; i < COUNT_EXEC; i++) {
                Thread.sleep(DELAY_FOR_IMITATION_WORKS);
                System.out.println("I am Thread " + Thread.currentThread().getName()
                        + ". Hello everyone!");
                count++;
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            System.out.println("Thread " + Thread.currentThread().getName() + " interrupted.");
        }
        return count;
    }
}
