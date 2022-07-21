package com.github.marrymary.todoapp.Action;

import com.github.marrymary.todoapp.Beans.ToDo;
import com.github.marrymary.todoapp.Front.Action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ToDoRemAction extends Action {
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception{
        int id = Integer.parseInt(request.getParameter("id"));

        ToDo t = new ToDo();

        t.setId(id);

        com.github.marrymary.todoapp.DAO.ToDo todo = new com.github.marrymary.todoapp.DAO.ToDo();

        Boolean res = todo.Del(t);
        if(res){
            return "todo_page.jsp";
        }else{
            return "todo_err.jsp";
        }
    }
}
