package ru.iopoz.courseThree.HW2;

import org.sqlite.JDBC;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DBHelper {
    private static final String DB_STR = "jdbc:sqlite:D:\\git\\lessons\\JavaLessonsPartThree\\src\\main\\java\\ru\\iopoz\\courseThree\\HW2\\db.sqlite";

    private static DBHelper instance = null;

    public static synchronized DBHelper getInstance() throws SQLException {
        if (instance == null) instance = new DBHelper();
        return instance;
    }

    private Connection connection;

    public DBHelper() throws SQLException{
        DriverManager.registerDriver(new JDBC());
        this.connection = DriverManager.getConnection(DB_STR);
    }

    public String addUser(String userNick){
        if (isUserExists(userNick)) return "User " + userNick + " exists! Try another nick name";
        try(PreparedStatement statement = this.connection.prepareStatement(
                "INSERT INTO user('user_nick') VALUES(?)")){
            statement.setObject(1, userNick);
            statement.execute();
            return "OK!";
        } catch (SQLException e){
            e.printStackTrace();
            return "DB problems!";
        }
    }

    public int getUserId(String userNick){
        try(Statement statement = this.connection.createStatement()){
            String sqlStr = "Select user_id from user where user_nick='" + userNick + "'";
            ResultSet resultSet = statement.executeQuery(sqlStr);
            return resultSet.getInt("user_id");
        } catch (SQLException e){
            e.printStackTrace();
            return 0;
        }
    }

    public boolean isUserExists(String userNick){
        try(Statement statement = this.connection.createStatement()){
            String sqlStr = "Select user_id from user where user_nick='" + userNick + "'";
            ResultSet resultSet = statement.executeQuery(sqlStr);
            return !resultSet.isClosed();
        } catch (SQLException e){
            e.printStackTrace();
            return false;
        }
    }

    public String updateUser(int userId, String newNick){
        String sql = "UPDATE user SET user_nick = ? WHERE user_id = ?";

        try (PreparedStatement statement = this.connection.prepareStatement(sql)) {

            statement.setString(1, newNick);
            statement.setInt(2, userId);
            statement.executeUpdate();
            return "OK";
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return "Error!";
        }
    }

    public List getAllUsers(){
        try(Statement statement = this.connection.createStatement()){
            String sqlStr = "Select * from user";

            ResultSet resultSet = statement.executeQuery(sqlStr);

            List<String> usrList = new ArrayList<>();

            while (resultSet.next()){

                usrList.add(resultSet.getInt("user_id") + " : " + resultSet.getString("user_nick"));
            }
            return usrList;
        } catch (SQLException e){
            e.printStackTrace();
            return Collections.emptyList();
        }
    }
}
