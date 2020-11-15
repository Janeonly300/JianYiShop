package com.atjianyi.web.servlet;

import com.atjianyi.domain.User;
import com.atjianyi.service.UserService;
import com.atjianyi.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/manager/adminLogin")
public class AdminLogin extends HttpServlet {
    private UserService service = new UserServiceImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //验证验证码
        HttpSession session = request.getSession();
        String codeServer = (String)session.getAttribute("checkCode_Server");
        String code = request.getParameter("code");
        if(!codeServer.equals(code)){
            //验证码错误
            request.setAttribute("error", "验证码错误");//错误信息
            request.getRequestDispatcher("adminlogin.jsp").forward(request, response);
        }


        //获取用户密码
        String userName = request.getParameter("userName");
        String pwd = request.getParameter("pwd");


        if(userName!=null && !"".equals(userName) && pwd!=null && !"".equals(pwd)) { //账号密码不为空
            User user = service.loginByUserName(userName, pwd);
            if (user != null && user.getUserName().equals(userName)) {

                session.setAttribute("user", user);
                session.setAttribute("isLogin", 1);

                //登录成功
                if (user.getUserStatus() == 2) {//是管理员用户
                    session.setAttribute("isAdminLogin", 1);
                    response.sendRedirect("/JianYiShop/manager/admin_index.jsp"); //进入后台首页
                } else { //普通用户
                    response.sendRedirect("/JianYiShop/index.jsp"); //进入网站首页
                }
            } else {
                //登录失败
                request.setAttribute("error", "账号或者密码错误");//错误信息
                request.getRequestDispatcher("adminlogin.jsp").forward(request, response);
            }
        }else{//账号密码为空
            //登录失败
            request.setAttribute("error", "账号或密码不能为空");//错误信息
            request.getRequestDispatcher("adminlogin.jsp").forward(request, response);
        }
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
