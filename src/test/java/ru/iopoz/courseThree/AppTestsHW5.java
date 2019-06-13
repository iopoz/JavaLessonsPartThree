package ru.iopoz.courseThree;

import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static ru.iopoz.courseThree.HW6.AppMain.getListTail;
import static ru.iopoz.courseThree.HW6.AppMain.isListHasValue;

public class AppTestsHW5 {
    private static final Logger LOGGER = Logger.getLogger(AppTestsHW5.class);
    @Test
    public void checkGetTailMethod(){
        int[] correctArray = new int[]{1,2,3,4,5,4,3,2,1};
        int[] inCorrectArray = new int[]{2,3,5,6,7,8,9};
        int[] without1num = new int[] {2,3,4,5,6};
        int[] without4num = new int[] {1,2,3,5,6};
        int[] shortCorrectArray = new int[]{1,4};
        int[] shortIncorrectArray = new int[]{1,5};
        int[] oneElementArray = new int[] {1};
        List examplesList = new ArrayList();
        examplesList.add(inCorrectArray);
        examplesList.add(correctArray);
        examplesList.add(without1num);
        examplesList.add(without4num);
        examplesList.add(shortCorrectArray);
        examplesList.add(shortIncorrectArray);
        examplesList.add(oneElementArray);

        for (Object array: examplesList) {
            List inputList = new ArrayList();
            for (int el:(int[]) array) {
                inputList.add(el);
            }
            LOGGER.info("Check array "+ inputList);
            List res = (List) getListTail(inputList);
            System.out.println(res);
            if (isListHasValue(inputList)){
                System.out.println("correct conditions");
            } else {
                System.out.println("incorrect conditions");
            }
        }

    }
}
