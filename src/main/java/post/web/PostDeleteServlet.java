package post.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import post.model.PostVo;
import post.service.PostService;
import post.service.PostServiceInf;
import upload.model.UploadVo;
import upload.service.UploadService;
import upload.service.UploadServiceInf;

@WebServlet("/postDelete")
public class PostDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int post_code = Integer.parseInt(request.getParameter("post_code"));
		// 게시글 조회
		PostServiceInf postService = new PostService();
		int postDelete = postService.postDelete(post_code);
		
	

		// request객체에 정보 설정
		request.setAttribute("postDelete", postDelete);
		// /student/studentUpdate.jsp로 위임
		request.getRequestDispatcher("/postList").forward(
				request, response);

	}

}
