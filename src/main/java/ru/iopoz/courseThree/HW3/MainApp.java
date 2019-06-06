package ru.iopoz.courseThree.HW3;

import ru.iopoz.courseThree.HW2.DBHelper;

import java.io.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainApp {
    private static DBHelper dbConnection;

    static {
        try {
            dbConnection = new DBHelper();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static String USER_NAME = "";
    private static int CLIENT_ID = 0;

    public MainApp() throws SQLException {
    }

    public static void main(String[] args) throws IOException {
        String answer = "1";
        boolean flag = true;
        System.out.println("Enter your nick: ");
        BufferedReader reader =
                new BufferedReader(new InputStreamReader(System.in));
        String userName = reader.readLine();
        if (!authUser(userName)) {
            System.out.println("Incorrect user name!");
            System.out.println("Added New user. Do you want login as " + userName);
            System.out.println("1- Yes, 2- No");
            answer = reader.readLine();
            if (answer.equals("2")) return;
            addUser(userName);
        }
        USER_NAME = userName;
        CLIENT_ID = getUserId(userName);
        startChating(CLIENT_ID, reader);
    }

    private static void startChating(int clientId, BufferedReader reader) throws IOException {
        readLastMsg(clientId);
        System.out.println("For exit you need to input: @EXIT");
        System.out.println("For sending private message you need to input: @USER_NICK and message");
        String msg = "";
        while (!msg.equals("@EXIT")){
            msg = reader.readLine();
            if (msg.startsWith("@")){
                List<String> msgArray = new ArrayList<String>(Arrays.asList(msg.split(" ")));
                if (msgArray.get(0).equals("@EXIT")) return;
                sendPrivateMsg(msgArray);
            } else {
                sendBroadCast(msg);
            }
        }
    }

    private static void sendBroadCast(String msg) {
        List<String> allUsers = dbConnection.getAllUsers();
        for (String userStr: allUsers) {
            List<String> nickValueList = new ArrayList<String>(Arrays.asList(userStr.split(" ")));
            int recipientId = dbConnection.getUserId(nickValueList.get(2));
            String msgStr = USER_NAME + ": " + msg;
            writeMsg(recipientId, msgStr);
        }
    }

    private static void sendPrivateMsg(List<String> msgArray) {
        String msg = USER_NAME + ": " + msgArray.subList(1, msgArray.size());
        List<String> nickValueList = new ArrayList<String>(Arrays.asList(msgArray.get(0).split("@")));
        int recipientId = dbConnection.getUserId(nickValueList.get(1));
        writeMsg(CLIENT_ID, msg);
        writeMsg(recipientId, msg);
    }

    private static void writeMsg(int userId, String msg){
        try(FileWriter fw = new FileWriter(prepareFileName(userId), true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter writer = new PrintWriter(bw))
        {
            writer.println(msg);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void readLastMsg(int userId){
        try (BufferedReader reader = new BufferedReader(new FileReader(prepareFileName(userId)))) {
            String str;
            List<String> msgArray = new ArrayList<>();
            while ((str = reader.readLine()) != null) {
                msgArray.add(str);
            }
            if (msgArray.size() > 100){
                msgArray = msgArray.subList(msgArray.size() - 100, msgArray.size());
            }
            printMessages(msgArray);
        } catch (IOException e) {
            writeMsg(userId, "Hello my friend!");
            //e.printStackTrace();
        }
    }

    private static void printMessages(List<String> msgArray){
        for (String msg: msgArray) {
            System.out.println(msg);
        }
    }

    private static String prepareFileName(int userId){
        String fileName = userId + ".txt";
        return fileName;
    }

    private static Boolean authUser(String nick){
        return dbConnection.isUserExists(nick);
    }

    private static String addUser(String nick){
        return dbConnection.addUser(nick);
    }

    private static Integer getUserId(String nick){
        return dbConnection.getUserId(nick);
    }
}
