package action;


import java.util.ArrayList;
import java.util.List;

import com.opensymphony.xwork2.Action;

import domin.book;
import service.BookService;

public class Search implements Action {   
private List<book> list =new ArrayList<book>();
	
	public List<book> getList(){
		return list;
	}
	
	public void setList(List<book> list){
		this.list=list;
	}
    private book book		;
    public book getPublisher() {
        return book;
    }
    public void setPublisher(book publisher) {
        this.book = publisher;
    }
    @Override
    public String execute() throws Exception {
    
        BookService au=new BookService();
        list=au.validateBook(book);
        if (list!=null)
            return SUCCESS;
        return ERROR;
    }

}