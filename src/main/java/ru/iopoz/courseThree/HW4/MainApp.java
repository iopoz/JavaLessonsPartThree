package ru.iopoz.courseThree.HW4;

public class MainApp {
    public static void main(String[] args) {
        taskOne();
    }

    private static void taskOne() {
        final LetterThreads lt = new LetterThreads();
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                lt.printA();
            }
        });
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                lt.printB();
            }
        });
        Thread t3 = new Thread(new Runnable() {
            @Override
            public void run() {
                lt.printC();
            }
        });
        t1.start();
        t2.start();
        t3.start();
    }
}
