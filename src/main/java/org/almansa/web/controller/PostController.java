package org.almansa.web.controller;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpSession;

import org.almansa.app.core.entity.comment.Comment;
import org.almansa.app.core.entity.post.Post;
import org.almansa.app.core.service.comment.CommentService;
import org.almansa.app.core.service.dto.LoginMemberSessionModel;
import org.almansa.app.core.service.post.PostService;
import org.almansa.web.controller.dto.PostWriteRequestDTO;
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

@Controller
@RequestMapping("/post")
public class PostController implements InitializingBean {

    private PostService postService;
    private PostWiterParameterModelValidator postWiterParameterModelValidator;
    private CommentService commentService;

    @Autowired
    public PostController(PostService postService, PostWiterParameterModelValidator postWiterParameterModelValidator,
            CommentService commentService) {
        super();
        this.postService = postService;
        this.postWiterParameterModelValidator = postWiterParameterModelValidator;
        this.commentService = commentService;
    }

    @RequestMapping(value = "/write", method = RequestMethod.POST)
    public String write(
            @ModelAttribute PostWriteRequestDTO postWriteModel, 
            BindingResult bindingResult,
            HttpSession session) {
        
        postWiterParameterModelValidator.validate(postWriteModel, bindingResult); 
        
        if(bindingResult.hasErrors()) {
            return "redirect:/post/write";
        }
        
        LoginMemberSessionModel loginModel = (LoginMemberSessionModel) session.getAttribute("loginuser");
        
        postService.writeNewPost(
                loginModel.getId(), 
                postWriteModel.getBoardId(), 
                postWriteModel.getName(),
                postWriteModel.getContents());
                 
        return "redirect:/post/list";          
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
    public ModelAndView detail(@PathVariable long id, HttpSession session) {
        LoginMemberSessionModel loginModel = (LoginMemberSessionModel) session.getAttribute("loginuser");                
                
        Post post = null;
        
        if(loginModel != null) {
            post = postService.getPostByUserClick(loginModel.getId(), id);
        }else {
            post = postService.getById(id);
        }
        
        List<Comment> comments = commentService.getPostsComments(id);
        
        ModelAndView mv = new ModelAndView();

        if (post != null) {
            mv.setViewName("postdetail");
            mv.addObject("post", post);
            mv.addObject("comments", comments);
        } else {
            mv.setViewName("postnotfound");
        }

        return mv;
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET) // TODO GET -> POST
    public String delete(@PathVariable long id, HttpSession session) {
        
        LoginMemberSessionModel loginUser = (LoginMemberSessionModel) session.getAttribute("loginuser");
        
        if(loginUser != null) {
            postService.deletePost(loginUser.getId(), id);
        }
        
        return "redirect:/post/list";
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
