package comments.dao;

import java.util.List;

import mybatis.SqlMapSessionFactory;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import post.model.PostVo;
import comments.model.CommentsVo;

public class CommentsDao implements CommentsDaoInf {
	private SqlSessionFactory sqlMapSessionFactory = SqlMapSessionFactory
			.getSqlMapSessionFactory();

	@Override
	public int insertComments(CommentsVo commentsVo) {
		SqlSession session = sqlMapSessionFactory.openSession();
		int insertCnt = session.insert("comments.insertComments", commentsVo);
		session.commit();
		session.close();
		return insertCnt;
	}

	@Override
	public int updateComments(CommentsVo commentsVo) {
		SqlSession session = sqlMapSessionFactory.openSession();
		int updateCnt = session.update("comments.updateComments", commentsVo);
		session.commit();
		session.close();
		return updateCnt;
	}

	@Override
	public int deleteComments(int comments_code) {
		SqlSession session = sqlMapSessionFactory.openSession();
		int deleteCnt = session.update("comments.deleteComments", comments_code);
		session.commit();
		session.close();
		return deleteCnt;
	}

	@Override
	public List<CommentsVo> getComments(int post_code) {
		SqlSession session = sqlMapSessionFactory.openSession();
		List<CommentsVo> commentsList = session.selectList("comments.getComments", post_code);
		session.close();
		return commentsList;
	}
	
	@Override
	public CommentsVo getCommentsOne(int comments_code) {
		SqlSession session = sqlMapSessionFactory.openSession();
		CommentsVo commentsvo = session.selectOne("comments.getCommentsOne",comments_code);
		session.close();
		return commentsvo;
	}

}
