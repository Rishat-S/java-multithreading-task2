package ru.netology;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Main {

    public static final int NUMBER_THREADS = 4;
    public static final int DELAY_FOR_THREADS_EXECUTION = 1000;

    public static void main(String[] args) throws InterruptedException {
        ExecutorService threadPool = Executors.newFixedThreadPool(NUMBER_THREADS);

        System.out.println("Started threads..");
        Future<?> future = threadPool.submit(new MyCollableThread());

        while (!future.isDone()) {
            System.out.println("Running...");
            Thread.sleep(DELAY_FOR_THREADS_EXECUTION);
        }

        threadPool.shutdown();
        System.out.println("Threads interrupted.");
    }
}
