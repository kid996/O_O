package O_O.model.timeline;

public class PostComment {
    private String mCommentId;
    private String mContentId;
    private String mComment;
    private String mCreateTime;
    private String mAuthorId;

    public String getContentId() {
        return mContentId;
    }
    public void setContentId(String mContentId) {
        this.mContentId = mContentId;
    }
    public String getCommentId() {
        return mCommentId;
    }
    public void setCommentId(String mCommentId) {
        this.mCommentId = mCommentId;
    }
    public String getComment() {
        return mComment;
    }
    public void setComment(String mComment) {
        this.mComment = mComment;
    }
    public String getCreateTime() {
        return mCreateTime;
    }
    public void setCreateTime(String mCreateTime) {
        this.mCreateTime = mCreateTime;
    }
    public String getAuthorId() {
        return mAuthorId;
    }
    public void setAuthorId(String mAuthorId) {
        this.mAuthorId = mAuthorId;
    }
}
