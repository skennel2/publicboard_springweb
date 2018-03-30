package org.almansa.web.controller;

import javax.servlet.http.HttpSession;

import org.almansa.app.core.service.comment.CommentService;
import org.almansa.app.core.service.dto.LoginMemberSessionModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/comment")
public class CommentController {
    
    private CommentService commentService;
    
    @Autowired
    public CommentController(CommentService commentService) {
        super();
        this.commentService = commentService;
    }

    @RequestMapping( value = "/write", method= RequestMethod.POST)
    public void write(long postId, String contents, HttpSession session) {
        LoginMemberSessionModel loginModel = (LoginMemberSessionModel) session.getAttribute("loginuser");             
        long memberId = loginModel.getId();
        
        commentService.writeComment(postId, memberId, contents);
    }
}
