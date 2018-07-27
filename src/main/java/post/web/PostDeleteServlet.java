package post.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import post.model.PostVo;
import post.service.PostService;
import post.service.PostServiceInf;

@WebServlet("/postDelete")
public class PostDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("게시글코드"+request.getParameter("post_code"));
		int board_code =Integer.parseInt(request.getParameter("board_code"));
		int post_code = Integer.parseInt(request.getParameter("post_code"));
		
		PostServiceInf postService = new PostService();
	
		postService.postDelete(post_code);


		response.sendRedirect("/postList?board_code="+board_code);

		

	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
