package org.almansa.web.controller;

import javax.servlet.http.HttpSession;

import org.almansa.app.service.dto.LoginUserSessionModel;
import org.almansa.app.service.memberService.MemberService;
import org.almansa.web.controller.dto.LoginParameterModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/member")
public class MemberController {

    private MemberService memberService;

    @Autowired
    public MemberController(MemberService memberService) {
        super();
        this.memberService = memberService;
    }

    @RequestMapping(value="/login", method=RequestMethod.POST)
    public String login(@ModelAttribute LoginParameterModel loginParameter, HttpSession session) {
        LoginUserSessionModel sessionModel 
            = memberService.loginAndGetUserSessionModel(loginParameter.getLoginId(), loginParameter.getPassword());
        
        if(sessionModel == null){
            return "login";
        }
        
        String redirectUrl = "/post/list";
        //TODO 로그인 성공후, 이전 요청 페이지로 리다이렉트되는 처리  필요
       
        session.setAttribute("loginuser", sessionModel);        
        return "redirect:" + redirectUrl; 
    }
    
    @RequestMapping(value="/login", method=RequestMethod.GET)
    public String login() {
        return "login";
    }    
    
    @RequestMapping(value="/logout", method=RequestMethod.GET)
    public String logout(HttpSession session) {
        session.invalidate();
        
        return "redirect:/post/list"; 
    }
}