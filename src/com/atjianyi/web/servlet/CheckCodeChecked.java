package com.atjianyi.web.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/checkCodeChecked")

public class CheckCodeChecked extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String codeNums = request.getParameter("codeNum");
        boolean flag = false;
        //获取HttpSession
        HttpSession session = request.getSession();
        String codeServer = (String)session.getAttribute("checkCode_Server");
        if(codeNums!=null){
           flag = codeServer.equalsIgnoreCase(codeNums);
        }
        if(flag){ //如果验证通过
            response.getWriter().write("true");
        }else{
            response.getWriter().write("false");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
