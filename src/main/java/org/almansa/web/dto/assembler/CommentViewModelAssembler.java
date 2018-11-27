package org.almansa.web.dto.assembler;

import java.util.List;

import org.almansa.app.core.entity.comment.Comment;

public interface CommentViewModelAssembler<T> {

	List<T> assembleDto(List<Comment> comments);

	T assembleDto(Comment comment);

}