package board;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import board.model.BoardVo;
import board.service.BoardService;
import board.service.BoardServiceInf;
import post.model.PostVo;
import post.service.PostService;
import post.service.PostServiceInf;

public class BoardServiceTest {

	private BoardServiceInf boardService;

	@Before
	public void setup() {
		// studentDao = new StudentDao();
		boardService = new BoardService();
	}

	@Test
	public void insertBoardTest() {
		// ***Given***//*
		BoardVo boardVo = new BoardVo();
		boardVo.setBoard_code(7);
		boardVo.setBoard_name("7번게시판");
		boardVo.setBoard_use("y");
		// ***When***//*
		int updateCnt = boardService.insertBoard(boardVo);
		// ***Then***//*
		assertEquals(1, updateCnt);
	}

	@Test
	public void getBoardTest() {
		/*** Given ***/
		int board_code = 1;
		BoardVo paramVo = new BoardVo();

		paramVo.setBoard_code(1);

		/*** When ***/
		BoardVo boardvo = boardService.getBoard(board_code);

		System.out.println(boardvo.getBoard_code() + "\t"
				+ boardvo.getBoard_name() + "\t" + boardvo.getBoard_use());

		/*** Then ***/
		assertEquals("자유게시판", boardvo.getBoard_name());
	}

	@Test
	public void selectAllBoardTest() {
		/*** Given ***/
		/*** When ***/
		List<BoardVo> boardList = boardService.selectAllBoard();

		for (BoardVo vo : boardList)
			System.out.println(vo.getBoard_code() + "\t" + vo.getBoard_name()
					+ "\t" + vo.getBoard_use());

		/*** Then ***/
		assertEquals(20, boardList.size());

	}

}
