package dao.daoImpl;

import utils.ConfUtils;

import java.io.IOException;
import java.sql.*;

/**
 * #Author :Sino
 * #Date   :2021/11/13 11:43
 * #Describe:
 */
public abstract class MySQLBaseDao {
    public static Connection conn;
    static {
        try {
            String url = ConfUtils.getCoreConf("JDBC_URL");
            String userName = ConfUtils.getCoreConf("MYSQL_USER_NAME");
            String password = ConfUtils.getCoreConf("MYSQL_PASSWORD");

            Class.forName(ConfUtils.getCoreConf("MYSQL_DRIVER_NAME"));
            conn = DriverManager.getConnection(url, userName, password);
        } catch (IOException | ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public ResultSet query(String tableName) throws SQLException {
        String sql = "select * from " + tableName;
        PreparedStatement preparedStatement = conn.prepareStatement(sql);

        return preparedStatement.executeQuery();
    }

    public ResultSet query(String tableName, String userName) throws SQLException {
        String sql = "select * from " + tableName + " where user_name = ?";
        PreparedStatement preparedStatement = conn.prepareStatement(sql);
        preparedStatement.setString(1, userName);

        return preparedStatement.executeQuery();
    }

    public int insert(String tableName, String... fields) throws SQLException {
        String sql = "insert into " + tableName + " values(NULL, ?, ?, ?, ?, ?, ?)";
        PreparedStatement preparedStatement = conn.prepareStatement(sql);
        for (int index = 1; index <= fields.length; index++) {
            preparedStatement.setString(index, fields[index - 1]);
        }

        return preparedStatement.executeUpdate();
    }

    public int update(String tableName, String... fields) throws SQLException {
        String sql = "update " + tableName + " set user_password = ?" +
                " where user_name = ? and valid_question = ? and valid_answer = ?";
        PreparedStatement preparedStatement = conn.prepareStatement(sql);
        for (int index = 1; index <= fields.length; index++) {
            preparedStatement.setString(index, fields[index - 1]);
        }

        return preparedStatement.executeUpdate();
    }

    public static void close(Connection conn, Statement stmt, ResultSet resultSet) {
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }

        if (stmt != null) {
            try {
                stmt.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }

        if (resultSet != null) {
            try {
                resultSet.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }
}
