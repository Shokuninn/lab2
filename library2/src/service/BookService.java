package service;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import domin.book;



public class BookService {
	private String Re=null;
	private List<book> list =new ArrayList<book>();
	
	public List<book> getList(){
		return list;
	}
	
	public void setList(List<book> list){
		this.list=list;
	}
	
	public void setRe(String re){
		this.Re=re;
	}
	public String getRe(){
		return Re;
	}
	
    public List<book> validateBook(book publisher) {
        Connection conn = getConn();
        String sql = "select * from book";//�����ݿ��е�authors�����ɨ��
        PreparedStatement ssss;int num=0;
       
        try {
        	 System.out.println("0000");
            ssss = (PreparedStatement)conn.prepareStatement(sql);
            ResultSet rs = ssss.executeQuery();
            while(rs.next()){//rs�ǰ���authors���У���������һ��һ���������������authorһ�����򷵻�1��ʾ�ҵ��ˣ����author�Ǵ�ǰ�˴�����˵ģ��������˵���Ķ�                                  
                       String ISBN=rs.getString(1);
                        String Title=rs.getString(2);
                        String AuthorID=rs.getString(3);
                        String Publisher=rs.getString(4);
                        String PublishDate=rs.getString(5);
                        String Price=rs.getString(6);
                       if(AuthorID.equals(publisher.getPublisher())){
                        book tl=new book(ISBN, Title, AuthorID, Publisher,PublishDate,Price);
                        list.add(tl);num++;}                                                           	
               // }
            }
            ssss.close();//�ǵ��������ݿ�Ҫ�����ݿ�ص�
            conn.close();
            if(num==0){return null;}
            else{return list;}
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    

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