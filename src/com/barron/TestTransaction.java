package com.barron;

import com.barron.utils.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TestTransaction {
    public static void main(String[] args) {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = JDBCUtils.getConnection();
            connection.setAutoCommit(false); //开启事务

            String sql = "update dept set dname = ? where deptno = ?";
            statement = connection.prepareStatement(sql);//预编译sql
            statement.setString(1,"钉钉部门");
            statement.setInt(2,11);

            int i = statement.executeUpdate();
            if(i > 0){
                System.out.println("更新成功");
            }

            int x = 1/0;
            String sql2 = "update dept set dname = ? where deptno = ?";
            statement = connection.prepareStatement(sql);//预编译sql
            statement.setString(1,"xxx钉钉部门");
            statement.setInt(2,11);


            int j = statement.executeUpdate();
            if(j > 0){
                System.out.println("更新成功");
            }

            //提交事务
            connection.commit();
        } catch (SQLException e) {
            try {
                connection.rollback();//失败回滚,不写也可以，失败会自动回滚
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            e.printStackTrace();
        } finally {
            JDBCUtils.release(connection,statement,null);
        }
    }
}
