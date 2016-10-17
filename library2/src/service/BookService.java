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
        String sql = "select * from book";//对数据库中的authors表进行扫描
        PreparedStatement ssss;int num=0;
       
        try {
        	 System.out.println("0000");
            ssss = (PreparedStatement)conn.prepareStatement(sql);
            ResultSet rs = ssss.executeQuery();
            while(rs.next()){//rs是按照authors表中，从上往下一个一个数下来，如果跟author一样，则返回1表示找到了，这个author是从前端传到后端的，待会儿会说在哪儿                                  
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
            ssss.close();//记得用完数据库要把数据库关掉
            conn.close();
            if(num==0){return null;}
            else{return list;}
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    

    }
    private static Connection getConn() {//获得数据库，写成一个函数，省的每次调用数据库都重复写一遍，只需要调用这个函数就可以了
        String driver = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/authors";
        String username = "root";
        String password = "insanity2014";
        Connection conn = null;
        try {
            Class.forName(driver); //classLoader,加载对应驱动
            conn = (Connection) DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }

}