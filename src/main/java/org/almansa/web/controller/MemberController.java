package org.almansa.web.controller;

import javax.servlet.http.HttpSession;

import org.almansa.app.service.dto.LoginUserSessionModel;
import org.almansa.app.service.memberService.MemberServiceImpl;
import org.almansa.web.controller.dto.LoginParameterModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/member")
public class MemberController {

    private MemberServiceImpl memberService;

    @Autowired
    public MemberController(MemberServiceImpl memberService) {
        super();
        this.memberService = memberService;
    }

    @RequestMapping(value="/login", method=RequestMethod.POST)
    public String login(@ModelAttribute LoginParameterModel loginParameter, HttpSession session) {
        LoginUserSessionModel sessionModel 
            = memberService.loginAndGetUserSessionModel(loginParameter.getLoginId(), loginParameter.getPassword());
        
        if(sessionModel != null){
            System.out.println(sessionModel.toString());
        }else {
            return "login";
        }
        
        return "redirect:/post/list"; 
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