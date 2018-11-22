package org.almansa.web.dto.assembler;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.almansa.app.core.entity.comment.Comment;
import org.almansa.app.core.entity.member.Member;
import org.almansa.app.core.service.member.MemberService;
import org.almansa.web.dto.CommentViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

@Component
public class SimpleCommentViewModelAssembler implements CommentViewModelAssembler<CommentViewModel> {

	@Autowired
	private MemberService memberService;

	@Override
	public List<CommentViewModel> assembleDto(List<Comment> comments) {
	
		if(CollectionUtils.isEmpty(comments)) {
			return Collections.<CommentViewModel>emptyList();
		}
		
		Map<Long, String> memberIdAndLoginIdMap = extractWriterMemberIdAndLoginIdMap(comments);
		
		return comments.stream().map((comment)->{
			CommentViewModel dto = new CommentViewModel();
			dto.setCommentId(comment.getId());
			dto.setContents(comment.getContents());
			dto.setWriteDate(comment.getCreationDate());
			dto.setWriterMemberId(comment.getWriterId());
			dto.setWriterMemberName(memberIdAndLoginIdMap.get(comment.getWriterId()));			
			return dto;
		}).collect(Collectors.toList());
	}
	
	@Override
	public CommentViewModel assembleDto(Comment comment) {
		CommentViewModel dto = new CommentViewModel();
		dto.setCommentId(comment.getId());
		dto.setContents(comment.getContents());
		dto.setWriteDate(comment.getCreationDate());
		dto.setWriterMemberId(comment.getWriterId());
		dto.setWriterMemberName(memberService.getById(comment.getWriterId()).getLoginId());

		return dto;
	}
	
	private Map<Long, String> extractWriterMemberIdAndLoginIdMap(List<Comment> comments){
		return comments
			.stream()
			.map(Comment::getWriterId)
			.distinct()
			.map(memberService::getById)
			.collect(Collectors.toMap(Member::getId, Member::getLoginId));
	}
	
}
