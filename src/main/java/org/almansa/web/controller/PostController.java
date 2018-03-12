package org.almansa.web.controller;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpSession;

import org.almansa.app.core.post.Post;
import org.almansa.app.service.dto.LoginUserSessionModel;
import org.almansa.app.service.postService.PostService;
import org.almansa.web.controller.dto.PostWriteParameterModel;
import org.almansa.web.controller.validation.PostWiterParameterModelValidator;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/post")
public class PostController implements InitializingBean {

    private PostService postService;
    private PostWiterParameterModelValidator postWiterParameterModelValidator;
    
    @Autowired
    public PostController(PostService postService, PostWiterParameterModelValidator postWiterParameterModelValidator) {
        super();
        this.postService = postService;
        this.postWiterParameterModelValidator = postWiterParameterModelValidator;
    }

    @RequestMapping(value = "/write", method = RequestMethod.POST)
    public String write(
            @ModelAttribute PostWriteParameterModel postWriteModel, 
            BindingResult bindingResult,
            RedirectAttributes redirectAttribute, HttpSession session) {
        
        postWiterParameterModelValidator.validate(postWriteModel, bindingResult); // �뼐媛� �샇異쒕릺�뼱�빞 �뙆�씪誘명꽣�쓽 bindingResult�쓽 �궡�슜�씠 梨꾩썙吏꾨떎. 
        
        if(bindingResult.hasErrors()) {
            redirectAttribute.addFlashAttribute("msg", bindingResult.getAllErrors());
            return "redirect:write";
        }
        
        LoginUserSessionModel loginModel = (LoginUserSessionModel) session.getAttribute("loginuser");
        
        postService.writeNewPost(
                loginModel.getId(), 
                postWriteModel.getBoardId(), 
                postWriteModel.getName(),
                postWriteModel.getContents());
        
        redirectAttribute.addFlashAttribute("msg", "SUCCESS");
        return "redirect:list";           
    }

    @RequestMapping(value = "/write", method = RequestMethod.GET)
    public String write() {
        return "writeform";
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public ModelAndView list() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("postlist");
        mv.addObject("list", postService.getAll());

        return mv;
    }

    @RequestMapping(value = "/detail/{id}", method = RequestMethod.GET)
    public ModelAndView detail(@PathVariable long id) {
        Post post = postService.getById(id);

        ModelAndView mv = new ModelAndView();

        if (post != null) {
            mv.setViewName("postdetail");
            mv.addObject("post", post);
        } else {
            mv.setViewName("postnotfound");
        }

        return mv;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println(this.getClass().getName() + " all of roperties setted");
    }
    
    @PostConstruct
    public void initialize() {
        System.out.println(this.getClass().getName() + " initialized");
    }
}
