package org.almansa.web.dto;

public class PostWriteRequestModel {

    private long writerId;
    private long boardId;
    private String name;
    private String contents;

    public long getWriterId() {
        return writerId;
    }

    public void setWriterId(long writerId) {
        this.writerId = writerId;
    }

    public long getBoardId() {
        return boardId;
    }

    public void setBoardId(long boardId) {
        this.boardId = boardId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContents() {
        return contents;
    }

    public void setContents(String contents) {
        this.contents = contents;
    }

    @Override
    public String toString() {
        return "PostWriteModel [writerId=" + writerId + ", boardId=" + boardId + ", name=" + name + ", contents="
                + contents + "]";
    }
}
