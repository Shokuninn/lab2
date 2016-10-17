package action;


import com.opensymphony.xwork2.Action;

import domin.book;
import service.delete1;

public class delete implements Action {                    
    private book book		;
    public book getPublisher() {
        return book;
    }
    public void setPublisher(book publisher) {
        this.book = publisher;
    }
    @Override
    public String execute() throws Exception {
        delete1 au=new delete1();
        Integer i =au.deleteBook(book);
        if (i>0)
            return SUCCESS;
        return ERROR;
    }

}