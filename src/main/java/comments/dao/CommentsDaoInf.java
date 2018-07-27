package comments.dao;

import java.util.List;

import comments.model.CommentsVo;


public interface CommentsDaoInf {
	/**
	 * Method : insertComments
	 * 최초작성일 : 2018. 7. 24.
	 * 작성자 : pc22
	 * 변경이력 :
	 * @param commentsVo
	 * @return
	 * Method 설명 :댓글 추가
	 */
	int insertComments(CommentsVo commentsVo);
	/**
	 * Method : updateComments
	 * 최초작성일 : 2018. 7. 24.
	 * 작성자 : pc22
	 * 변경이력 :
	 * @param commentsVo
	 * @return
	 * Method 설명 :댓글 업데이트
	 */
	int updateComments(CommentsVo commentsVo);
	/**
	 * Method : deleteComments
	 * 최초작성일 : 2018. 7. 24.
	 * 작성자 : pc22
	 * 변경이력 :
	 * @param comments_code
	 * @return
	 * Method 설명 :댓글삭제
	 */
	int deleteComments(int comments_code);
	/**
	 * Method : getComments
	 * 최초작성일 : 2018. 7. 24.
	 * 작성자 : pc22
	 * 변경이력 :
	 * @param comments_code
	 * @return
	 * Method 설명 :댓글 조회
	 */
	List<CommentsVo> getComments(int post_code);
	CommentsVo getCommentsOne(int comments_code);
	
	
}
