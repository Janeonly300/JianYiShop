package com.atjianyi.web.servlet;

import com.atjianyi.service.UserService;
import com.atjianyi.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/manager/douserDel")
public class DoUserDel extends HttpServlet {
    private UserService  service = new UserServiceImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String[] ids = request.getParameterValues("id[]");
        int idInt = 0;
        int row = 0;
        for (String id : ids) {
            idInt  = Integer.parseInt(id);
             row = service.delUserById(idInt);
        }

        if(row>0){
            //删除成功
            request.setAttribute("success",true);
        }else{
            //删除失败
            request.setAttribute("success",false);
        }
        request.getRequestDispatcher("/manager/douserservelt").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
