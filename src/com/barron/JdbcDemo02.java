package com.barron;

import com.barron.utils.JDBCUtils;

import java.sql.*;

public class JdbcDemo02 {
    public static void main(String[] args) {
        Connection connection = null;
        Statement statement = null;
        try {
            connection = JDBCUtils.getConnection();
            statement = connection.createStatement();

//            String sql = "insert into dept(deptno,dname,db_source) values('11','hhhh','2')";
//            String sql = "delete from dept where deptno=11";
            String sql = "update dept set dname = 'ooo' where deptno=2";

            int i = statement.executeUpdate(sql);
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
