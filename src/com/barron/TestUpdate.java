package com.barron;

import com.barron.utils.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TestUpdate {
    public static void main(String[] args) {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = JDBCUtils.getConnection();

            String sql = "update dept set dname = ? where deptno = ?";
            statement = connection.prepareStatement(sql);//预编译sql
            statement.setString(1,"d钉钉部门");
            statement.setInt(2,11);


            int i = statement.executeUpdate();
            if(i > 0){
                System.out.println("更新成功");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.release(connection,statement,null);
        }
    }
}
