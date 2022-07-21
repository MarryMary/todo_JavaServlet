package com.github.marrymary.todoapp.Action;

import com.github.marrymary.todoapp.Beans.ToDo;
import com.github.marrymary.todoapp.Front.Action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ToDoInsAction extends Action {
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        HttpSession session = request.getSession();

        int userid = (int)session.getAttribute("UserId");
        String text = request.getParameter("text");

        ToDo t = new ToDo();
        t.setText(text);
        t.setUserid(userid);

        com.github.marrymary.todoapp.DAO.ToDo dao = new com.github.marrymary.todoapp.DAO.ToDo();

        Boolean line = dao.Add(t);

        return line ? "todo_page.jsp" : "todo_err.jsp";
    }
}
