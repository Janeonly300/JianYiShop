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
import java.io.PrintWriter;

/**
 * 用户登陆
 */
@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
    private UserService service = new UserServiceImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //解决POST乱码问题，获取前端参数
        response.setContentType("text/html;charset=utf-8");
        String username = request.getParameter("username");
        String pwd = request.getParameter("pwd");

        if(username!=null && username.length()>0 && pwd!=null && pwd.length()>0){
            User user = service.loginByUserName(username,pwd);
            if(user!=null){
                //登陆成功 将用户信息存入用户
                HttpSession session = request.getSession();
                session.setAttribute("user",user);
                session.setAttribute("isLogin",1); //标记为登录状态

                if(user.getUserStatus() == 2){
                    session.setAttribute("isAdminLogin",1);
                }
                response.sendRedirect("index.jsp");
            }else{
                //登陆失败
                request.setAttribute("error","登陆失败，账号或者密码错误");
                request.getRequestDispatcher("/login.jsp").forward(request,response);
            }
        }else{
            PrintWriter writer = response.getWriter();
            request.setAttribute("error","登陆失败，用户名或者密码不能为空");
            request.getRequestDispatcher("/login.jsp").forward(request,response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
