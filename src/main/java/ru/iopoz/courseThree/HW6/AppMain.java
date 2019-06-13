package ru.iopoz.courseThree.HW6;

import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AppMain {
    private static final Logger LOGGER = Logger.getLogger(AppMain.class);
    public static void main(String[] args) {
        final List<Integer> inputList = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 4, 3, 2, 1));
        System.out.println(getListTail(inputList));
        System.out.println(isListHasValue(inputList));
    }

    public static List getListTail(List fullList){
        int  index = fullList.lastIndexOf(4);
        if (index > 0){
            List res = (List) fullList.subList(fullList.lastIndexOf(4) + 1, fullList.size());
            LOGGER.info(res);
            return res;
        } else {
            String exc = "4 is absent into array";
            LOGGER.error(new RuntimeException(exc));
            return null ;
        }
    }

    public static Boolean isListHasValue(List inputList){
        return inputList.size() > 2 && inputList.indexOf(1) > -1 && inputList.indexOf(4)> -1;
    }
}
