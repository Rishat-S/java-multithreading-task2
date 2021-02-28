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
        ExecutorService tasksPool = Executors.newFixedThreadPool(NUMBER_THREADS);
        List<MyCallable> tasks1 = new ArrayList<>();
        List<MyCallable> tasks2 = new ArrayList<>();

        startedTasks(tasks1);
        doneAllTasks(tasksPool, tasks1);

        startedTasks(tasks2);
        doneAnyTask(tasksPool, tasks2);

        stopAll(tasksPool);
    }

    private static void startedTasks(List<MyCallable> tasks) {
        System.out.println("Started threads..");
        for (int i = 0; i < NUMBER_THREADS; i++) {
            MyCallable myCallable = new MyCallable();
            tasks.add(myCallable);
        }
    }

    private static void doneAllTasks(ExecutorService tasksPool, List<MyCallable> tasks) {
        int countOfMassages = 0;

        try {
            List<Future<Integer>> futures = tasksPool.invokeAll(tasks);
            for (Future<Integer> f : futures) {
                countOfMassages += f.get();
            }
            System.out.println("Count of massages: " + countOfMassages);
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }

    private static void doneAnyTask(ExecutorService tasksPool, List<MyCallable> tasks) {
        try {
            Integer countOfMassages = tasksPool.invokeAny(tasks);
            System.out.println("Count of massages: " + countOfMassages);
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }

    private static void stopAll(ExecutorService tasksPool) {
        System.out.println("Tasks pool shutdown.");
        tasksPool.shutdown();
    }
}
