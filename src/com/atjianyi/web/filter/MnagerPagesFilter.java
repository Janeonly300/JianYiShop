package com.atjianyi.web.filter;

import com.atjianyi.domain.User;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebFilter("/manager/*")
public class MnagerPagesFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest)servletRequest;
        HttpServletResponse response = (HttpServletResponse)servletResponse;
        response.setContentType("text/html;charset=utf-8");

        HttpSession session = request.getSession();
        Integer flag = (Integer) session.getAttribute("isAdminLogin");

        //获取请求的路径
        String requestURI = request.getRequestURI();
        if (requestURI.contains("admin_")) { //如果包含admin_,拦截

            if(flag !=null &&1 == flag){
                //如果是超级用户登陆状态
                filterChain.doFilter(request,response);
            }else{
                //请先登陆
             response.sendRedirect("/JianYiShop/manager/adminlogin.jsp");

            }
        }else{ //如果不是,放行
            filterChain.doFilter(servletRequest, servletResponse);
        }
    }

    @Override
    public void destroy() {

    }
}
