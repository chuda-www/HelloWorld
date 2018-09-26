package com.my.exercises.myrun;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {

        MyThread thread1 = new MyThread();
        MyThread thread2 = new MyThread();
        MyThread thread3 = new MyThread();
        MyThread thread4 = new MyThread();
        MyThread thread5 = new MyThread();
        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
        thread5.start();
        ExecutorService executorService = Executors.newFixedThreadPool(3);
//        executorService.submit(thread1);
//        executorService.submit(thread2);
//        executorService.submit(thread3);
//        executorService.submit(thread4);
//        executorService.submit(thread5);

    }
}

class MyThread extends Thread{
    @Override
    public void run() {
        for (int i = 0; i < 4; i++) {
            System.out.println(i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println(i);;
            }

        }
    }

}