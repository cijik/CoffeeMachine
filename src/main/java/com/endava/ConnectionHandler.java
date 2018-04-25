package com.endava;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.*;
import java.util.HashMap;
import java.util.Map;

public class ConnectionHandler implements Repository {

    private Connection con;
    private Logger log = LoggerFactory.getLogger(ConnectionHandler.class);

    ConnectionHandler(Connection connection) {
        this.con = connection;
        try {
            con.setAutoCommit(false);
            init();
        } catch (SQLException e) {
            log.error("Cannot perform SQL operation");
        }
    }

    private void init() throws SQLException {
        String[] sql = {"INSERT INTO ingredients VALUES ('COFFEE', 1000);",
                "INSERT INTO ingredients VALUES ('WATER', 2000);",
                "INSERT INTO ingredients VALUES ('MILK', 1000);",
                "INSERT INTO ingredients VALUES ('CHOCOLATE', 1000);",
                "INSERT INTO ingredients VALUES ('MILKFOAM', 1000);",
                "INSERT INTO ingredients VALUES ('SUGAR', 100);"};
        PreparedStatement stmt;
        for (String s : sql) {
            stmt = con.prepareStatement(s);
            stmt.executeUpdate();
        }
        con.commit();
    }

    public void update(String sql, HashMap<?, ?> values) throws SQLException {
        PreparedStatement stmt = con.prepareStatement(sql);
        for (Map.Entry<?, ?> entry : values.entrySet()) {
            stmt.setObject(2, entry.getKey());
            stmt.setObject(1, entry.getValue());
            stmt.executeUpdate();
        }
        con.commit();
        con.close();
    }

    public ResultSet get(String sql) throws SQLException {
        Statement stmt = con.createStatement();
        return stmt.executeQuery(sql);
    }

}
