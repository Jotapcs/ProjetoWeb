package com.example.projetoweb;

import java.sql.Connection;
import java.sql.DriverManager;

public class Database {

    /* Connect Database */
    public static Connection connect() throws Exception{
        Class.forName("com.mysql.cj.jdbc.Driver");
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/projetotcc","root","root");
    }

    /* Connect Database Test */
    public static void main(String[] args) throws Exception{
        connect();
    }
}
