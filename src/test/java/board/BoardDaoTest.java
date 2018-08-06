package board;

import static org.junit.Assert.*;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import post.dao.PostDao;
import board.dao.BoardDao;
import board.dao.BoardDaoInf;
import board.model.BoardVo;

public class BoardDaoTest {
	private BoardDaoInf boardDao = new BoardDao();

	@Test
	public void selectAllBoardTest() {
		/*** Given ***/
		/*** When ***/
		List<BoardVo> boardList = boardDao.selectAllBoard();

		for (BoardVo vo : boardList)
			System.out.println(vo.getBoard_code() + "\t" + vo.getBoard_name() + "\t" +vo.getBoard_use());

		/*** Then ***/
		assertEquals(19, boardList.size());

	}
	@Before
	public void setup() {
		boardDao = new BoardDao();
	}
	
	@Test
	public void getBoardTest() {
		/*** Given ***/
		int board_code = 1;
		BoardVo paramVo = new BoardVo();

		paramVo.setBoard_code(1);

		/*** When ***/
		BoardVo boardvo = boardDao.getBoard(board_code);

		System.out.println(boardvo.getBoard_code()+"\t"+boardvo.getBoard_name()+"\t"+boardvo.getBoard_use());

		/*** Then ***/
		assertEquals("자유게시판", boardvo.getBoard_name());
	}


	@Test
	public void insertBoardTest(){
		//***Given***//*
		BoardVo boardVo = new BoardVo();
		boardVo.setBoard_code(5);
		boardVo.setBoard_name("5번게시물");
		boardVo.setBoard_use("y");
		//***When***//*
		int updateCnt=boardDao.insertBoard(boardVo);
		//***Then***//*
		assertEquals(1, updateCnt);		
	}

}
