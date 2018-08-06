package post.web;

import java.io.File;
import java.io.IOException;
import java.util.Collection;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import post.model.PostVo;
import post.service.PostService;
import post.service.PostServiceInf;
import upload.model.UploadVo;
import upload.service.UploadService;
import upload.service.UploadServiceInf;

/**
 * Servlet implementation class postRpServlet
 */
@WebServlet("/postRplist")
@MultipartConfig(maxFileSize = 1024 * 1000 * 3, maxRequestSize = 1024 * 1000 * 15)
public class postRpServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private Logger logger = LoggerFactory.getLogger(postRpServlet.class);
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		PostServiceInf postService = new PostService();
		UploadServiceInf uploadService = new UploadService();
		int board_code = Integer.parseInt(request.getParameter("board_code"));
		
		int post_parent =Integer.parseInt(request.getParameter("post_parent"));
		logger.debug("{}","request.getParameter : "+request.getParameter("board_code"));
		System.out.println("보드코드:ㅣㅣㅣㅣ"+board_code);
		/*int post_parent = Integer.parseInt(request.getParameter("post_parent"));*/
	
		/*String post_parent = request.getParameter("post_parent");*/
		String std_id= (String) request.getSession().getAttribute("std_id");
		String name = request.getParameter("post_name");
		String content = request.getParameter("post_content");
		
	/*	System.out.println("1이런시발2좆됫구요:"+post_parent);*/
		System.out.println("2이런시발:"+post_parent);
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
		postVo.setPost_parent(post_parent);

		int insertCnt = postService.postRp(postVo);
		
	
		Collection<Part> file = request.getParts();
		
		for(Part p : file){
			if(p.getContentType() != null){
				if(p.getSize()>0){
					String contentDisposition = p.getHeader("Content-Disposition");
					String fileName = FileUtil.getFileName(contentDisposition);
					
					if(fileName!=null){
						String uploadPath = FileUtil.fileUploadPath;
						String upload= UUID.randomUUID().toString();
						p.write(uploadPath+File.separator+upload);
						p.delete();
						UploadVo uploadVo= new UploadVo();
						uploadVo.setUploadname(fileName);
						uploadVo.setUploadpath(uploadPath);
						uploadVo.setUpload(upload);
						
						int insertUpload = uploadService.insertUpload(uploadVo);
					}
					
				}
			}
		System.out.println(insertCnt);
		/*response.sendRedirect("/postList?page=1&pageSize=10&board_code=" + board_code);*/
		                        
	}
		response.sendRedirect("/postList?board_code=" + board_code);
	}
}


