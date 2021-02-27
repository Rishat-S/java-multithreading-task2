package ru.netology;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        ThreadGroup threadGroup = new ThreadGroup("Thread group");

        ExecutorService es = Executors.newFixedThreadPool(4);

        System.out.println("Started threads..");
        Thread th1 = new MyThread(threadGroup, "1");
        Thread th2 = new MyThread(threadGroup, "2");
        Thread th3 = new MyThread(threadGroup, "3");
        Thread th4 = new MyThread(threadGroup, "4");

        th1.start();
        th2.start();
        th3.start();
        th4.start();

        Thread.sleep(15000);
        threadGroup.interrupt();
        System.out.println("Threads interrupted.");

    }
}
