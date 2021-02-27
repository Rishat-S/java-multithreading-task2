package ru.netology;

public class MyThread extends Thread {

    public MyThread(ThreadGroup threadGroup, String threadName) {
        super(threadGroup, threadName);
    }

    @Override
    public void run() {
        try {
            while (!isInterrupted()) {
                Thread.sleep(2500);
                System.out.println("I am Thread " + Thread.currentThread().getName()
                        + ". Hello everyone!");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            System.out.println("Thread " + Thread.currentThread().getName() + " interrupted.");
        }
    }
}
