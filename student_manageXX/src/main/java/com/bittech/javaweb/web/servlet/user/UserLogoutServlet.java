package com.bittech.javaweb.web.servlet.user;

import com.bittech.javaweb.web.servlet.ApplicationLoadServlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


@WebServlet(name = "UserLogoutServlet", urlPatterns = {"/logout"})
public class UserLogoutServlet extends ApplicationLoadServlet {
    
    @Override
    public void init() throws ServletException {
        super.init();
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        this.doPost(request, response);
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // 获取Session
        HttpSession session = request.getSession();
        session.removeAttribute(CURRENT_USER);
        // 客户端跳转
        response.sendRedirect("index.jsp");
    }
}
