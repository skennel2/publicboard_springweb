package org.almansa.web.controller;

import javax.servlet.http.HttpSession;

import org.almansa.app.core.service.dto.LoginMemberSessionModel;
import org.almansa.app.core.service.member.MemberService;
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
        LoginMemberSessionModel sessionModel 
            = memberService.loginAndGetUserSessionModel(loginParameter.getLoginId(), loginParameter.getPassword());
        
        if(sessionModel == null){
            return "login";
        }
        
        String redirectUrl = "/post/list";
       
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