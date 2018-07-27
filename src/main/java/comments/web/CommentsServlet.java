package comments.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import post.model.PostVo;
import post.service.PostService;
import post.service.PostServiceInf;
import comments.model.CommentsVo;
import comments.service.CommentsService;
import comments.service.CommentsServiceInf;

@WebServlet("/commentsList")
@MultipartConfig(maxFileSize = 1024 * 1000 * 3, maxRequestSize = 1024 * 1000 * 15)
public class CommentsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// 댓글 입력하는 곳
		request.setCharacterEncoding("UTF-8");

		CommentsServiceInf commentsService = new CommentsService();

		PostServiceInf postService = new PostService();

		int post_code = Integer.parseInt(request.getParameter("post_code"));

		String comments_content = request.getParameter("comments_content");

		CommentsVo commentsVo = new CommentsVo();

		commentsVo.setComments_content(comments_content);

		commentsVo.setPost_code(post_code);

		commentsService.insertComments(commentsVo);

		response.sendRedirect("/postDetail?post_code=" + post_code);
	}

}