package com.github.marrymary.todoapp.Action;

import com.github.marrymary.todoapp.DAO.ToDo;
import com.github.marrymary.todoapp.Front.Action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

public class ToDoViewAction extends Action {
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ToDo todoDao = new ToDo();
        HttpSession session = request.getSession();
        if(session.getAttribute("IsAuth") == null || (Boolean) session.getAttribute("IsAuth") == false) return "login.jsp";

        List<com.github.marrymary.todoapp.Beans.ToDo> list = todoDao.Get((int)session.getAttribute("UserId"));

        session.setAttribute("list", list);

        return "todo_page.jsp";
    }
}
