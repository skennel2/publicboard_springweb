package org.almansa.web.controller;

import org.almansa.app.service.postService.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/post")
public class PostController {
	
	@Autowired
	private PostService postService;
	
	@RequestMapping(value="/write", method = RequestMethod.POST)
	public String write(@ModelAttribute PostWriteParameterModel postWriteModel) {
		System.out.println(postWriteModel.toString());
		
		postService.writeNewPost(postWriteModel.getWriterId(), postWriteModel.getBoardId(), postWriteModel.getName(), postWriteModel.getContents());
				
		return "redirect:list";
	}
	
	@RequestMapping(value="/write", method = RequestMethod.GET)
	public String write() {
		return "writeform";
	}
	
	@RequestMapping(value="/list", method = RequestMethod.GET)
	public ModelAndView list() {
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("postlist");
		mv.addObject("list", postService.getWritersPosts(1));
		
		return mv;
	}	
}
