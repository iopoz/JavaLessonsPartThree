package ru.iopoz.courseThree;

import static org.junit.Assert.assertTrue;
import static ru.iopoz.courseThree.App.taskOne;

import org.junit.Assert;
import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue()
    {
        assertTrue( true );
    }

    @Test
    public void testFirstTaskCorrect() throws Exception {
        Integer[] intArray = {1, 2, 3, 4, 5, 6, 7, 8, 9, 0};
        taskOne(intArray, 2, intArray.length - 1);
    }

    @Test
    public void testFirstTaskInCorrect() throws Exception {
        Integer[] intArray = {1, 2, 3, 4, 5, 6, 7, 8, 9, 0};
        try{
            taskOne(intArray, -1, intArray.length);
        } catch (Exception e){
            assertTrue(true);
        }

    }
}
