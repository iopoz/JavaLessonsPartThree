package ru.iopoz.courseThree;

import static org.junit.Assert.assertTrue;
import static ru.iopoz.courseThree.HW1.App.taskOne;

import org.junit.Test;
import ru.iopoz.courseThree.HW2.DBHelper;

import java.sql.SQLException;
import java.sql.Timestamp;

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

    @Test
    public void addUser() throws SQLException {
        DBHelper dbConnector = new DBHelper();
        System.out.println(dbConnector.addUser("iopoz"));
    }

    @Test
    public void updateUser() throws SQLException {
        DBHelper dbConnector = new DBHelper();
        int userId = dbConnector.getUserId("iopoz");
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        System.out.println(dbConnector.updateUser(userId, "iopoz"+timestamp.getTime()));
    }

    @Test
    public void getAllUser() throws SQLException {
        DBHelper dbConnector = new DBHelper();
        System.out.println(dbConnector.getAllUsers());
    }
}
