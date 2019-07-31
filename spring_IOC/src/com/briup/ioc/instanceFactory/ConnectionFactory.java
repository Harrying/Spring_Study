package com.briup.ioc.instanceFactory;


import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactory {
    private String driver;
    private String url;
    private String username;
    private String password;

    public Object getConnection() throws Exception {
        Class.forName(driver);
        Connection conn =
                DriverManager.getConnection(url,username,password);
        return conn;
    }

    public String getDriver() {
        return driver;
    }

    public void setDriver(String driver) {
        this.driver = driver;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
