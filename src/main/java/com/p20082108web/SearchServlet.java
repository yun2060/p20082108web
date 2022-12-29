package com.p20082108web;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

@WebServlet(name = "SearchServlet", value = "/SearchServlet")
public class SearchServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset = utf-8");
        String Ipt=request.getParameter("Ipt");
        String sql="select * from t_20082108 ";
        if (Ipt!=null&&Ipt.trim().length()>0){
            sql+="where stuname like '%"+Ipt+"%' or stuno like'%"+Ipt+"%'";
        }

        try {
            Connection con = sqlutils.getcon();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            StringBuilder res = new StringBuilder();
            res.append("{\"students\":[");
            while (rs.next()) {
                String stuid = rs.getString("rid");
                String stuno = rs.getString("stuno");
                String stuname = rs.getString("stuname");
                String stuschool = rs.getString("stuschool");
                String stumajor = rs.getString("stumajor");
                String startdate = rs.getString("startdate");
                String enddate = rs.getString("enddate");
                String symptom = rs.getString("symptom");
                res.append("{");
                res.append("\"stuid\":\"" + stuid + "\",");
                res.append("\"stuno\":\"" + stuno + "\",");
                res.append("\"stuname\":\"" + stuname + "\",");
                res.append("\"stuschool\":\"" + stuschool + "\",");
                res.append("\"stumajor\":\"" + stumajor + "\",");
                res.append("\"startdate\":\"" + startdate + "\",");
                res.append("\"enddate\":\"" + enddate + "\",");
                res.append("\"symptom\":\"" + symptom + "\"");
                res.append("},");
            }
            String json="";
            if (res.length()>1){
                json=res.substring(0,res.length()-1)+"]}";
            }
            else{
                json+="]}";
            }
            response.getWriter().println(json);
//            response.getWriter().println("<table border='1'>");
//            while (rs.next()) {
//                String stuno = rs.getString("stuno");
//                String stuname = rs.getString("stuname");
//                String stuschool = rs.getString("stuschool");
//                String stumajor = rs.getString("stumajor");
//                String startdate = rs.getString("startdate");
//                String enddate = rs.getString("enddate");
//                String symptom = rs.getString("symptom");
//                response.getWriter().println("<tr>");
//                response.getWriter().println("<td>" + stuno + "</td>");
//                response.getWriter().println("<td>" + stuname + "</td>");
//                response.getWriter().println("<td>" + stuschool + "</td>");
//                response.getWriter().println("<td>" + stumajor + "</td>");
//                response.getWriter().println("<td>" + startdate + "</td>");
//                response.getWriter().println("<td>" + enddate + "</td>");
//                response.getWriter().println("<td>" + symptom + "</td>");
//                response.getWriter().println("<tr>");
//            }
//            response.getWriter().println("</table>");
            rs.close();
            stmt.close();
            con.close();
        }catch (ClassNotFoundException e){
            response.getWriter().print("class not found");
            e.printStackTrace();
        }catch (SQLException e) {
            response.getWriter().print("sql connected failed");
            e.printStackTrace();
        }

    }
}
