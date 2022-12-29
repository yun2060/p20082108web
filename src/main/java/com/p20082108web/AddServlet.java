package com.p20082108web;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "AddServlet", value = "/AddServlet")
public class AddServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset = utf-8");
        String stuno=request.getParameter("txt20082108");
        String stuname=request.getParameter("txthusuyun");
        String stuschool=request.getParameter("txtschool");
        String stumajor=request.getParameter("txtmajor");
        String startdate=request.getParameter("startdate");
        String enddate=request.getParameter("enddate");
        String Symptom=request.getParameter("txtSymptom");

    }

}
