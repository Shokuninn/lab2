package service;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import domin.book;


public class delete1 {
    public Integer deleteBook(book publisher) {
        Connection conn = getConn();
        PreparedStatement ssss;
        String sql="delete from book where Title='"+publisher.getPublisher()+"'";
        System.out.println("0000");
        try {
        	ssss = (PreparedStatement)conn.prepareStatement(sql);
        	ssss.executeUpdate(sql);
        	ssss.close();
        	//String sql="delete from book where Title='"+publisher.getPublisher()+"'";
        	
            conn.close();
            return 1;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;

    }
    private static Connection getConn() {//������ݿ⣬д��һ��������ʡ��ÿ�ε������ݿⶼ�ظ�дһ�飬ֻ��Ҫ������������Ϳ�����
        String driver = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/authors";
        String username = "root";
        String password = "insanity2014";
        Connection conn = null;
        try {
            Class.forName(driver); //classLoader,���ض�Ӧ����
            conn = (Connection) DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }

}