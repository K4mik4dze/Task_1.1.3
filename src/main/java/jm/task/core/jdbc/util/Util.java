package jm.task.core.jdbc.util;

import java.sql.*;

public class Util {
    protected static final String URL = "jdbc:mysql://localhost:3306/task113?useSSL=false";
    private static final String LOGIN = "root";
    private static final String PASSWORD = "Kingobiloba@61bb";

    public static String getUrl() {
        return URL;
    }

    public static String getLogin() {
        return LOGIN;
    }

    public static String getPassword() {
        return PASSWORD;
    }

    public static void registerDriver() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static Connection startConnection() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(Util.getUrl(), Util.getLogin(), Util.getPassword());
        } catch (SQLException throwables) {
            System.out.println("Ошибка установления соединения с базой данных!");
            throwables.printStackTrace();
        }
        return connection;
    }

    public static Statement getStatement(Connection connection) {
        Statement statement = null;
        try {
            statement = connection.createStatement();
        } catch (SQLException throwables) {
            System.out.println("Ошибка создания statement!");
            throwables.printStackTrace();
        }
        return statement;
    }

    public static void closeConnections(Statement statement, Connection connection) {
        try {
            statement.close();
            connection.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
