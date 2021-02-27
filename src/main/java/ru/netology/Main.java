package ru.netology;

import java.util.concurrent.*;

public class Main {

    public static final int NUMBER_THREADS = 4;
    public static final int DELAY_FOR_IMITATION_WORKS = 1000;

    public static void main(String[] args) {
        ExecutorService threadPool = Executors.newFixedThreadPool(NUMBER_THREADS);
        Callable<Integer> myCallable = new MyCallable();
        System.out.println("Started threads..");
        Future<Integer> task = threadPool.submit(myCallable);

        try {
            while (!task.isDone()) {
                System.out.println("Is not done...");
                Thread.sleep(DELAY_FOR_IMITATION_WORKS);
            }
            System.out.println(task.get());
        } catch (ExecutionException | InterruptedException e) {
            e.printStackTrace();

        }

        threadPool.shutdown();
        System.out.println("Threads interrupted.");
    }
}
