package com.endava;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws SQLException {

        Scanner sc = new Scanner(System.in);

        String address = "jdbc:mysql://localhost:3306/temp?useSSL=false&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";

        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        ConnectionHandler handler = new ConnectionHandler(DriverManager.getConnection(address, "root", "stasik"));

        MenuCreator menu = new MenuCreator(handler, sc);
        menu.choiceMenu();

    }
}
