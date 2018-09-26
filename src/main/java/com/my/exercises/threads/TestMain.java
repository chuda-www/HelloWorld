package com.my.exercises.threads;

public class TestMain {

    public static void main(String[] args) {
       CounterMain counterMain = new CounterMain();

        ThreadFirst threadOne = new ThreadFirst();
        threadOne.setName("поток первый");
        threadOne.start();

        ThreadSecond threadTwo = new ThreadSecond();
        threadOne.setName("поток второй");
        threadTwo.start();
    }
}

class CounterMain {
    public Integer count = 0;
    synchronized public void inc() {
        count++;
       System.out.println("Started Thread number:" + Thread.currentThread().getName() + ":" + count);
    }
}

class ThreadFirst extends Thread {
    CounterMain counter = new CounterMain();

    public ThreadFirst() {
        this.counter = counter;
    }

    @Override
    public void run() {
        synchronized (counter) {
        for (int i = 0; i <= 1000; i++) {
            while (i % 2 != 0) {
                notify();
                System.out.println("Первый поток ждет от счетчика нечетное значение");
                counter.inc();
            }
            while (i % 2 == 0){
                try {
                    wait(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}}

class ThreadSecond extends Thread {
    CounterMain counter = new CounterMain();

    public ThreadSecond() {
        this.counter = counter;
    }
    @Override
    public void run() {
        synchronized (counter) {
            for (int i = 0; i <= 1000; i++) {
                while (i % 2 == 0) {
                    notify();
                    System.out.println("Второй поток ждет четное значение");
                    counter.inc();
                }
                while (i % 2 != 0) {
                    try {
                        wait(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
