package com.my.exercises.myrun;

public class MainThreadRun {
    static MyRun threads;

    public static void main(String[] args) {
        for (int x = 1; x <= 10; x++) {
            threads = new MyRun();
            Thread myThread = new Thread(threads);
            myThread.start();
            System.out.println("Hellosdfsdef");
        }
    }
}
    class MyRun implements Runnable {

        public void run() {

                   }
    }
