package action;


import com.opensymphony.xwork2.Action;

import service.AuthorService;


public class BACK implements Action {                    
    public String execute() throws Exception {
        Integer i = 1;
        if (i>0)
            return SUCCESS;
        return ERROR;
    }
}