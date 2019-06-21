package ru.iopoz.courseThree.HW7;

public class TestCase1 {
    @BeforeSuite
    public void methodBefore() {
        System.out.println("TestCase1.methodBefore");
    }

    @Test(priority = 1)
    public void methodTest1() {
        System.out.println("TestCase1.methodTest1 priority 1 (highest)");
    }

    @Test(priority = 5)
    public void methodTest2() {
        System.out.println("TestCase1.methodTest2 priority 5 (lowest)");
    }

    @Test(priority = 2)
    public void methodTest3() {
        System.out.println("TestCase1.methodTest3 priority 2(middle)");
    }


    public void commonMethod1() {
        System.out.println("TestCase1.commonMethod1");
    }

    @AfterSuite
    public void methodAfter() {
        System.out.println("TestCase1.methodAfter");
    }
}
