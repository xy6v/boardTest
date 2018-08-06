package post;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import comments.dao.CommentsDao;
import comments.dao.CommentsDaoInf;
import comments.model.CommentsVo;
import board.model.BoardVo;
import post.dao.PostDao;
import post.dao.PostDaoInf;
import post.model.PostVo;
import post.service.PostService;
import post.service.PostServiceInf;

public class PostDaoTest {
	private PostDaoInf postDao;
	Logger logger = LoggerFactory.getLogger(PostDaoTest.class);
	
	@Before
	public void setup() {
		postDao = new PostDao();
	}
	
	@Test
	public void getPostPageListTest(){
		/***Given***/
		
		Map<String,Integer> map = new HashMap<String, Integer>();
		map.put("page",1);
		map.put("pageSize",10);
		map.put("board_code", 1);
		

		/***When***/
		
		List<PostVo> pageList = postDao.getPostPageList(map);
//		for(PostVo vo:pageList){
//			logger.debug(vo.toString());}
		//studentpage.get(studentDao);
		
		/*** Then ***/
		assertEquals(10, pageList.size());
	}
	@Test
	public void getPostTotCntTest(){
		/***Given***/
		
		/***When***/
		int cnt = postDao.getPostTotCnt();

		/***Then***/
		assertEquals(176, cnt);
	}
	
	@Test
	public void getPostTest() {
		/*** Given ***/
		int post_code = 1;
		PostVo paramVo = new PostVo();

		paramVo.setPost_name("자유게시판");

		/*** When ***/
		PostVo postvo = postDao.getPost(post_code);

		System.out.println("왜안되니"+postvo.getPost_name()+postvo.getPost_content());

		/*** Then ***/
		assertEquals("수정이 됬습니다!!!!!fhhh", postvo.getPost_name());

		
	}
	
	@Test
	public void postDeleteTest(){
		int post_code=188;
		
		PostDaoInf dao = new PostDao();
		PostVo vo =  new PostVo();
		vo.setPost_use("N");
		int postvo= dao.postDelete(post_code);
		assertEquals(1,postvo);
		
	}
	
	@Test
	public void postUpdateTest(){
		/***Given***/
		PostDaoInf dao = new PostDao();
		
		PostVo postVo = new PostVo();
		postVo.setPost_code(189);
		postVo.setPost_name("test");
		postVo.setPost_use("Y");
		postVo.setPost_content("gmdgmdgmdgmd");
		
		int result = dao.postUpdate(postVo);
		/***When***/
		
		/***Then***/
		assertEquals(1, result);
	}
	
	@Test
	public void getContentTest(){
		/***Given***/
		int cont_num = 1;
		CommentsDaoInf dao = new CommentsDao();
		
		/***When***/
		List<CommentsVo> content = dao.getComments(cont_num);
		
		/***Then***/
		assertEquals(1, cont_num);
	}
	
	/*@Test
	public void addCommentsTest(){
		*//***Given***//*
		
		CommentsDaoInf dao = new CommentsDao();
		
		CommentsVo comment = new CommentsVo();
		comment.setPost_code(151);
		comment.setComments_content("dldodododd");
		comment.setStd_id("brown");
		
		*//***When***//*
		int result = dao.insertComments(comment);
		*//***Then***//*
		assertEquals(1, result);
	}*/
	
	
	
	

}
