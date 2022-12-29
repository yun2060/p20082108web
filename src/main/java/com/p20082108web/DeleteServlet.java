package com.p20082108web;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

@WebServlet(name = "DeleteServlet", value = "/DeleteServlet")
public class DeleteServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset = utf-8");
        String rid = request.getParameter("stuid");
        String sql="delete from t_20082108 where rid='"+rid+"'";
        try {
            Connection con=sqlutils.getcon();
            Statement stmt = con.createStatement();
            int ret=stmt.executeUpdate(sql);
            if(ret==1){
                response.sendRedirect("main.html");
            }
            else{
                response.sendRedirect("add.jsp");
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}
