package com.my.exercises.threads;

public class TestMain {
    static CounterMain counter = new CounterMain();

    public static void main(String[] args) {

        ThreadFirst threadOne = new ThreadFirst(counter);
        threadOne.setName("поток первый");
        ThreadSecond threadTwo = new ThreadSecond(counter);
        threadTwo.setName("поток второй");
        ThreadThird threadThree = new ThreadThird(counter);
        threadThree.setName("поток третий");
        threadOne.start();
        threadTwo.start();
        threadThree.start();
    }
}

class CounterMain {
    private int count = 0;

    synchronized int getCount() {
        return count;
    }

    synchronized void inc() {
        System.out.println("Started Thread number:" + Thread.currentThread().getName() + ":" + count++);
    }
}

class ThreadFirst extends Thread {
    CounterMain counter;
    public ThreadFirst(CounterMain counter) {
        this.counter = counter;
    }

    @Override
    public void run() {
        synchronized (counter) {
            for (int i = 0; i <= 20; i++) {
                while (counter.getCount() % 2 != 0 || counter.getCount() % 10 == 0) {
                    System.out.println("Первый поток ждет четное значение");
                    try {
                        counter.wait();
                    } catch (InterruptedException e) {
                        ThreadFirst.interrupted();
                    }
                }
                counter.inc();
                counter.notifyAll();
            }
        }
    }
}

class ThreadSecond extends Thread {
    CounterMain counter;
    public ThreadSecond(CounterMain counter) {
        this.counter = counter;
    }

    @Override
    public void run() {
        synchronized (counter) {
            for (int i = 0; i <= 20; i++) {
                while (counter.getCount() % 2 == 0) {
                    System.out.println("Второй поток ждет нечетное значение");
                    try {
                        counter.wait();
                    } catch (InterruptedException e) {
                        ThreadSecond.interrupted();
                    }
                }
                counter.inc();
                counter.notifyAll();
            }
        }
    }
}

class ThreadThird extends Thread {
    private CounterMain counter;
    public ThreadThird(CounterMain counter) {
        this.counter = counter;
    }

    @Override
    public void run() {
        synchronized (counter) {
            for (int i = 0; i <= 20; i++) {
                while (counter.getCount() % 10 != 0) {
                    System.out.println("Третий поток ждет значение делимое на 10");
                    try {
                        counter.wait();
                    } catch (InterruptedException e) {
                        ThreadThird.interrupted();
                    }
                }
                counter.inc();
                counter.notifyAll();
            }
        }
    }
}