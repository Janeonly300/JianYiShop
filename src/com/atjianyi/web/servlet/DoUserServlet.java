package com.atjianyi.web.servlet;

import com.atjianyi.domain.PageBean;
import com.atjianyi.domain.User;
import com.atjianyi.service.UserService;
import com.atjianyi.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/manager/douserservelt")
public class DoUserServlet extends HttpServlet {
    private static UserService service =new UserServiceImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String curPage = request.getParameter("curPage");
        String keyBord = request.getParameter("keywords");
        if(keyBord !=null){
            request.setAttribute("serach",keyBord);
        }

        int curPageInt = 0 ;
        if(curPage!=null){
            curPageInt = Integer.parseInt(curPage);
        }
        if(curPageInt<1){
            curPageInt = 1;
        }
        PageBean<User> pageBean = service.selectByLimit(curPageInt,5,keyBord);
        request.setAttribute("pageBean",pageBean);
        request.getRequestDispatcher("/manager/admin_user.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
