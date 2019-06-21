package ru.iopoz.courseThree.HW7;

public class TestCase2 {
    @BeforeSuite
    public void methodBefore() {
        System.out.println("TestCase2.methodBefore");
    }

    @Test(priority = 1)
    public void methodTest1() {
        System.out.println("TestCase2.methodTest1 priority 1 (highest)");
    }

    @Test(priority = 5)
    public void methodTest2() {
        System.out.println("TestCase2.methodTest2 priority 5 (lowest)");
    }

    @Test(priority = 2)
    public void methodTest3() {
        System.out.println("TestCase2.methodTest3 priority 2(middle)");
    }


    public void commonMethod1() {
        System.out.println("TestCase2.commonMethod1");
    }

    @AfterSuite
    public void methodAfter() {
        System.out.println("TestCase2.methodAfter");
    }
}
