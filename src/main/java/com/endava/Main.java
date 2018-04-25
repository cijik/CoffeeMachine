package com.endava;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws SQLException {

        Scanner sc = new Scanner(System.in);
        Logger log = LoggerFactory.getLogger(Main.class);

        final String dialect = "mysql";
        final String host = "localhost";
        final int port = 3306;
        final String schema = "banking";
        final String timezone = "UTC";
        String address = String.format("jdbc:%s://%s:%d/%s?serverTimezone=%s", dialect, host, port, schema, timezone);

        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            log.error("Unable to load database driver");
        }

        final String user = "root";
        final String password = "stasik";
        ConnectionHandler handler = new ConnectionHandler(DriverManager.getConnection(address, user, password));

        MenuCreator menu = new MenuCreator(handler, sc);
        menu.choiceMenu();

    }
}
