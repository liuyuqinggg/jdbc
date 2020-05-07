package com.barron;

import com.barron.utils.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class TestInsert {
    public static void main(String[] args) {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = JDBCUtils.getConnection();

            String sql = "insert into dept(deptno,`dname`,`db_source`)  values(?,?,?)";
            statement = connection.prepareStatement(sql);//预编译sql
            statement.setInt(1,11);
            statement.setString(2,"部门");
            statement.setString(3,"db11");

            int i = statement.executeUpdate();
            if(i > 0){
                System.out.println("插入成功");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.release(connection,statement,null);
        }
    }
}
