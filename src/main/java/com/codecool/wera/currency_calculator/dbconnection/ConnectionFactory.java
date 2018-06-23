package com.codecool.wera.currency_calculator.dbconnection;

import org.apache.commons.dbcp2.BasicDataSource;

import java.sql.Connection;
import java.sql.SQLException;

public class ConnectionFactory {

    private static BasicDataSource dataSource;
    private ConnectionFactory() {}

    public static Connection getConnection() throws SQLException {

        if(dataSource==null) {
            dataSource = new BasicDataSource();
            dataSource.setUrl("jdbc:h2:file:~/logs");
            dataSource.setDriverClassName("org.h2.Driver");
            dataSource.setUsername("sa");
            dataSource.setPassword("");
        }

        return dataSource.getConnection();
    }
}
