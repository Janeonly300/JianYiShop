package com.atjianyi.web.filter;



/**
 * @author 简一
 * @className UserLoginFilter
 * @Date 2020/11/14 23:06
 **/

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

/**
 *
 */
@WebFilter("/mygxin.jsp")
public class UserLoginFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletResponse response = (HttpServletResponse)servletResponse;
        HttpServletRequest request = (HttpServletRequest)servletRequest;
        response.setContentType("text/html;charset=utf-8"); //解决乱码问题

        HttpSession session = request.getSession();
        if(session.getAttribute("user") == null){
            PrintWriter writer = response.getWriter();
            writer.write("<script>alert('验证不通过'); location='/JianYiShop/login.jsp'</script>");
        }else{
            filterChain.doFilter(request,response);
        }
    }

    @Override
    public void destroy() {

    }
}
