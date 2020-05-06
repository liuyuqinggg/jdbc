package com.barron;

import java.sql.*;

public class JdbcDemo01 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
//        DriverManager.registerDriver(new com.mysql.jdbc.Driver()); //不建议
        Class.forName("com.mysql.jdbc.Driver");

        String url = "jdbc:mysql://localhost:3306/db01?useUnicode=true&characterEncoding=utf8&useSSL=true";

        String username = "root";
        String password = "root";

        //数据库连接
        Connection connection = DriverManager.getConnection(url, username, password);
//        connection.prepareStatement();
        Statement statement = connection.createStatement();

        String sql = "select * from dept";

        ResultSet resultSet = statement.executeQuery(sql);
//        statement.execute();
//        statement.executeUpdate();

        while (resultSet.next()){
            System.out.println("deptno=" + resultSet.getObject("deptno"));
            System.out.println("dname=" + resultSet.getObject("dname"));
            System.out.println("db_source=" + resultSet.getObject("db_source"));
        }

        resultSet.close();
        statement.close();
        connection.close();
    }
}
