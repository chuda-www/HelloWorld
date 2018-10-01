package com.my.exercises.threads;

public class MainThread {

    private static Counter counter = new Counter();

    public static void main(String[] args) throws InterruptedException {

        for (int x = 0; x <= 100; x++) {
            MyThreads threads = new MyThreads(counter);
            threads.start();
        }
    }
}

class Counter {
    public Integer count = 0;

    synchronized public void inc() {
        count++;
        System.out.println("Started Thread number:" + Thread.currentThread().getName() + ":" + count);
    }
}

class MyThreads extends Thread {
    private Counter counter;

    public MyThreads(Counter counter) {
        this.counter = counter;
    }

    @Override
    public void run() {
        counter.inc();
    }
}