package com.barron;

import com.barron.utils.JDBCUtils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SqlInject {
    public static void main(String[] args) {

        login("'开发部' or 1=1",1);
    }

    public  static  void login(String dname,int deptno){
        Connection connection = null;
        Statement statement = null;
        try {
            connection = JDBCUtils.getConnection();
            statement = connection.createStatement();

//            String sql = "insert into dept(deptno,dname,db_source) values('11','hhhh','2')";
//            String sql = "delete from dept where deptno=11";
            String sql = "select * from dept where dname = "+dname ;

            ResultSet resultSet = statement.executeQuery(sql);

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
