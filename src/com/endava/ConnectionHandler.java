package com.endava;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ConnectionHandler implements Repository {

    private Connection con;

    ConnectionHandler(Connection connection) {
        this.con = connection;
        try {
            con.setAutoCommit(false);
            init();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void init() throws SQLException {
        String[] sql = {"insert into banking.ingredients values ('COFFEE', 1000);",
                "insert into banking.ingredients values ('WATER', 2000);",
                "insert into banking.ingredients values ('MILK', 1000);",
                "insert into banking.ingredients values ('CHOCOLATE', 1000);",
                "insert into banking.ingredients values ('MILKFOAM', 1000);",
                "insert into banking.ingredients values ('SUGAR', 100);"};
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
