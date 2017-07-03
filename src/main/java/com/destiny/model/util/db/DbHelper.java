package com.destiny.model.util.db;


import com.destiny.model.exception.DataAccessException;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;

import java.sql.Connection;
import java.sql.SQLException;

public class DbHelper {

    /* update insert delete  */
    public static int update(String sql, Object... params) {
        QueryRunner queryRunner = new QueryRunner();
        Connection connection = ConnectionManager.getConnection();
        try {
            return queryRunner.update(connection, sql, params);
        } catch (SQLException e) {
            throw new DataAccessException("执行:" + sql + "异常", e);
        } finally {
            ConnectionManager.closeConnection(connection);
        }
    }

    /* select */
    public static <T> T query(String sql, ResultSetHandler<T> handler, Object... params) {
        QueryRunner queryRunner = new QueryRunner();
        Connection connection = ConnectionManager.getConnection();
        try {
            return queryRunner.query(connection, sql, handler, params);
        } catch (SQLException e) {
            throw new DataAccessException("执行:" + sql + "异常", e);
        } finally {
            ConnectionManager.closeConnection(connection);
        }
    }

}
