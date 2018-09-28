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
    public volatile Integer count = 0;
    synchronized public Integer getCount() {
        return count;
        }
    synchronized public void inc() {
    count++;
    System.out.println("Started Thread number:" + Thread.currentThread().getName() + ":" + getCount());
    }
}
class ThreadFirst extends Thread {
    private CounterMain counter;

    public ThreadFirst(CounterMain counter) {
        this.counter = counter;
    }

    @Override
    public void run() {
        synchronized (counter) {
            for (int i = 0; i <= 100; i++) {
                {
                    while ((counter.getCount() % 2 == 0) && (counter.getCount() % 10 != 0)) {
                        System.out.println("Первый поток ждет четное значение");
                        try {
                            counter.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    counter.inc();
                    counter.notifyAll();
                }
            }
        }
    }
}
class ThreadSecond extends Thread {
    private CounterMain counter;

    public ThreadSecond(CounterMain counter) {
        this.counter = counter;
    }

    @Override
    public void run() {
        synchronized (counter) {
            for (int i = 0; i <= 100; i++) {
                {
                    while (counter.getCount() % 2 != 0) {
                        System.out.println("Второй поток ждет нечетное значение");
                        try {
                            counter.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    counter.inc();
                    counter.notifyAll();
                }
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
            for (int i = 0; i <= 100; i++) {
                {
                    while (counter.getCount() % 10 == 0) {
                        System.out.println("Третий поток ждет значение делимое на 10");
                        try {
                            counter.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    counter.inc();
                    counter.notifyAll();
                }
            }
        }
    }
}
//public class TestMain {
//    static CounterMain counter = new CounterMain();
//    public static void main(String[] args) {
//
//        ThreadFirst threadOne = new ThreadFirst(counter);
//        threadOne.setName("поток первый");
//        threadOne.start();
//
//        ThreadSecond threadTwo = new ThreadSecond(counter);
//        threadTwo.setName("поток второй");
//        threadTwo.start();
//
////        executorService.submit(threadOne);
////        executorService.submit(threadTwo);
////        executorService.submit(threadThree);
//    }
//}
//class CounterMain {
//    public Integer count = 0;
//
//    public void inc() {
//        count++;
//       System.out.println("Started Thread number:" + Thread.currentThread().getName() + ":" + count);
//    }
//}
//class ThreadFirst extends Thread {
//    CounterMain counter;
//
//    public ThreadFirst(CounterMain counter) {
//        this.counter = counter;
//    }
//    @Override
//    public void run() {
//        synchronized (counter) {
//            for (int i = 0; i <= 100; i++) {
//                if (counter.count % 2 == 0) {
//                    System.out.println("Первый поток ждет от счетчика нечетное значение");
//                    try {
//                        counter.wait();
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                }
//                counter.inc();
//                counter.notify();
//            }
//        }
//    }
//}
//class ThreadSecond extends Thread {
//    CounterMain counter;
//
//    public ThreadSecond(CounterMain counter) {
//        this.counter = counter;
//    }
//    @Override
//    public void run() {
//        synchronized (counter) {
//            for (int i = 0; i <= 100; i++) {
//                    if(counter.count % 2 != 0) {
//                    System.out.println("Второй поток ждет четное значение");
//                    try {
//                        counter.wait();
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                }
//                counter.inc();
//                counter.notify();
//            }
//        }
//    }
//}
