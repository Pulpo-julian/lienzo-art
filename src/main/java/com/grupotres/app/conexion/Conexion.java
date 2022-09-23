package com.grupotres.app.conexion;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class Conexion {

    private static final String DB_URL = "jdbc:mysql://localhost:3306/lienzoart";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "";

    public static Connection getConnection() throws SQLException, ClassNotFoundException{

        Connection conn = null;
        Class.forName("com.mysql.cj.jdbc.Driver");
        conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
        return conn;

    }


    public static void closeConnection(ResultSet res) {

        try {
            res.close();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }


    }

    public static void closeConnection(Statement stmt) {
        try {
            stmt.close();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
    }

    public static void closeConnection(PreparedStatement stmt) {

        try {
            stmt.close();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }


    }

    public static void closeConnection(Connection conn) {

        try {
            conn.close();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }

    }

}
