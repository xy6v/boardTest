package post.dao;

import java.util.List;
import java.util.Map;

import mybatis.SqlMapSessionFactory;

import org.apache.ibatis.session.SqlSessionFactory;

import post.model.PostVo;
import student.model.StudentVo;
import board.model.BoardVo;

public interface PostDaoInf {
	
	/**
	 * Method : getPostPageList
	 * 최초작성일 : 2018. 7. 19.
	 * 작성자 : pc22
	 * 변경이력 :
	 * @param map
	 * @return
	 * Method 설명 :게시글 목록
	 */
	List<PostVo> getPostPageList(Map<String,Integer>map);
	/**
	 * Method : getPostTotCnt
	 * 최초작성일 : 2018. 7. 19.
	 * 작성자 : pc22
	 * 변경이력 :
	 * @return
	 * Method 설명 :게시글 갯수
	 */
	int getPostTotCnt();
	
	/**
	 * Method : getPost
	 * 최초작성일 : 2018. 7. 19.
	 * 작성자 : pc22
	 * 변경이력 :
	 * @param id
	 * @return
	 * Method 설명 :
	 */
	PostVo getPost(int post_code);
	
	/**
	 * Method : postUpdate
	 * 최초작성일 : 2018. 7. 24.
	 * 작성자 : pc22
	 * 변경이력 :
	 * @param postVo
	 * @return
	 * Method 설명 :
	 */
	int postUpdate(PostVo postVo);
	/**
	 * Method : postNew
	 * 최초작성일 : 2018. 7. 24.
	 * 작성자 : pc22
	 * 변경이력 :
	 * @param postVo
	 * @return
	 * Method 설명 :
	 */
	
	int postNew(PostVo postVo);
	/**
	 * Method : postRp
	 * 최초작성일 : 2018. 7. 26.
	 * 작성자 : pc22
	 * 변경이력 :
	 * @param postVo
	 * @return
	 * Method 설명 :
	 */
	int postRp(PostVo postVo);
	/**
	 * Method : postDelete
	 * 최초작성일 : 2018. 7. 24.
	 * 작성자 : pc22
	 * 변경이력 :
	 * @param postVo
	 * @return
	 * Method 설명 :
	 */
	int postDelete(int post_code);
	/**
	 * Method : postSelect
	 * 최초작성일 : 2018. 7. 24.
	 * 작성자 : pc22
	 * 변경이력 :
	 * @return
	 * Method 설명 :
	 */
	List<PostVo> postSelect();
}
