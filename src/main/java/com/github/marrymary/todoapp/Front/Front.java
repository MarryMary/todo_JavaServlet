package com.github.marrymary.todoapp.Front;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.Date;

@WebServlet(urlPatterns = {"*.action"})
public class Front {
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        PrintWriter out = response.getWriter();
        try{
            String path = request.getServletPath().substring(1);
            String name = "com.github.marrymary.todoapp."+path.replace(".a", "A").replace("/", ".");
            Action action = (Action) Class.forName(name).getDeclaredConstructor().newInstance();
            String url = action.execute(request, response);
            request.getRequestDispatcher(url).forward(request, response);
        }catch(Exception e){
            new PrintWriter(new FileWriter("../log"));
        }
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        this.doPost(request, response);
    }
}
