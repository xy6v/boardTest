package comments.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import post.dao.PostDao;
import post.dao.PostDaoInf;
import post.model.PostVo;
import comments.dao.CommentsDao;
import comments.dao.CommentsDaoInf;
import comments.model.CommentsVo;

public class CommentsService implements CommentsServiceInf {

	@Override
	public int insertComments(CommentsVo commentsVo) {
		CommentsDaoInf commentsDao = new CommentsDao();
		return commentsDao.insertComments(commentsVo);
	}

	@Override
	public int updateComments(CommentsVo commentsVo) {
		CommentsDaoInf commentsDao = new CommentsDao();
		return commentsDao.updateComments(commentsVo);
	}

	@Override
	public int deleteComments(int comments_code) {
		CommentsDaoInf commentsDao = new CommentsDao();
		return commentsDao.deleteComments(comments_code);
	}

	@Override
	public List<CommentsVo> getComments(int post_code) {
		CommentsDaoInf commentsDao = new CommentsDao();
		return commentsDao.getComments(post_code);
	}
	
	@Override
	public CommentsVo getCommentsOne(int comments_code) {
		CommentsDaoInf commentsDao = new CommentsDao();
			return commentsDao.getCommentsOne(comments_code);	
		}

}
