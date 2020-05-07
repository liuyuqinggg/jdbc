package com.barron;

import com.barron.utils.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TestQuery {
    public static void main(String[] args) {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = JDBCUtils.getConnection();

            String sql = "select * from dept where deptno = ?";
            statement = connection.prepareStatement(sql);//预编译sql
            statement.setInt(1,11);

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()){
                System.out.println("deptno=" + resultSet.getObject("deptno"));
                System.out.println("dname=" + resultSet.getObject("dname"));
                System.out.println("db_source=" + resultSet.getObject("db_source"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.release(connection,statement,null);
        }
    }
}
