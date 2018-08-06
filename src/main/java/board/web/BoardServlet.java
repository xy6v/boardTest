package board.web;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import board.model.BoardVo;
import board.service.BoardService;
import board.service.BoardServiceInf;


@WebServlet("/boardList")
public class BoardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	// private static int studentid;
	// 학생 정보 수정 화면
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		BoardServiceInf boardService = new BoardService();
		String name = request.getParameter("board_name");
		System.out.println(name);
		String use =  request.getParameter("board_use");
	/*	int code =Integer.parseInt(request.getParameter("board_code"));*/
		
		BoardVo boardVo = new BoardVo();
		boardVo.setBoard_name(name);
		boardVo.setBoard_use(use);
	/*	boardVo.setBoard_code(code);*/
		//***When***//*
		int insertCnt=boardService.insertBoard(boardVo);
		System.out.println(insertCnt);
		
		List<BoardVo> boardList = boardService.selectAllBoard();
	
		HttpSession session = request.getSession();
		session.setAttribute("boardList", boardList);
		request.getRequestDispatcher("/board/board.jsp").forward(request, response);
	}	

			
}
