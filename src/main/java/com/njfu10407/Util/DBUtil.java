package com.njfu10407.Util;

import java.sql.*;

public class DBUtil{
    /*
        通常工具类的构造方法是私有的
        因为工具类当中的方法都是静态的，不需要new对象，直接采用类名调用
    */
    private DBUtil(){}

    //静态代码块在类加载时执行且只执行一次
    static{
        //注册驱动
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
        }
        catch(ClassNotFoundException e){
            e.printStackTrace();
        }
    }

    //获取数据库连接对象，返回连接对象，抛出异常
    public static Connection getConnection() throws SQLException{
        String url= "jdbc:mysql://localhost:3306/studentmanager?useUnicode=true&characterEncoding=utf8&useSSL=false&serverTimezone=GMT";
        String user ="root";
        String password = "123456";
        return DriverManager.getConnection(url, user, password);
    }

    //释放资源
    public static void close(Connection conn, Statement stmt, ResultSet rs){
        try{
            if (rs != null) {
                rs.close();
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        try{
            if (stmt != null) {
                stmt.close();
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        try{
            if (conn != null) {
                conn.close();
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}