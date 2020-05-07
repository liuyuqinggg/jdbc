package com.barron;

import com.barron.utils.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TestDelete {
    public static void main(String[] args) {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = JDBCUtils.getConnection();

            String sql = "delete from dept where dname = ?";
            statement = connection.prepareStatement(sql);//预编译sql
//            statement.setInt(1,11);
            statement.setString(1,"d钉钉部门 or 1=1");

            int i = statement.executeUpdate();
            if(i > 0){
                System.out.println("删除成功");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.release(connection,statement,null);
        }
    }
}
