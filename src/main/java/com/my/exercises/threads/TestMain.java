package com.my.exercises.threads;

public class TestMain {
    static CounterMain counter = new CounterMain();

    public static void main(String[] args) {

        ThreadFirst threadOne = new ThreadFirst(counter);
        threadOne.setName("поток первый");
        threadOne.start();

        ThreadSecond threadTwo = new ThreadSecond(counter);
        threadTwo.setName("поток второй");
        threadTwo.start();
    }

}

class CounterMain {
    public Integer count = 0;

    public void inc() {
        count++;
       System.out.println("Started Thread number:" + Thread.currentThread().getName() + ":" + count);
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
            for (int i = 0; i <= 100; i++) {
                if (counter.count % 2 == 0) {
                    System.out.println("Первый поток ждет от счетчика нечетное значение");
                    try {
                        counter.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                counter.inc();
                counter.notify();
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
            for (int i = 0; i <= 100; i++) {
                    if(counter.count % 2 != 0) {
                    System.out.println("Второй поток ждет четное значение");
                    try {
                        counter.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                counter.inc();
                counter.notify();
            }
        }
    }
}
