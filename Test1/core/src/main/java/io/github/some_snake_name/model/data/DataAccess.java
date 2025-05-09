package io.github.some_snake_name.model.data;


import java.sql.*;

public class DataAccess  {

    private String DRIVER_CLASS="com.microsoft.sqlserver.jdbc.SQLServerDriver";
    private String URL = "jdbc:sqlserver://LAPTOP-255KNM82:1433;DatabaseName=GameData;encrypt=false";
    private String USER="sa";
    private String PASSWORD ="123456789";
    //
    private Connection connection;

    public DataAccess(){
        connection= null;
    }

    public void createConnection() throws ClassNotFoundException, SQLException {
        // load driver
            Class.forName(DRIVER_CLASS);
            System.out.println("load drive is done");

        //crate connection
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("create connection is done");
    }

    public Connection getConnection(){
        return connection;
    }

    public void closeConnection() throws SQLException {
        if(connection != null){
                if(!connection.isClosed()){
                    connection.close();
                    System.out.println("close connection successfully");
                }
        }
    }

    public static void main(String[] args) {
        DataAccess dataAccess = new DataAccess();
        try {
            dataAccess.createConnection();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();  // ← in lỗi rõ ràng hơn
        } finally {
            try {
                dataAccess.closeConnection();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }



}
