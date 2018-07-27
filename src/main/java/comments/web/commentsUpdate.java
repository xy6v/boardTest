package comments.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
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

@WebServlet("/commentsUpdate")
@MultipartConfig(maxFileSize = 1024 * 1000 * 3, maxRequestSize = 1024 * 1000 * 15)
public class commentsUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int post_code = Integer.parseInt(request.getParameter("post_code"));
		int comments_code = Integer.parseInt(request.getParameter("comments_code"));
		System.out.println(comments_code);

		// 정보 조회 (service)
		CommentsServiceInf commentsService = new CommentsService();
		commentsService.deleteComments(comments_code);
		// 파라미터로 받은 값을 vo에 설정
		
		//redirect:/student/studentDetail.jsp?id="+id 로  주소창이다른것으로 바뀌기 때문에 깔끔해서!
		//조회화면으로 이동
		response.sendRedirect("/postDetail?post_code="+post_code+"&comments_code="+comments_code);
		

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		// 파라미터 확인
	
	}

}
