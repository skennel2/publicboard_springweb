package org.almansa.web.controller;

import java.util.List;

import org.almansa.app.core.entity.comment.Comment;
import org.almansa.app.core.service.comment.CommentService;
import org.almansa.web.controller.dto.CommentWriteRequestDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest/comment")
public class CommentRestController {
    private CommentService commentService;
    
    @Autowired
    public CommentRestController(CommentService commentService) {
        super();
        this.commentService = commentService;
    }
    
    @GetMapping("/bypost/{postId}")
    public List<Comment> getCommentByPostId(@PathVariable Long postId){
    	return commentService.getPostsComments(postId);
    }
    
    @PostMapping
    public void write(@RequestBody CommentWriteRequestDTO commentWriteRequest){
    	commentService.writeComment(commentWriteRequest.getPostId(), commentWriteRequest.getMemberId(), commentWriteRequest.getContents());
    } 
}
