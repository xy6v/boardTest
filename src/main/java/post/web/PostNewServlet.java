package post.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import post.model.PostVo;
import post.service.PostService;
import post.service.PostServiceInf;
import board.model.BoardVo;
import board.service.BoardService;
import board.service.BoardServiceInf;

@WebServlet("/postNew")
@MultipartConfig(maxFileSize = 1024 * 1000 * 3, maxRequestSize = 1024 * 1000 * 15)
public class PostNewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		PostServiceInf postService = new PostService();
		int board_code = Integer.parseInt(request.getParameter("board_code"));
		int post_parent = Integer.parseInt(request.getParameter("post_parent"));
		String code =request.getParameter("post_code");
		int post_code = code==null?0:Integer.parseInt(code);
		/*String post_parent = request.getParameter("post_parent");*/
		String std_id= (String) request.getSession().getAttribute("std_id");
		String name = request.getParameter("post_name");
		String content = request.getParameter("post_content");
		
		System.out.println("이런시발2:"+post_parent);
		System.out.println("이런시발:"+post_code);
	/*	String std_id= request.getParameter("std_id");
		*/
		System.out.println(std_id);
		System.out.println(board_code);
		System.out.println(name);
		System.out.println(content);
		
		PostVo postVo = new PostVo();
		postVo.setStd_id(std_id);
		postVo.setPost_name(name);
		postVo.setPost_content(content);
		postVo.setBoard_code(board_code);
		postVo.setPost_code(post_code);
		postVo.setPost_parent(post_parent);
		
		

		/* boardVo.setBoard_code(code); */
		// ***When***//*
		
		int insertCnt = postService.postNew(postVo);
		System.out.println(insertCnt);

		/*
		 * HttpSession session = request.getSession();
		 * session.setAttribute("postList", postList);
		 */
		/*
		 * request.getRequestDispatcher("/post/postNew.jsp").forward(request,
		 * response);
		 */

		response.sendRedirect("/postList?board_code=" + board_code);

	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		
		
		
		
	}

}
