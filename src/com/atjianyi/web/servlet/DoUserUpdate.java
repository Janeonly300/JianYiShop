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

/**
 * @author 简一
 * @className DoUserUpdate
 * @Date 2020/11/10 8:43
 **/
@WebServlet("/manager/douserUpdate")
public class DoUserUpdate extends HttpServlet {
    private UserService service = new UserServiceImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        String username = req.getParameter("userName");
        String name = req.getParameter("name");
        String pwd = req.getParameter("password");
        String sex = req.getParameter("sex");
        String email = req.getParameter("email");
        String birth = req.getParameter("birth");
        String address = req.getParameter("address");
        String pone = req.getParameter("phone");

        int intId = 0;
        if(id !=null){
            intId = Integer.parseInt(id);
        }
        User updateUser = new User(intId,username,name,pwd,sex,birth,null,email,pone,address,1);

        int row = service.updateUser(updateUser);
        if(row>0){
            //修改成功
            req.setAttribute("success",true);
            req.getRequestDispatcher("/manager/douserservelt").forward(req,resp);
        }else{
            //修改失败;
            req.setAttribute("error",true);
            resp.sendRedirect("/JianYiShop/doUserReturn");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req,resp);
    }
}
