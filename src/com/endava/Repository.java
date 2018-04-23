package com.endava;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

public interface Repository {

    void update(String sql, HashMap<?, ?> values) throws SQLException;

    ResultSet get(String sql) throws SQLException;

}
