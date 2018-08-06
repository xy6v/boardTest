package upload.service;

import java.util.List;

import upload.model.UploadVo;

public interface UploadServiceInf {
	/**
	* Method : getUploadPost
	* 최초작성일 : 2018. 7. 23.
	* 작성자 : PC17
	* 변경이력 :
	* @param article_no
	* @return
	* Method 설명 : 해당 게시글의 첨부파일 조회
	*/
	List<UploadVo> getUploadPost(int post_code);
	
	
	/**
	* Method : deleteUpload
	* 최초작성일 : 2018. 7. 23.
	* 작성자 : PC17
	* 변경이력 :
	* @param article_no
	* @return
	* Method 설명 : 첨부파일 삭제
	*/
	int deleteUpload(int post_code);
	
	
	/**
	* Method : getUpload
	* 최초작성일 : 2018. 7. 24.
	* 작성자 : PC17
	* 변경이력 :
	* @param attach_no
	* @return
	* Method 설명 : 해당 첨부파일 조회
	*/
	UploadVo getUpload(int upload_code);
	
	
	int insertUpload(UploadVo uploadVo);
}
