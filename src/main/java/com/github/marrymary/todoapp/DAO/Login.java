package com.github.marrymary.todoapp.DAO;

import com.github.marrymary.todoapp.Beans.User;

import javax.servlet.http.HttpSession;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Login extends DAO{
    private User u;
    public Boolean auth(String login, String password) throws Exception {
        Connection con = getConnection();
        Boolean flag = false;

        PreparedStatement st = con.prepareStatement(
                "SELECT * FROM User WHERE Login = ?"
        );
        st.setString(1, login);
        ResultSet rs = st.executeQuery();

        User u = new User();


        while(rs.next()){
            u.setId(rs.getInt("Id"));
            u.setLogin(rs.getString("Login"));
            u.setPassword(rs.getString("Password"));
        }

        if(u.getLogin() == login && u.getPassword() == password){
            flag = true;
        }

        st.close();
        con.close();

        return flag;
    }

    public User getUser(){
        return this.u;
    }
}
