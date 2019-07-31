package com.briup.ioc.factory;

import org.springframework.beans.factory.FactoryBean;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactory implements FactoryBean<Connection> {
    private String driver;
    private String url;
    private String username;
    private String password;


    //返回工厂的产品
    @Override
    public Connection getObject() throws Exception {
        Class.forName(driver);
        return DriverManager.getConnection(url,username,password);
    }

    //返回产品的类型
    @Override
    public Class<?> getObjectType() {
        return null;
    }

    //判断是否是单例模式，false代表单例
    @Override
    public boolean isSingleton() {
        return false;
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

    @Override
    public String toString() {
        return "ConnectionFactory{" +
                "driver='" + driver + '\'' +
                ", url='" + url + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
