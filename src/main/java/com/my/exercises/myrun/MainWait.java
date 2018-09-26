package com.my.exercises.myrun;

public class MainWait {

    public static void main(String[] args) {
        ThreadOne threadOne = new ThreadOne();
        threadOne.start();
        ThreadTwo threadTwo = new ThreadTwo();
        threadTwo.start();
    }
}

class ThreadOne extends Thread {
    @Override
    public void run() {
        synchronized (this) {

            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Первый поток ждет пока второй поток не вызовет notify");
        }
    }
}

class ThreadTwo extends Thread {
    @Override
    public void run() {
        synchronized (this) {
            notify();
            System.out.println("Второй поток пробуждает первый при каком-то условии");
        }
    }
}


