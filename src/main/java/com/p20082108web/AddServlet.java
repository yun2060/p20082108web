package com.p20082108web;

import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

@WebServlet(name = "AddServlet", value = "/AddServlet")
public class AddServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset = utf-8");
        String stuno=request.getParameter("txt20082108");
        String stuname=request.getParameter("txthusuyun");
        String stuschool=request.getParameter("txtschool");
        String stumajor=request.getParameter("txtmajor");
        String startdate=request.getParameter("startdate");
        String enddate=request.getParameter("enddate");
        String symptom=request.getParameter("txtSymptom");

        try {
            Connection con = sqlutils.getcon();
            String sql;
            if (enddate.length()==0){
                sql="insert into t_20082108(stuno,stuname,stuschool,stumajor,startdate,symptom)"
                        +"values('"+stuno+"','"+stuname+"','"+stuschool+"','"+stumajor+"','"+startdate+"','"+symptom+"')";
            }
            else {
                sql = "insert into t_20082108(stuno,stuname,stuschool,stumajor,startdate,enddate,symptom)"
                        + "values('" + stuno + "','" + stuname + "','" + stuschool + "','" + stumajor + "','" + startdate + "','" + enddate + "','" + symptom + "')";
            }
            Statement stmt = con.createStatement();
            int rs = stmt.executeUpdate(sql);
            if (rs==1) {
                response.sendRedirect("main.html");
            }
            stmt.close();
            con.close();
        }catch (ClassNotFoundException e) {
            response.getWriter().print("class not found");
            e.printStackTrace();
        }catch (SQLException e) {
            response.getWriter().print("sql connected failed");
            e.printStackTrace();
        }
    }
}