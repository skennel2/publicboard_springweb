package org.almansa.web.controller;

import javax.servlet.http.HttpSession;

import org.almansa.app.core.service.dto.LoginMemberSessionModel;
import org.almansa.app.core.service.member.MemberService;
import org.almansa.web.dto.LoginRequestModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/member")
public class MemberController {

	private MemberService memberService;

	@Autowired
	public MemberController(MemberService memberService) {
		super();
		this.memberService = memberService;
	}

	@RequestMapping(value = "/join", method = RequestMethod.GET)
	public String join() {
		return "join";
	}
	
	@RequestMapping(value = "/join", method = RequestMethod.POST)
	public String join(String loginId, String password, String passwordCheck) {
		memberService.joinSimply(loginId, passwordCheck, passwordCheck);
		
		return "redirect:/post/list";
	}	

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ModelAndView login(@ModelAttribute LoginRequestModel loginParameter, HttpSession session) {
		ModelAndView view = new ModelAndView();

		try {
			LoginMemberSessionModel loginModel = memberService.loginAndGetUserSessionModel(loginParameter.getLoginId(),
					loginParameter.getPassword());

			if (loginModel.isLoginSuccess()) {
				view.setViewName("redirect:/post/list");

				session.setAttribute("loginuser", loginModel);
			} else {
				view.setViewName("login");
				view.addObject("LoginFailMessages", loginModel.getFailureMessages());
			}

		} catch (Exception ex) {
			throw ex;
		}
		return view;
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login() {
		return "login";
	}

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(HttpSession session) {
		session.invalidate();

		return "redirect:/post/list";
	}
}