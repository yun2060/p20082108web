package com.p20082108web;
import java.sql.*;
public class sqlutils {
    public static String url="jdbc:mysql://localhost:3306/husuyun_db";
    public static String user= "20082108husuyun";
    public static String pwd="20082108";
    //获得数据库连接
    public static Connection getcon() throws ClassNotFoundException, SQLException {
        //1加载mysql驱动
        Class.forName("com.mysql.jdbc.Driver");
        //2建立到数据库的连接
        return DriverManager.getConnection(sqlutils.url, sqlutils.user, sqlutils.pwd);
    }

}
