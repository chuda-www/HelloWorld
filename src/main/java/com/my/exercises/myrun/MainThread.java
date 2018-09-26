package com.my.exercises.myrun;

public class MainThread {

    private static Counter counter = new Counter();

    public static void main(String[] args) throws InterruptedException {

        for (int x = 0; x <= 100; x++) {
            MyThreads threads = new MyThreads(counter);
            threads.start();
            //threads.run();
//           Thread.sleep(1000);
            //System.out.println("Started Thread number:" + Thread.currentThread().getName() +":"+ counter.getCount());
        }
    }
}

class Counter {
    public Integer count = 0;

    synchronized public void inc() {
        count++;
        System.out.println("Started Thread number:" + Thread.currentThread().getName() +":"+ count);
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
//package com.my.exercises.myrun;
//public class MainThread {
//    public static void main(String[] args)  {
//
//        for (int x = 1; x <=1000; x++) {
//            MyThreads threads = new MyThreads(x);
//            threads.start();
//            System.out.println("Started Thread number:" + x);
//        }
//    }
//}
//class MyThreads extends Thread{
//    @Override
//    public void run() {

//    }
//}
