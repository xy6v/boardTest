package comments.model;

public class CommentsVo {
	private int comments_code;
	private int post_code;
	private String std_id;
	private String comments_dt;
	private String comments_content;
	public int getComments_code() {
		return comments_code;
	}
	public void setComments_code(int comments_code) {
		this.comments_code = comments_code;
	}
	public int getPost_code() {
		return post_code;
	}
	public void setPost_code(int post_code) {
		this.post_code = post_code;
	}
	public String getStd_id() {
		return std_id;
	}
	public void setStd_id(String std_id) {
		this.std_id = std_id;
	}
	public String getComments_dt() {
		return comments_dt;
	}
	public void setComments_dt(String comments_dt) {
		this.comments_dt = comments_dt;
	}
	public String getComments_content() {
		return comments_content;
	}
	public void setComments_content(String comments_content) {
		this.comments_content = comments_content;
	}
	@Override
	public String toString() {
		return "CommentsVo [comments_code=" + comments_code + ", post_code="
				+ post_code + ", std_id=" + std_id + ", comments_dt="
				+ comments_dt + ", comments_content=" + comments_content + "]";
	}
	
	
}
