package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Objects;

public class ConnectionInstance {
    private Connection conn;
    private static ConnectionInstance instance;

    public static ConnectionInstance getConnection(){
        if (Objects.isNull(instance)){
            instance = new ConnectionInstance();
        }
        return instance;
    }

    public ConnectionInstance(){
        try {
            this.verifyDriver();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void disconnect() throws Exception {
        try {
            if (conn != null) {
                conn.close();
            }
        } catch (Exception e) {
            throw e;
        }
    }

    public void connect() throws SQLException{
        try{
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Strategy", "root", "1234");
        }catch (SQLException e){
            System.err.println("SQLException: "+ e.getMessage());
            throw e;
        }
    }
    private void verifyDriver() throws ClassNotFoundException {
        try{
            Class.forName("com.mysql.jdbc.driver");
        }catch (ClassNotFoundException ex){
            System.err.println("ClassNotFoundException: "+ex.getMessage());
            throw ex;
        }
    }

    public Connection getConn() {
        return conn;
    }
}