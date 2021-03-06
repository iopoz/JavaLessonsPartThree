package ru.iopoz.courseThree.HW5;

public class Road extends Stage {
    private long finishTime;
    public Road(int length) {
        this.length = length;
        this.description = "Road " + length + " m";
    }
    @Override
    public void go(Car c, int stagePos, int stageCount, long startTime) {
        try {
            System.out.println(c.getName() + " started: " + description);
            Thread.sleep(length / c.getSpeed() * 1000);
            finishTime = System.currentTimeMillis() - startTime;
            System.out.println(c.getName() + " has done: " + description + ", time from begin = " + ((float)(finishTime) / 1000));
            if (stagePos == stageCount && AppMain.firstFinish) {
                AppMain.firstFinish = false;
                System.out.println(c.getName() + " WIN!!!");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
