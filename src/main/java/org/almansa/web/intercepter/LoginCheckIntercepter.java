package org.almansa.web.intercepter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

/**
 * 어떠한 요청에 대해 인터셉트할지는 xml에 정의한다. 
 * @author skennel
 *
 */
public class LoginCheckIntercepter extends HandlerInterceptorAdapter{

    
    /**
     * 클라이언트의 요청을 컨트롤러에 전달하기 전에 호출.
     * false를 리턴할 경우 contoller에 요청을 전달하지 않고 요청 종료 
     * 이 처리가 필요한 요청은 servelt-context에 정의되어있다.
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session = request.getSession(false);
    
        if(session == null || session.getAttribute("loginuser") == null) {
            response.sendRedirect(request.getContextPath() + "/member/login");
            return false;
        }
    
        return true;
    }
    
    /**
     * 컨트롤러 로직 실행후 호출됨
     * 컨트롤러 실행도중 처리되지 않은 Exception 발생시 실행되지 않음 
     * request로 넘어온 데이터 가공시 많이 쓰인다. 
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
            ModelAndView modelAndView) throws Exception {
        super.postHandle(request, response, handler, modelAndView);
    }
    
    /**
     * 컨트롤러 로직 실행된 후 호출됨
     * 컨트롤러 실행도중이나 view 페이지 실행도중 Exception 발생 해도 실행된다. 
     * 공통 Exception 처리 로직에 많이 쓰인다. 
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
            throws Exception {
        super.afterCompletion(request, response, handler, ex);
    }
}
