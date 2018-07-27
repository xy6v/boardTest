package post.web;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.jasper.tagplugins.jstl.core.Out;

import board.model.BoardVo;
import board.service.BoardService;
import board.service.BoardServiceInf;
import post.model.PostVo;
import post.service.PostService;
import post.service.PostServiceInf;

@WebServlet("/postList")
public class PostServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// 비교하기 해서 1번일 경우자유게시판, 2번일 경우 qnA 정보로 맵핑하기

		String pageStr = request.getParameter("page");
		String pageSizeStr = request.getParameter("pageSize");
		// 게시판에 맞는 게시글 뜨게

		/*BoardServiceInf boardService = new BoardService();
		BoardVo boardVo = boardService.getBoard(board_code);
		*/
		int page = pageStr == null ? 1 : Integer.parseInt(pageStr);
		int pageSize = pageSizeStr == null ? 10 : Integer.parseInt(pageSizeStr);
		System.out.println("포스트서불릿 시발"+request.getParameter("board_code"));
		int board_code = Integer.parseInt(request.getParameter("board_code"));
		String std_id = request.getParameter("std_id");
		Map<String, Integer> paramMap = new HashMap<String, Integer>();
		paramMap.put("page", page);
		paramMap.put("pageSize", pageSize);
		paramMap.put("board_code",board_code);
		// 학생 페이지 리스트, 전체 건수 조회

		PostServiceInf postservice = new PostService();
		BoardServiceInf boardService = new BoardService();
		Map<String, Object> resultMap = postservice.getPostPageList(paramMap);

		// 게시글 페이지 리스트
		List<PostVo> pageList = (List<PostVo>) resultMap.get("pageList");
		HttpSession session = request.getSession();
		session.setAttribute("pageList", pageList);
	/*	request.setAttribute("postList", postList);*/
		System.out.println(pageList);
		/*if(board_code==BoardVo.getBoard_code()){
			request.setAttribute("postList", postList);
		}
*/

		String pageNavi = (String) resultMap.get("pageNavi");
		request.setAttribute("pageNavi", pageNavi);
		request.setAttribute("board_code", board_code);
		request.setAttribute("std_id", std_id);

		request.getRequestDispatcher("/post/postList.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		/*String post_code = request.getParameter("post_code");*/
	}

}
