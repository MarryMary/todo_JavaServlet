package com.github.marrymary.todoapp.Action;

import com.github.marrymary.todoapp.Front.Action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LogoutAction extends Action {
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        HttpSession session = request.getSession();
        session.removeAttribute("IsAuth");
        session.removeAttribute("UserId");

        return "login.jsp";
    }
}
