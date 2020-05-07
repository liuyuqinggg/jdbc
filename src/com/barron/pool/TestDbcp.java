package com.barron.pool;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TestDbcp {

    public static void main(String[] args) {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = DBCPUtils.getConnection();

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
            DBCPUtils.release(connection,statement,null);
        }
    }
}
