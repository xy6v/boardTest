package post;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


import org.junit.Before;
import org.junit.Test;

import post.model.PostVo;
import post.service.PostService;
import post.service.PostServiceInf;

public class PostServiceTest {
	private PostServiceInf postService;
	
	@Before
	public void setup() {
		postService = new PostService();
	}
	
	@Test
	public void getPostPageListTest(){
		/***Given***/
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("page",1);
		map.put("pageSize", 10);
		map.put("board_code",1);

		/***When***/
		Map<String, Object> resultMap = postService.getPostPageList(map);
		
		//학생 페이지 리스트
		List<PostVo> pageList = (List<PostVo>) resultMap.get("pageList");
		
		
		int totCnt = (int)resultMap.get("totCnt");
		
		//System.out.println(pageList.get(4).getId()+pageList.get(4).getName());

		/***Then***/
		assertEquals(3, pageList.size()); //학생 페이지 리스트 건수에 대한 타입
		assertEquals(6, totCnt);	//학생 전체 건수에 대한 검증
		
		
	}
	@Test
	public void getPostTest() {
		
		
		int post_code = 1;
		PostVo paramVo = new PostVo();

		paramVo.setBoard_code(1);

		/*** When ***/
		PostVo postvo = postService.getPost(post_code);

		System.out.println(postvo.getPost_name());

		/*** Then ***/
		assertEquals("김마음", postvo.getPost_name());
		
	/*	*//*** Given ***//*
		int post_code = 1;
		PostVo paramVo = new PostVo();

		paramVo.setPost_code(1);

		*//*** When ***//*
		PostVo postvo = postService.getPost(post_code);

		System.out.println(postvo.getPost_name()+postvo.getPost_content());

		*//*** Then ***//*
		assertEquals("자유게시판", postvo.getPost_name());
		*//*** Given ***//*
		int board_code = 1;
		List<PostVo> postList = postService.getPost(board_code);
		
		*//*** When ***//*
		for (PostVo vo : postList)
			System.out.println(vo.getBoard_code() + "\t" + vo.getPost_name());

		*//*** Then ***//*
		assertEquals(2, postList.size());
		*/
	}
	


}
