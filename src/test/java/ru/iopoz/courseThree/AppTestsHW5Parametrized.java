package ru.iopoz.courseThree;


import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import static ru.iopoz.courseThree.HW6.AppMain.getListTail;
import static ru.iopoz.courseThree.HW6.AppMain.isListHasValue;

@RunWith(value = Parameterized.class)
public class AppTestsHW5Parametrized {
    private List<Integer> inputArray;
    private List<Integer> resArray;
    private boolean conditionBool;

    public AppTestsHW5Parametrized(List<Integer> input, List<Integer> output, boolean flag){
        this.inputArray = input;
        this.resArray = output;
        this.conditionBool = flag;
    }
    @Parameters
    public static Collection testData() {
        List<Integer> correctList = Arrays.asList(1,2,3,4,5,4,3,2,1);
        List<Integer> inCorrectList = Arrays.asList(2,3,5,6,7,8,9);
        List<Integer> without1num = Arrays.asList(2,3,4,5,6);
        List<Integer> without4num = Arrays.asList(1,2,3,5,6);
        List<Integer> shortCorrectArray = Arrays.asList(1,4);
        List<Integer> shortInCorrectList = Arrays.asList(1,5);
        List<Integer> oneElementList = Arrays.asList(1);

        List<Integer> correctListRes = Arrays.asList(3, 2, 1);
        List<Integer> inCorrectListRes = null;
        List<Integer> without1numRes = Arrays.asList(5, 6);
        List<Integer> without4numRes = null;
        List<Integer> shortCorrectArrayRes = Arrays.asList();
        List<Integer> shortInCorrectListRes = null;
        List<Integer> oneElementListRes = null;


        boolean correctListFlag = true;
        boolean inCorrectListFlag = false;
        boolean without1numFlag = false;
        boolean without4numFlag = false;
        boolean shortCorrectArrayFlag = true;
        boolean shortInCorrectListFlag = false;
        boolean oneElementListFlag = false;

        return Arrays.asList(new Object[][]{
                {correctList, correctListRes, correctListFlag},
                {inCorrectList, inCorrectListRes, inCorrectListFlag},
                {without1num, without1numRes, without1numFlag},
                {without4num, without4numRes, without4numFlag},
                {shortCorrectArray, shortCorrectArrayRes, shortCorrectArrayFlag},
                {shortInCorrectList, shortInCorrectListRes, shortInCorrectListFlag},
                {oneElementList, oneElementListRes, oneElementListFlag}}
        );
    }

    @Test
    public void testCorrectList(){
        Assert.assertEquals(resArray, getListTail(inputArray));
    }

    @Test
    public void testBoolValue(){
        Assert.assertEquals(conditionBool, isListHasValue(inputArray));
    }
}
