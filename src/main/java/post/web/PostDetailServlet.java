package post.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import comments.model.CommentsVo;
import comments.service.CommentsService;
import comments.service.CommentsServiceInf;
import post.model.PostVo;
import post.service.PostService;
import post.service.PostServiceInf;
import upload.model.UploadVo;
import upload.service.UploadService;
import upload.service.UploadServiceInf;


/**
 * Servlet implementation class PostDetailServlet
 */
@WebServlet("/postDetail")
public class PostDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		int post_code = Integer.parseInt(request.getParameter("post_code"));
		PostServiceInf postService = new PostService();
		CommentsServiceInf commentsService = new CommentsService();
		
		List<CommentsVo> commentsList = commentsService.getComments(post_code);
		PostVo postVo = postService.getPost(post_code);
		UploadServiceInf uploadService = new UploadService();
		List<UploadVo> uploadList = uploadService.getUploadPost(post_code);
		request.setAttribute("uploadList", uploadList);
		request.setAttribute("commentsList", commentsList);
		request.setAttribute("postVo", postVo);
		
		request.getRequestDispatcher("/post/postDetail.jsp").forward(request, response);
	
		
	}

	
}
