package post.model;

import java.util.Date;

public class PostVo {
	private String post_use;
	private int post_code;
	private int board_code;
	private String std_id;
	private int post_parent;
	private int post_gcode;
	private String post_name;
	private String post_content;
	private Date post_dt;
	
	public String getPost_use() {
		return post_use;
	}
	public void setPost_use(String post_use) {
		this.post_use = post_use;
	}
	public int getPost_code() {
		return post_code;
	}
	public void setPost_code(int post_code) {
		this.post_code = post_code;
	}
	public int getBoard_code() {
		return board_code;
	}
	public void setBoard_code(int board_code) {
		this.board_code = board_code;
	}
	public String getStd_id() {
		return std_id;
	}
	public void setStd_id(String std_id) {
		this.std_id = std_id;
	}
	public int getPost_parent() {
		return post_parent;
	}
	public void setPost_parent(int post_parent) {
		this.post_parent = post_parent;
	}
	public int getPost_gcode() {
		return post_gcode;
	}
	public void setPost_gcode(int post_gcode) {
		this.post_gcode = post_gcode;
	}
	public String getPost_name() {
		return post_name;
	}
	public void setPost_name(String post_name) {
		this.post_name = post_name;
	}
	public String getPost_content() {
		return post_content;
	}
	public void setPost_content(String post_content) {
		this.post_content = post_content;
	}
	public Date getPost_dt() {
		return post_dt;
	}
	public void setPost_dt(Date post_dt) {
		this.post_dt = post_dt;
	}
	@Override
	public String toString() {
		return "PostVo [post_use=" + post_use + ", post_code=" + post_code
				+ ", board_code=" + board_code + ", std_id=" + std_id
				+ ", post_parent=" + post_parent + ", post_gcode=" + post_gcode
				+ ", post_name=" + post_name + ", post_content=" + post_content
				+ ", post_dt=" + post_dt + "]";
	}
	
}
