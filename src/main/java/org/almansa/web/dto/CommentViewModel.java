package org.almansa.web.dto;

import java.util.Date;

import org.almansa.app.core.TextContentsContainable;

public class CommentViewModel implements TextContentsContainable {
	private Long commentId;
	private Long writerMemberId;
	private String writerMemberName;
	private String contents;
	private Date writeDate;

	public Long getCommentId() {
		return commentId;
	}

	public void setCommentId(Long commentId) {
		this.commentId = commentId;
	}

	public Long getWriterMemberId() {
		return writerMemberId;
	}

	public void setWriterMemberId(Long writerMemberId) {
		this.writerMemberId = writerMemberId;
	}

	public Date getWriteDate() {
		return writeDate;
	}

	public String getWriterMemberName() {
		return writerMemberName;
	}

	public void setWriterMemberName(String writerMemberName) {
		this.writerMemberName = writerMemberName;
	}

	public void setWriteDate(Date writeDate) {
		this.writeDate = writeDate;
	}

	public void setContents(String contents) {
		this.contents = contents;
	}

	@Override
	public String getContents() {
		return contents;
	}
}
