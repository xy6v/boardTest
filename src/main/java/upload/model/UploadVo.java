package upload.model;

public class UploadVo {
	private int 	upload_code;				//첨부파일번호
	private String 	upload;		//첨부업로드파일명
	private String uploadpath;			//첨부파일경로
	private String 	uploadname;			//첨부파일명
	private int 	post_code;	
	//해당게시글번호
	public int getUpload_code() {
		return upload_code;
	}
	public void setUpload_code(int upload_code) {
		this.upload_code = upload_code;
	}
	public String getUpload() {
		return upload;
	}
	public void setUpload(String upload) {
		this.upload = upload;
	}
	public String getUploadpath() {
		return uploadpath;
	}
	public void setUploadpath(String uploadpath) {
		this.uploadpath = uploadpath;
	}
	public String getUploadname() {
		return uploadname;
	}
	public void setUploadname(String uploadname) {
		this.uploadname = uploadname;
	}
	public int getPost_code() {
		return post_code;
	}
	public void setPost_code(int post_code) {
		this.post_code = post_code;
	}
	
	@Override
	public String toString() {
		return "UploadVo [upload_code=" + upload_code + ", upload=" + upload
				+ ", uploadpath=" + uploadpath + ", uploadname=" + uploadname
				+ ", post_code=" + post_code + "]";
	}

}
