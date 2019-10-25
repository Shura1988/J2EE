package userlist;


import Dao.impl.BaseDaoImpl;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.util.Scanner;

public class Connect {
    private static final String url = new Connect().getProperty("url");
    private static final String username = new Connect().getProperty("username");
    private static final String password = new Connect().getProperty("password");
    Connection connection;
    public Connection getConnection() {
        try {
            connection = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }
    public String getProperty(String propertyName) {
        Properties properties = new Properties();
        String property = "";
        try (InputStream is = this.getClass().getResourceAsStream("/config.properties")) {
            properties.load(is);
             property = properties.getProperty(propertyName);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return property;
    }

}


















   /* private final String url = "jdbc:mysql://localhost/userlist?serverTimezone=Europe/Minsk&useSSL=false";
    private final String username = "root";
    private final String password = "SCN932hdu";
    private Connection connect;

    public Connect() {
        try {
            this.connect = DriverManager.getConnection(url, username, password);
            System.out.println("Connect ok ");
        } catch (SQLException ex) {
            System.out.println("Connection failed...");
        }
    }

    public Connection getConnection() {
        return connect;
    }

    public void setConnection(Connection connection) {
        this.connect = connection;
    }

}*/