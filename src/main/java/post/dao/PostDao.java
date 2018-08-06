package post.dao;

import java.util.List;
import java.util.Map;

import mybatis.SqlMapSessionFactory;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import post.model.PostVo;
import board.model.BoardVo;

public class PostDao implements PostDaoInf {
	
	private SqlSessionFactory sqlMapSessionFactory =
			SqlMapSessionFactory.getSqlMapSessionFactory();
	
	/**
	 * Method : getPostPageList
	 * 최초작성일 : 2018. 7. 19.
	 * 작성자 : pc22
	 * 변경이력 :
	 * @param map
	 * @return
	 * Method 설명 :게시글 목록
	 */
	@Override
	public List<PostVo> getPostPageList(Map<String, Integer> map){
		SqlSession session=sqlMapSessionFactory.openSession();
		List<PostVo> postList=session.selectList("post.getPostPageList",map);
		session.close();
		return postList;
	}
	/**
	 * Method : getPostTotCnt
	 * 최초작성일 : 2018. 7. 19.
	 * 작성자 : pc22
	 * 변경이력 :
	 * @return
	 * Method 설명 :게시글 총수 
	 */
	@Override 
	public int getPostTotCnt(){
		SqlSession session=sqlMapSessionFactory.openSession();
		int cnt = session.selectOne("post.getPostTotCnt");
		session.close();
		return cnt;
	}
	/**
	 * Method : getPost
	 * 최초작성일 : 2018. 7. 20.
	 * 작성자 : pc22
	 * 변경이력 :
	 * @param board_code
	 * @return
	 * Method 설명 : 게시판 분류
	 */
	@Override
	public PostVo getPost(int post_code) {
		SqlSession session = sqlMapSessionFactory.openSession();
		PostVo postvo = session.selectOne("post.getPost",post_code);
		session.close();
		return postvo;
	}
	
	@Override
	public int postUpdate(PostVo postVo) {
		SqlSession session=sqlMapSessionFactory.openSession();
		int updateCnt =session.update("post.postUpdate",postVo);
		session.commit();
		session.close();
		return updateCnt;
	}
	
	@Override
	public int postNew(PostVo postVo) {
		SqlSession session=sqlMapSessionFactory.openSession();
		int insertCnt =session.insert("post.postNew",postVo);
		session.commit();
		session.close();
		return insertCnt;
	}
	
	
	
	@Override
	public int postRp(PostVo postVo) {
		SqlSession session=sqlMapSessionFactory.openSession();
		int insertCnt =session.insert("post.postRp",postVo);
		session.commit();
		session.close();
		return insertCnt;
	}
	
	@Override
	public List<PostVo> postSelect() {
		SqlSession session = sqlMapSessionFactory.openSession();
		List<PostVo> postList = session.selectList("post.postSelect");
		System.out.println(postList);
		session.close();
		return postList;
	}
	@Override
	public int postDelete(int post_code) {
		SqlSession session=sqlMapSessionFactory.openSession();
		int deleteCnt =session.update("post.postDelete",post_code);
		session.commit();
		session.close();
		return deleteCnt;
	}
	
}
