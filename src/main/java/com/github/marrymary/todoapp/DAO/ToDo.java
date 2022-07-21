package com.github.marrymary.todoapp.DAO;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ToDo extends DAO {
    public List<com.github.marrymary.todoapp.Beans.ToDo> Get(int UserId) throws Exception{
        List<com.github.marrymary.todoapp.Beans.ToDo> list = new ArrayList<>();

        Connection con = getConnection();

        PreparedStatement st = con.prepareStatement(
                "SELECT * FROM product WHERE UserId = ?"
        );

        st.setInt(1, UserId);
        ResultSet rs = st.executeQuery();

        while(rs.next()){
            com.github.marrymary.todoapp.Beans.ToDo t = new com.github.marrymary.todoapp.Beans.ToDo();
            t.setId(rs.getInt("Id"));
            t.setUserid(rs.getInt("UserId"));
            t.setText(rs.getString("Text"));

            list.add(t);
        }

        st.close();
        con.close();

        return list;
    }

    public Boolean Add(com.github.marrymary.todoapp.Beans.ToDo todo) throws Exception{
        Connection con = getConnection();

        PreparedStatement st = con.prepareStatement(
                "INSERT INTO ToDo VALUES (null, ?, ?)"
        );

        st.setInt(1, todo.getUserid());
        st.setString(2, todo.getText());

        int line = st.executeUpdate();

        st.close();
        con.close();

        return line != 0 ? true : false;
    }

    public Boolean Del(com.github.marrymary.todoapp.Beans.ToDo todo) throws Exception{
        Connection con = getConnection();

        PreparedStatement st = con.prepareStatement(
                "DELETE FROM ToDo WHERE Id = ?"
        );

        st.setInt(1, todo.getId());

        int line = st.executeUpdate();

        return line != 0 ? true: false;
    }
}
