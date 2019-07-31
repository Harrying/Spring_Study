package com.briup.ioc.staticFactory;


import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactory {
    private static String driver;
    private static String url;
    private static String username;
    private static String password;

    static {
        driver="oracle.jdbc.driver.OracleDriver";
        url="jdbc:oracle:thin:@127.0.0.1:1521:XE";
        username="briup";
        password="briup";
    }
    public static Object getConnection() throws Exception {
        Class.forName(driver);
        Connection conn =
                DriverManager.getConnection(url,username,password);
        return conn;
    }


}
