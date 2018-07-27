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
		assertEquals(3, pageList.size());
	}
	@Test
	public void getPostTotCntTest(){
		/***Given***/
		
		/***When***/
		int cnt = postDao.getPostTotCnt();

		/***Then***/
		assertEquals(6, cnt);
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
		assertEquals("자유게시판", postvo.getPost_name());

		
		
		
		/*int board_code = 1;
		List<PostVo> postList = postDao.getPost(board_code);
		
		*//*** When ***//*
		for (PostVo vo1 : postList)
			System.out.println(vo1.getBoard_code() + "\t" + vo1.getPost_name());

		*//*** Then ***//*
		assertEquals(2, postList.size());*/
		
	}
	
	@Test
	public void postDeleteTest(){
		int post_code=14;
		
		PostServiceInf postService = new PostService();
		int result = postService.postDelete(post_code);
		
		assertEquals(1,result);
	}
	
	

}
