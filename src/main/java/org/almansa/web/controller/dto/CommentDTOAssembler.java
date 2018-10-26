package org.almansa.web.controller.dto;

import java.util.List;

import org.almansa.app.core.entity.comment.Comment;
import org.springframework.beans.TypeConverter;

public interface CommentDTOAssembler {

	List<CommentResponseDTO> assembleDto(List<Comment> comments);

	CommentResponseDTO assembleDto(Comment comment);

}