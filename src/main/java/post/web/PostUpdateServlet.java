package post.web;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import post.model.PostVo;
import post.service.PostService;
import post.service.PostServiceInf;


/**
 * Servlet implementation class PostUpdateServlet
 */
@WebServlet("/postUpdate")
@MultipartConfig(maxFileSize = 1024 * 1000 * 3, maxRequestSize = 1024 * 1000 * 15)
public class PostUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int post_code = Integer.parseInt(request.getParameter("post_code"));

		// 게시글 조회
		PostServiceInf postService = new PostService();
		PostVo postVo = postService.getPost(post_code);

		// request객체에 정보 설정
		request.setAttribute("postVo", postVo);
		// /student/studentUpdate.jsp로 위임
		request.getRequestDispatcher("/post/postUpdate.jsp").forward(
				request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		// 파라미터 확인
		int post_code = Integer.parseInt(request.getParameter("post_code"));
		System.out.println(post_code);
		String post_name = request.getParameter("post_name");
		String post_content= request.getParameter("post_content");

		// 정보 조회 (service)
		PostServiceInf postService = new PostService();
		PostVo postVo = postService.getPost(post_code);

		// 파라미터로 받은 값을 vo에 설정
		postVo.setPost_name(post_name);
		postVo.setPost_content(post_content);
	
		postService.postUpdate(postVo);
		//redirect:/student/studentDetail.jsp?id="+id 로  주소창이다른것으로 바뀌기 때문에 깔끔해서!
		//조회화면으로 이동
		response.sendRedirect("/postDetail?post_code="+post_code);
	}

}
