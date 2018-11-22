package org.almansa.web.dto;

import java.util.Date;

public class CommentWriteRequestModel {
	private Long postId;
	private Long writerMemberId;
	private String contents;
	private Date writeDate;

	public Long getPostId() {
		return postId;
	}

	public void setPostId(Long postId) {
		this.postId = postId;
	}

	public Long getWriterMemberId() {
		return writerMemberId;
	}

	public void setWriterMemberId(Long writerMemberId) {
		this.writerMemberId = writerMemberId;
	}

	public String getContents() {
		return contents;
	}

	public void setContents(String contents) {
		this.contents = contents;
	}

	public Date getWriteDate() {
		return writeDate;
	}

	public void setWriteDate(Date writeDate) {
		this.writeDate = writeDate;
	}
}