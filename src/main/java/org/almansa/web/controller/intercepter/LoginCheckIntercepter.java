package org.almansa.web.controller.intercepter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class LoginCheckIntercepter extends HandlerInterceptorAdapter{

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session = request.getSession(false);
    
        if(session == null || session.getAttribute("loginuser") == null) {
            response.sendRedirect(request.getContextPath() + "/member/login");
            return false;
        }
    
        return true;
    }   
}
