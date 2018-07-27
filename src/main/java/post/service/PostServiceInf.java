package post.service;

import java.util.List;
import java.util.Map;

import board.model.BoardVo;
import post.model.PostVo;
import student.model.StudentVo;

public interface PostServiceInf {
	/**
	 * Method : getPostPageList
	 * 최초작성일 : 2018. 7. 20.
	 * 작성자 : pc22
	 * 변경이력 :
	 * @param map
	 * @return
	 * Method 설명 :
	 */
	Map<String, Object> getPostPageList(Map<String,Integer>map);
	/**
	 * Method : getPost
	 * 최초작성일 : 2018. 7. 20.
	 * 작성자 : pc22
	 * 변경이력 :
	 * @param board_code
	 * @return
	 * Method 설명 :
	 */
    PostVo getPost(int post_code);
    
    int postUpdate(PostVo postVo);
    int postDelete(int post_code);
    int postNew(PostVo postVo);
    
    int postRp(PostVo postVo);
    List<PostVo> postSelect() ;
}
