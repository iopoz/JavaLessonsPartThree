package ru.iopoz.courseThree.HW5;

import java.util.concurrent.Semaphore;

public class Tunnel extends Stage {
    private static Semaphore semaphore = new Semaphore(AppMain.CARS_COUNT / 2);
    private long finishTime;

    public Tunnel(int length) {
        this.length = length;
        this.description = "Tunnel " + length + " m";
    }

    @Override
    public void go(Car c, int stagePos, int stageCount, long startTime) {
        try {
            try {
                System.out.println(c.getName() + " waiting for: " + description);
                semaphore.acquire();
                System.out.println(c.getName() + " started: " + description);
                Thread.sleep(length / c.getSpeed() * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                finishTime = System.currentTimeMillis() - startTime;
                System.out.println(c.getName() + " has done: " + description + ", time from begin = " + ((float)(finishTime) / 1000));
                semaphore.release();
                if (stagePos == stageCount && AppMain.firstFinish) {
                    AppMain.firstFinish = false;
                    System.out.println(c.getName() + " WIN!!!");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
