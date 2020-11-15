package com.atjianyi.web.servlet;

import com.atjianyi.domain.User;
import com.atjianyi.service.UserService;
import com.atjianyi.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/manager/admin_douseradd")
public class DoUserAdd extends HttpServlet {
    private static UserService service =new  UserServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("userName");
        String name = request.getParameter("name");
        String pwd = request.getParameter("password");
        String sex = request.getParameter("sex");
        String email = request.getParameter("email");
        String birth = request.getParameter("birth");
        String address = request.getParameter("address");
        String pone = request.getParameter("phone");

        //创建用户实体
        User user = new User(username,name,pwd,sex,birth,null,email,pone,address,1);
        //添加到数据库
        boolean b = service.insertUser(user);
        if(b){
            //如果成功 转发到admin_user
            request.getRequestDispatcher("douserservelt").forward(request,response);
        }else{
            //如果加入失败
            response.sendRedirect("/JianYiShop/manager/admin_userAdd.jsp");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
