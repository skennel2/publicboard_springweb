package org.almansa.web.controller;

import java.util.List;
import java.util.Objects;

import javax.servlet.http.HttpSession;

import org.almansa.app.core.service.comment.CommentService;
import org.almansa.app.core.service.dto.LoginMemberSessionModel;
import org.almansa.web.controller.dto.CommentDTOAssembler;
import org.almansa.web.controller.dto.CommentResponseDTO;
import org.almansa.web.controller.dto.CommentWriteRequestDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

	private CommentDTOAssembler commentDTOAssembler;

	@Autowired
	public CommentRestController(CommentService commentService, CommentDTOAssembler commentDTOAssembler) {
		super();
		this.commentService = commentService;
		this.commentDTOAssembler = commentDTOAssembler;
	}

	@GetMapping("/bypost/{postId}")
	public ResponseEntity<List<CommentResponseDTO>> getCommentByPostId(@PathVariable Long postId) {
		List<CommentResponseDTO> results = commentDTOAssembler.assembleDto(commentService.getPostsComments(postId));

		return new ResponseEntity<List<CommentResponseDTO>>(results, HttpStatus.OK);
	}

	@PostMapping("/write")
	public ResponseEntity<Void> write(@RequestBody CommentWriteRequestDTO commentWriteRequest, HttpSession session) {
		LoginMemberSessionModel loginModel = (LoginMemberSessionModel) session.getAttribute("loginuser");
		
		if(Objects.isNull(loginModel)) {		
			return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
		}
		
		commentService.writeComment(commentWriteRequest.getPostId(), loginModel.getId(), commentWriteRequest.getContents());
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
