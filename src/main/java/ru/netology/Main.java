package ru.netology;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Main {

    public static final int NUMBER_THREADS = 4;

    public static void main(String[] args) {
        int countOfMassages = 0;
        ExecutorService tasksPool = Executors.newFixedThreadPool(NUMBER_THREADS);
        List<MyCallable> tasks = new ArrayList<>();
        System.out.println("Started threads..");

        for (int i = 0; i < NUMBER_THREADS; i++) {
            MyCallable myCallable = new MyCallable();
            tasks.add(myCallable);
        }

        try {
            List<Future<Integer>> futures = tasksPool.invokeAll(tasks);
            for (Future<Integer> f : futures) {
                countOfMassages += f.get();
            }
            System.out.println("Count of massages: " + countOfMassages);
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }

        System.out.println("All threads interrupted.");
        tasksPool.shutdown();
    }
}
