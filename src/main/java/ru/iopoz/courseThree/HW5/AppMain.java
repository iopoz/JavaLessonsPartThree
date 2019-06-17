package ru.iopoz.courseThree.HW5;

import java.util.concurrent.CountDownLatch;

public class AppMain {
    public static final int CARS_COUNT = 10;
    public static volatile boolean firstFinish = true;

    public static void main(String[] args) {

        System.out.println("Preparing!");
        Race race = new Race(new Road(60), new Tunnel(50), new Road(40));
        Car[] cars = new Car[CARS_COUNT];
        CountDownLatch countDownLatchReady = new CountDownLatch(CARS_COUNT);
        CountDownLatch countDownLatchFinish = new CountDownLatch(CARS_COUNT);
        long time;

        for (int i = 0; i < cars.length; i++) {
            cars[i] = new Car(race, 20 + (int) (Math.random() * 10), countDownLatchReady, countDownLatchFinish);
        }


        for (int i = 0; i < cars.length; i++) {
            new Thread(cars[i]).start();
        }




        try {
            countDownLatchReady.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //System.out.println("Go-Go-Go!");
        time = System.currentTimeMillis();

        try {
            countDownLatchFinish.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Race is Done! Time = " + ((float)(System.currentTimeMillis() - time) / 1000));
    }
}
