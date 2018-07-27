package board.web;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import post.model.PostVo;
import post.service.PostService;
import post.service.PostServiceInf;
import board.model.BoardVo;
import board.service.BoardService;
import board.service.BoardServiceInf;

@WebServlet("/updateBoard")
@MultipartConfig(maxFileSize = 1024 * 1000 * 3, maxRequestSize = 1024 * 1000 * 15)
public class BoardUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	// 학생 정보 수정
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		
		int board_code = Integer.parseInt(request.getParameter("board_code"));
		String board_name = request.getParameter("board_name");
		String board_use = request.getParameter("board_use");
		
		BoardServiceInf boardService = new BoardService();
		BoardVo boardVo = boardService.getBoard(board_code);

		boardVo.setBoard_name(board_name);
		boardVo.setBoard_use(board_use);
	
		//게시판 정보 업데이트
		int updateCnt=boardService.updateBoard(boardVo);
		System.out.println(updateCnt);
		
		List<BoardVo> boardList= boardService.selectAllBoard();
		
		HttpSession session = request.getSession();
		session.setAttribute("boardList",boardList);
		
		//redirect:/student/studentDetail.jsp?id="+id 로  주소창이다른것으로 바뀌기 때문에 깔끔해서!
		//학생정보상세 조회화면으로 이동
		request.getRequestDispatcher("/board/board.jsp").forward(request, response);
			
	}
	
	
	// 게시판 수정
//		protected void doPost(HttpServletRequest request,
//				HttpServletResponse response) throws ServletException, IOException {
//			
//			request.setCharacterEncoding("UTF-8");
//
//			// 파라미터 확인
//			int board_code = Integer.parseInt(request.getParameter("board_code"));
//			String board_name = request.getParameter("board_name");
//			String board_use = request.getParameter("board_use");
//			
//			// 학생 정보 조회 (service)
//			BoardServiceInf boardService = new BoardService();
//			BoardVo boardVo = boardService.getBoard(board_code);
//
//			// 파라미터로 받은 값을 vo에 설정
//			boardVo.setBoard_code(board_code);
//			boardVo.setBoard_name(board_name);
//			boardVo.setBoard_use(board_use);
//			
//			/*if(board_use.equals("Y")){
//				
//				
//			}else if(board_use.equals("N")){
//				
//				
//			}else{
//				
//			}*/
//
//			// 신규이미지로 업데이트 하는 경우
//			
//			//학생 정보 업데이트
//			boardService.updateBoard(boardVo);
//			
//			//redirect:/student/studentDetail.jsp?id="+id 로  주소창이다른것으로 바뀌기 때문에 깔끔해서!
//			response.sendRedirect("/boardList");
//		}		

}
