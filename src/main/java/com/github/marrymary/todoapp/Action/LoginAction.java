package com.github.marrymary.todoapp.Action;

import com.github.marrymary.todoapp.DAO.Login;
import com.github.marrymary.todoapp.Front.Action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginAction extends Action {
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        HttpSession session = request.getSession();
        String login = request.getParameter("Login");
        String password = request.getParameter("Post");
        Login auth = new Login();

        Boolean AuthMode = (Boolean) session.getAttribute("IsAuth");

        if(AuthMode != null) return "todo_page.jsp";

        Boolean res = auth.auth(login, password);
        if(res){
            session.setAttribute("IsAuth", true);
            return "todo_page.jsp";
        }else{
            return "login_err.jsp";
        }
    }
}
