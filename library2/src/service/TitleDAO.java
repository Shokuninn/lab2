package service;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import domin.book;
import action.Search;
import service.BookService;

public class TitleDAO {
    public List readFirstTitle(){

        List<book> list =new ArrayList<book>();
        Connection con=null;
        String Author_ID;
        BookService rr=new BookService();
        Author_ID = rr.getRe();
        System.out.println(Author_ID);
        PreparedStatement psmt=null;
        ResultSet rs=null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        
        try {
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/authors","root","insanity2014");
            String sql="select * from book ";
            psmt=con.prepareStatement(sql);
            rs=psmt.executeQuery();
            
            while(rs.next())
            {
                
				
               String ISBN=rs.getString(1);
                String Title=rs.getString(2);
                String AuthorID=rs.getString(3);
                String Publisher=rs.getString(4);
                String PublishDate=rs.getString(5);
                String Price=rs.getString(6);
                book tl=new book(ISBN, Title, AuthorID, Publisher,PublishDate,Price);
                list.add(tl);
                
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        }finally
        {
            try {
                if(rs!=null)
                {
                    rs.close();
                }
                if(psmt!=null)
                {
                    psmt.close();
                }
                if(con!=null)
                {
                    con.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return list;
    }
    
}